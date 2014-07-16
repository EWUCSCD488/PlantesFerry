package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class CheckPoint extends Actor {

	  private Rectangle bounds = new Rectangle();
	  GameTimer timer;
	  
	  /*
	   * Creates a CheckPoint object
	   */
	  public CheckPoint(float paramFloat1, float paramFloat2)
	  {
		setWidth(Assets.checkpoint.getRegionWidth());
		setHeight(Assets.checkpoint.getRegionHeight());
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
	   * Upon collision, Checkpoint adds time to the game timer.
	   */
	  public void collision(boolean paramBoolean1, boolean paramBoolean2)
	  {
	    clearActions();
	    Assets.checkpointSound.stop();
	    Assets.checkpointSound.play();
	    //timer.addTime();
	    addAction(Actions.fadeOut(1.0F));
	    if ((paramBoolean1) && (paramBoolean2)) {
	        addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(-360.0F, 1.5F), Actions.moveBy(200.0F, 200.0F, 1.5F)), Actions.removeActor()));
	      }
	      if ((paramBoolean1) && (!paramBoolean2)) {
	        addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(360.0F, 1.5F), Actions.moveBy(200.0F, -200.0F, 1.5F)), Actions.removeActor()));
	      }
	      if ((!paramBoolean1) && (paramBoolean2)) {
	        addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(360.0F, 1.5F), Actions.moveBy(-200.0F, 200.0F, 1.5F)), Actions.removeActor()));
	      }
	      if ((!paramBoolean1) && (!paramBoolean2)) {
	        addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(-360.0F, 1.5F), Actions.moveBy(-200.0F, -200.0F, 1.5F)), Actions.removeActor()));
	      }

	  } // End collision
	  
	  /*
	   * Draws the CheckPoint object.
	   */
	  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
	  {
	    paramSpriteBatch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);

	    paramSpriteBatch.draw(Assets.checkpoint, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
	  } // End draw
	  
	  public Rectangle getBounds()
	  {
	    return this.bounds;
	  } // End getBounds
}
