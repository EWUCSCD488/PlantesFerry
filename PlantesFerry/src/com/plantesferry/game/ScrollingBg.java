package com.plantesferry.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ScrollingBg extends Actor {

/*
 * Constructor for Scrolling Background
 * Repeats the background image every 18 seconds
 */
public ScrollingBg(float paramFloat1, float paramFloat2)
{
	setWidth(Assets.underwaterbg.getRegionWidth());
	setHeight(Assets.underwaterbg.getRegionHeight());
    setPosition(paramFloat1, 0.0F);
    // Set the speed of scrolling background here : 18.0F = current speed
    addAction(Actions.forever(Actions.sequence(Actions.moveTo(0.0F, 0.0F, 18.0F), Actions.moveTo(Assets.underwaterbg.getRegionWidth(), 0.0F))));
} // End Constructor
  
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    super.draw(paramSpriteBatch, paramFloat);
    paramSpriteBatch.draw(Assets.underwaterbg, getX() - getWidth(), getY(), 2.0F * getWidth(), getHeight());
  } // End draw
  
} // End ScrollingBg

