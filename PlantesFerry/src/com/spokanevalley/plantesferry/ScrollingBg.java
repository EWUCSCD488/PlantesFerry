package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ScrollingBg
  extends Actor
{
  public ScrollingBg(float paramFloat1, float paramFloat2)
  {
    setWidth(paramFloat1);
    setHeight(paramFloat2);
    setPosition(paramFloat1, 0.0F);
    addAction(Actions.forever(Actions.sequence(Actions.moveTo(0.0F, 0.0F, 1.0F), Actions.moveTo(paramFloat1, 0.0F))));
  }
  
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    super.draw(paramSpriteBatch, paramFloat);
    paramSpriteBatch.draw(Assets.river, getX() - getWidth(), getY(), 2.0F * getWidth(), getHeight());
  }
}
