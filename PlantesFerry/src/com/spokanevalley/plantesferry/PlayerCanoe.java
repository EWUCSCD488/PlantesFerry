package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class PlayerCanoe
  extends Actor
{
  private Rectangle bounds = new Rectangle();
  private PlantesFerry plantesferry;
  private int row;
  
  public PlayerCanoe(PlantesFerry paramPlantesFerry)
  {
    this.plantesferry = paramPlantesFerry;
    setWidth(160.0F);
    setHeight(85.0F);
    this.row = 1;
    paramPlantesFerry.getClass();
    setPosition(100.0F, 240.0F - getHeight() / 2.0F);
  }
  
  private void moveToLane(int paramInt)
  {
    this.row = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      float f3 = getX();
      this.plantesferry.getClass();
      addAction(Actions.moveTo(f3, 90.0F - getHeight() / 2.0F, 0.5F));
      return;
    case 1: 
      float f2 = getX();
      this.plantesferry.getClass();
      addAction(Actions.moveTo(f2, 240.0F - getHeight() / 2.0F, 0.5F));
      return;
    case 2:
      float f1 = getX();
      this.plantesferry.getClass();
      addAction(Actions.moveTo(f1, 390.0F - getHeight() / 2.0F, 0.5F));
      return;
    }
  }
  
  private void updateBounds()
  {
    this.bounds.set(getX(), getY(), getWidth(), getHeight());
  }
  
  public void act(float paramFloat)
  {
    super.act(paramFloat);
    updateBounds();
  }
  
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    paramSpriteBatch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
    paramSpriteBatch.draw(Assets.playerCanoe, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
  }
  
  public Rectangle getBounds()
  {
    return this.bounds;
  }
  
  public void tryMoveDown()
  {
    if ((getActions().size == 0) && (this.row != 0)) {
      moveToLane(-1 + this.row);
    }
  }
  
  public void tryMoveUp()
  {
    if ((getActions().size == 0) && (this.row != 2)) {
      moveToLane(1 + this.row);
    }
  }
}