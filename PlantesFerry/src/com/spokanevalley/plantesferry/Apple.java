package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Apple extends Actor {

	  private Rectangle bounds = new Rectangle();
	  
	  /*
	   * Creates a Apple object
	   */
	  public Apple(float paramFloat1, float paramFloat2)
	  {
		setWidth(Assets.apple.getRegionWidth());
		setHeight(Assets.apple.getRegionHeight());
	    setPosition(paramFloat1, paramFloat2 - getHeight() / 2.0F);
	    addAction(Actions.moveTo(-getWidth(), getY(), MathUtils.random(4.0F, 6.0F)));
	  }// End CheckPoint Constructor
	  
	  /*
	   * Sets bounds in which checkpoints can be spawned.
	   */
	  private void updateBounds()
	  {
	    this.bounds.set(getX(), getY(), getWidth(), getHeight());
	  } // End updateBounds
	  
	  public void act(float paramFloat)
	  {
	    super.act(paramFloat);
	    updateBounds();
	  } // End act
	  
	  /*
	   * Upon collision, Apple adds one point to total score.
	   */
	  public void collision(boolean paramBoolean1, boolean paramBoolean2)
	  {
	    clearActions();
	    Assets.appleSound.stop();
	    Assets.appleSound.play();
	    addAction(Actions.fadeOut(0.1F));
	    Actions.removeActor();
	    Assets.score++;
	  } // End collision
	  
	  /*
	   * Draws the Apple object.
	   */
	  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
	  {
	    paramSpriteBatch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
	    paramSpriteBatch.draw(Assets.apple, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
	  } // End draw
	  
	  public Rectangle getBounds()
	  {
	    return this.bounds;
	  } // End getBounds
}
