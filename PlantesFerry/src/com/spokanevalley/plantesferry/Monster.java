package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Monster extends Actor {

  private Rectangle bounds = new Rectangle();
  private final String rareMonster = "rare";
  
  /*
   * Creates a River Monster and renders it a color based on 3 different possible colors.
   */
  public Monster(float paramFloat1, float paramFloat2)
  {
    setWidth(Assets.monster.getRegionWidth());
    setHeight(Assets.monster.getRegionHeight());
    setPosition(paramFloat1, paramFloat2 - getHeight() / 2.0F);
    
    int rand = MathUtils.random(0, 2);
    if (rand == 0) {
      setColor(Color.ORANGE);
    }
    if (rand == 1) {
      setColor(Color.GREEN);
    }
    if (rand == 2) {
      setColor(Color.YELLOW);
    }
    int rare = MathUtils.random(0, 25);
    
    if(rare == 25)
    	setName(rareMonster);
    
    // Adjust speed of Monsters here :(1.5, 4.5) = Most Balanced Speed
    addAction(Actions.moveTo(-getWidth(), getY(), MathUtils.random(1.85F, 3.75F)));
    
  }// End RiverMonsters Constructor
  
  /*
   * Sets bounds in which monsters can be spawned.
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
   * Upon collision, removes the River Monster with a fade out and 360 rotation.
   * Plays a sound effect upon collision
   * If invinsible, each monster knocked out adds three points to the total score.
   */
  public void collision(boolean paramBoolean1, boolean paramBoolean2)
  {
    clearActions();
    
    if(Assets.isInvinsible)
    {
    	if(getName() == rareMonster)
    		Assets.score += 6;
    	else
    		Assets.score += 3;
    	
        Assets.invinsibleSound.stop();
        Assets.invinsibleSound.play();
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
    } // End Invisible
    else
    {
    	Assets.monsterSound.stop();
    	Assets.monsterSound.play();
    	addAction(Actions.fadeOut(0.2F));
    	addAction(Actions.removeActor());
    } // End Not Invinsible
    
  } // End collision
  
  /*
   * Draws the Monster or Rare Monster object.
   */
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    paramSpriteBatch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
    
    if(getName() == rareMonster)
        paramSpriteBatch.draw(Assets.rareMonster, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
    else
    	paramSpriteBatch.draw(Assets.monster, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());

  } // End draw
  
  public Rectangle getBounds()
  {
    return this.bounds;
  } // End getBounds
  
} // End Monster
