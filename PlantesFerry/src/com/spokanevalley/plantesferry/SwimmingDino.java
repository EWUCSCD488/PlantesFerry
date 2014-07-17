package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class SwimmingDino extends Actor {
  private Rectangle bounds = new Rectangle();
  private PlantesFerry plantesferry;
  private int row;
  GameOver gameover;
  
  /*
   * Constructor for the swimming dinosaur
   * Starts the character in the middle row
   * The character can only move up or down between rows
   */
  public SwimmingDino(PlantesFerry paramPlantesFerry)
  {
    this.plantesferry = paramPlantesFerry;
    setWidth(Assets.playerDino.getRegionWidth());
    setHeight(Assets.playerDino.getRegionHeight());
    this.row = 1;
    paramPlantesFerry.getClass();
    setPosition(100.0F, 240.0F - getHeight() / 2.0F);
  } // End Constructor
  
  /*
   * Divides the rectangle container into 3 rows.
   * This allows the user to move between these 3 rows upon swiping.
   * The speed of switching a row is 0.35
   */
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
      addAction(Actions.moveTo(f3, 90.0F - getHeight() / 2.0F, 0.35F));
      return;
    case 1: 
      float f2 = getX();
      this.plantesferry.getClass();
      addAction(Actions.moveTo(f2, 240.0F - getHeight() / 2.0F, 0.35F));
      return;
    case 2:
      float f1 = getX();
      this.plantesferry.getClass();
      addAction(Actions.moveTo(f1, 390.0F - getHeight() / 2.0F, 0.35F));
      return;
    } // End switch
  } // End moveToLane
  
  /*
   * Updates the bounds of the game screen
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
   * Draws the swimming dinosaur
   */
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    paramSpriteBatch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
    if(Assets.isInvinsible)
    	paramSpriteBatch.draw(Assets.bubble, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
    paramSpriteBatch.draw(Assets.playerDino, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
  } // End draw
  
  /*
   * Get bounds of rectangle container
   */
  public Rectangle getBounds()
  {
    return this.bounds;
  } // End getBounds
  
  /* 
   * Move player up if possible
   */
  public void tryMoveDown()
  {
    if ((getActions().size == 0) && (this.row != 0))
      moveToLane(-1 + this.row);
  } // End tryMoveDown
  
  /*
   * Move player down if possible
   */
  public void tryMoveUp()
  {
    if ((getActions().size == 0) && (this.row != 2))
      moveToLane(1 + this.row);
  } // End tryMoveUp
  
  /*
   * Upon collision, removes the main character from the game.
   */
  public void collision(boolean paramBoolean1, boolean paramBoolean2)
  {
	if(!Assets.isInvinsible)
	{
    Assets.lives--;
    if(Assets.lives < 1)
    {
    	Assets.lives = 0;
    	//gameover = new GameOver();
        //clearActions();
        //addAction(Actions.rotateBy(360));
        //addAction(Actions.fadeOut(1.0F));
        //addAction(Actions.removeActor());
    }
	} // End not invinsible check
    //TODO: ADD message requesting to play again
  } // End collision
  
} // End SwimmingDino