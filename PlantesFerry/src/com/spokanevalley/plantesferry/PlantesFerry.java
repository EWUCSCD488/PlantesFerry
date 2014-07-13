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
  private long lastMonsterSpawnTime = 0L;
  private Array <Monster> monsters;
  public SwimmingDino playerCanoe;
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
    this.playerCanoe = new SwimmingDino(this);
    addActor(this.playerCanoe);
    this.monsters = new Array<Monster>();
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
   
    Monster localRiverMonsters = new Monster(getWidth(), row);
    this.monsters.add(localRiverMonsters);
    addActor(localRiverMonsters);
    this.lastMonsterSpawnTime = TimeUtils.nanoTime();
  }
  
  /*
   * Iterate through the Arraylist of Monsters
   * Remove Monsters that leave the rectangle bounds
   * Check for collision between player and Monster 
   */
  public void act(float paramFloat)
  {	
    super.act(paramFloat);
    // Change monster spawn time here
    if ((float)(TimeUtils.nanoTime() - this.lastMonsterSpawnTime) > 0.8E+009F) {
      spawnRiverMonster();
    }
    
    Iterator<Monster> monsterIterator = this.monsters.iterator();

    for (;;)
    {
      if (!monsterIterator.hasNext()) {
        return;
      }
      
      Monster localRiverMonsters = (Monster)monsterIterator.next();
      
      if (localRiverMonsters.getBounds().x + localRiverMonsters.getWidth() <= 0.0F)
      {
        monsterIterator.remove();
        removeActor(localRiverMonsters);
      }

      
      if (localRiverMonsters.getBounds().overlaps(this.playerCanoe.getBounds()))
      {
        monsterIterator.remove();
        if (localRiverMonsters.getX() > this.playerCanoe.getX())
        {
        	//timer.addTime();// REMOVE
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
  /*
   * Draws the in game sprites as well as the timer font
   */
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
	timerFont.setScale(2.5f);
	timerFont.draw(batch, timer.toString(), 25, 160);
	batch.end();
  }
}