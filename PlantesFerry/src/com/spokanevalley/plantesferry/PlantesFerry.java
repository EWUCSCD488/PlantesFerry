package com.spokanevalley.plantesferry;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class PlantesFerry
  extends Table
{
  private long lastSpawnTime = 0L;
  private Array <RiverMonster> monsters;
  public PlayerCanoe playerCanoe;
  private ScrollingBg river;
  public final float row1 = 90.0F;
  public final float row2 = 240.0F;
  public final float row3 = 390.0F;
  GameTimer timer = new GameTimer();
  BitmapFont timerFont;
  SpriteBatch batch;
  
public PlantesFerry()
  {
    setBounds(0.0F, 0.0F, 800.0F, 480.0F);
    setClip(true);
    this.river = new ScrollingBg(getWidth(), getHeight());
    addActor(this.river);
    this.playerCanoe = new PlayerCanoe(this);
    addActor(this.playerCanoe);
    this.monsters = new Array<RiverMonster>();
  }
  /*
   * Spawns a River Monster in one of the three rows randomly.
   */
  private void spawnRiverMonster()
  {
    int i = MathUtils.random(0, 2);
    float row = 0.0F;
    if (i == 0) {
      row = 90.0F;
    }
    if (i == 1) {
      row = 240.0F;
    }
    if (i == 2) {
      row = 390.0F;
    }
    RiverMonster localRiverMonsters = new RiverMonster(getWidth(), row);
    this.monsters.add(localRiverMonsters);
    addActor(localRiverMonsters);
    this.lastSpawnTime = TimeUtils.nanoTime();
  }
  
  public void act(float paramFloat)
  {	
    super.act(paramFloat);
    if ((float)(TimeUtils.nanoTime() - this.lastSpawnTime) > 3.0E+009F) {
      spawnRiverMonster();
    }
    Iterator<RiverMonster> localIterator = this.monsters.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      RiverMonster localRiverMonsters = (RiverMonster)localIterator.next();
      if (localRiverMonsters.getBounds().x + localRiverMonsters.getWidth() <= 0.0F)
      {
        localIterator.remove();
        removeActor(localRiverMonsters);
      }
      if (localRiverMonsters.getBounds().overlaps(this.playerCanoe.getBounds()))
      {
        localIterator.remove();
        if (localRiverMonsters.getX() > this.playerCanoe.getX())
        {
          if (localRiverMonsters.getY() > this.playerCanoe.getY()) {
            localRiverMonsters.collision(true, true);
            //this.playerCanoe.collision(true, true);
          } else {
            localRiverMonsters.collision(true, false);
            //this.playerCanoe.collision(true, false);
          }
        }
        else if (localRiverMonsters.getY() > this.playerCanoe.getY()) {
          localRiverMonsters.collision(false, true);
          //this.playerCanoe.collision(false, true);
        } else {
          localRiverMonsters.collision(false, false);
          //this.playerCanoe.collision(false, false);
        }
      }
    }
  }
  
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    paramSpriteBatch.setColor(Color.WHITE);
    super.draw(paramSpriteBatch, paramFloat);
    // Start current in game timer
	timer.start();
	batch = new SpriteBatch();
	timerFont = new BitmapFont(Gdx.files.internal("fonts/gamefont.fnt"),
	         Gdx.files.internal("fonts/gamefont_0.png"), false);
	// Display timer font on screen
	batch.begin();
	timerFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
	timerFont.setScale(2.0f);
	timerFont.draw(batch, timer.toString(), 25, 160);
	batch.end();
  }
}