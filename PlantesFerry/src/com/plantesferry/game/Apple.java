package com.plantesferry.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.TimeUtils;

public class Apple extends Actor {

	  private Rectangle bounds = new Rectangle();
	  private final String invinsibleBubble = "Bubble";
	  /*
	   * Creates a Apple object
	   */
	  public Apple(float paramFloat1, float paramFloat2)
	  {
		setWidth(Assets.apple.getRegionWidth());
		setHeight(Assets.apple.getRegionHeight());
	    setPosition(paramFloat1, paramFloat2 - getHeight() / 2.0F);
	    
	    int rand = MathUtils.random(0, 25);
	    
	    if(rand == 25)
	    	setName(invinsibleBubble);

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
	   * Upon collision, Apple adds one point to total score, bubble adds three points to the total score.
	   * Upon collision with bubble, the player becomes invinsible for 10 seconds, 
	   * allowing collision with monster without any harm to player.
	   */
	  public void collision(boolean paramBoolean1, boolean paramBoolean2)
	  {
		
		clearActions();
		
		if(getName() == invinsibleBubble)
		{
		    Assets.invinsibleBubbleleSound.stop();
		    Assets.invinsibleBubbleleSound.play();
	    	Assets.isInvinsible = true;
	    	Assets.isInvinsibleTime = TimeUtils.nanoTime();
	    	Assets.score += 3;
		}
		else
		{
			Assets.appleSound.stop();
			Assets.appleSound.play();
			Assets.score++;
		}
		
	    addAction(Actions.fadeOut(0.1F));
	    Actions.removeActor();
	    
	  } // End collision
	  
	  /*
	   * Draws the Apple or Rare Invinsibility Bubble object.
	   */
	  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
	  {
	    paramSpriteBatch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
	    if(getName() == invinsibleBubble)
		    paramSpriteBatch.draw(Assets.bubble, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
	    else
	    	paramSpriteBatch.draw(Assets.apple, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
	  } // End draw
	  
	  public Rectangle getBounds()
	  {
	    return this.bounds;
	  } // End getBounds
}
