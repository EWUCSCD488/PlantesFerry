package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.Iterator;

public class PlantesFerry
  extends Table
{
  private long lastSpawnTime = 0L;
  private Array<RiverObjects> obstructions;
  public PlayerCanoe playerCanoe;
  private ScrollingBg river;
  public final float row1 = 90.0F;
  public final float row2 = 240.0F;
  public final float row3 = 390.0F;
  
public PlantesFerry()
  {
    setBounds(0.0F, 0.0F, 800.0F, 480.0F);
    setClip(true);
    this.river = new ScrollingBg(getWidth(), getHeight());
    addActor(this.river);
    this.playerCanoe = new PlayerCanoe(this);
    addActor(this.playerCanoe);
    this.obstructions = new Array<RiverObjects>();
  }
  
  private void spawnObstruction()
  {
    int i = MathUtils.random(0, 2);
    float f = 0.0F;
    if (i == 0) {
      f = 90.0F;
    }
    if (i == 1) {
      f = 240.0F;
    }
    if (i == 2) {
      f = 390.0F;
    }
    RiverObjects localRiverObjects = new RiverObjects(getWidth(), f);
    this.obstructions.add(localRiverObjects);
    addActor(localRiverObjects);
    this.lastSpawnTime = TimeUtils.nanoTime();
  }
  
  public void act(float paramFloat)
  {
    super.act(paramFloat);
    if ((float)(TimeUtils.nanoTime() - this.lastSpawnTime) > 3.0E+009F) {
      spawnObstruction();
    }
    Iterator<RiverObjects> localIterator = this.obstructions.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      RiverObjects localRiverObjects = (RiverObjects)localIterator.next();
      if (localRiverObjects.getBounds().x + localRiverObjects.getWidth() <= 0.0F)
      {
        localIterator.remove();
        removeActor(localRiverObjects);
      }
      if (localRiverObjects.getBounds().overlaps(this.playerCanoe.getBounds()))
      {
        localIterator.remove();
        if (localRiverObjects.getX() > this.playerCanoe.getX())
        {
          if (localRiverObjects.getY() > this.playerCanoe.getY()) {
            localRiverObjects.collision(true, true);
          } else {
            localRiverObjects.collision(true, false);
          }
        }
        else if (localRiverObjects.getY() > this.playerCanoe.getY()) {
          localRiverObjects.collision(false, true);
        } else {
          localRiverObjects.collision(false, false);
        }
      }
    }
  }
  
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    paramSpriteBatch.setColor(Color.WHITE);
    super.draw(paramSpriteBatch, paramFloat);
  }
}