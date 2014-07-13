package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ScrollingBg extends Actor {

/*
 * Constructor for Scolling Background
 * Repeats the background image every 30 seconds
 */
public ScrollingBg(float paramFloat1, float paramFloat2)
{
	setWidth(Assets.underwaterbg.getRegionWidth());
	setHeight(Assets.underwaterbg.getRegionHeight());
    setPosition(paramFloat1, 0.0F);
    addAction(Actions.forever(Actions.sequence(Actions.moveTo(0.0F, 0.0F, 18.0F), Actions.moveTo(Assets.underwaterbg.getRegionWidth(), 0.0F))));
}
  
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    super.draw(paramSpriteBatch, paramFloat);
    paramSpriteBatch.draw(Assets.underwaterbg, getX() - getWidth(), getY(), 2.0F * getWidth(), getHeight());
  }
}
