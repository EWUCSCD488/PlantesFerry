package com.spokanevalley.plantesferry;

import java.util.Iterator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class PlantesFerry extends Table {

  private long lastMonsterSpawnTime = 0L;
  private Array <Monster> monsters;
  public SwimmingDino playerCanoe;
  private ScrollingBg river;
  public final float row1 = 90.0F;
  public final float row2 = 240.0F;
  public final float row3 = 390.0F;

  /*
   * Constructor for PlantesFerry Game
   * Sets the bounds, and enable content clipping
   * Adds the river, player, and array of Monsters
   */
  public PlantesFerry()
  {
	// Bounds
    setBounds(0.0F, 0.0F, 800.0F, 480.0F);
    setClip(true);
    // Characters and Background
    this.river = new ScrollingBg(getWidth(), getHeight());
    addActor(this.river);
    this.playerCanoe = new SwimmingDino(this);
    addActor(this.playerCanoe);
    this.monsters = new Array<Monster>();
    
  } // End PlantesFerry Constructor

  /*
   * Spawns a River Monster in one of the three rows randomly.
   */
  private void spawnRiverMonster()
  {
    int rand = MathUtils.random(0, 2);
    float row = 0.0F;
    if (rand == 0)
    	row = 90.0F;
    if (rand == 1)
    	row = 240.0F;
    if (rand == 2)
    	row = 390.0F;
   
    Monster localRiverMonster = new Monster(getWidth(), row);
    this.monsters.add(localRiverMonster);
    addActor(localRiverMonster);
    this.lastMonsterSpawnTime = TimeUtils.nanoTime();
  } // End spawnRiverMonster
  
  /*
   * Iterate through the Arraylist of Monsters
   * Remove Monsters that leave the rectangle bounds
   * Check for collision between player and Monster 
   */
  public void act(float paramFloat)
  {	
    super.act(paramFloat);
    
    // Change monster spawn time here : 0.75E = current time
    if ((float)(TimeUtils.nanoTime() - this.lastMonsterSpawnTime) > 0.75E+009F)
    	spawnRiverMonster();

    Iterator<Monster> monsterIterator = this.monsters.iterator();
    // Iterate and handle collisions / out of bound elements
    for (;;)
    {    	
      if (!monsterIterator.hasNext())
    	  return;
    
      Monster localRiverMonster = (Monster)monsterIterator.next();
      
      // Check if monster is outside of bounds
      boundsCheck(localRiverMonster, monsterIterator);

      // Check collision between monster and player
      collisionCheck(localRiverMonster, monsterIterator);
        
    } // End continuous for loop
  } // End act
  
  /*
   * Checks collision between monster and player.
   * Upon collision, the monster is removed.
   */
  private void collisionCheck(Monster localRiverMonster, Iterator<Monster> monsterIterator) {
      if (localRiverMonster.getBounds().overlaps(this.playerCanoe.getBounds())) {
    	  
        monsterIterator.remove();
        System.out.println("Size: " + this.monsters.size); // Print size --> REMOVE
        
        if (localRiverMonster.getX() > this.playerCanoe.getX()) {
        
          if (localRiverMonster.getY() > this.playerCanoe.getY()) {
            localRiverMonster.collision(true, true);
            
            //this.playerCanoe.collision(true, true);
          } else {
            localRiverMonster.collision(true, false);
            //this.playerCanoe.collision(true, false);
          }
        }
        else if (localRiverMonster.getY() > this.playerCanoe.getY()) {
          localRiverMonster.collision(false, true);
          //this.playerCanoe.collision(false, true);
        } else {
          localRiverMonster.collision(false, false);
          //this.playerCanoe.collision(false, false);
        }
      } // End if collision check 
      
  } // End collisionCheck
  
  /*
   * Checks if a monster is outside of the set rectangle bounds.
   * Upon being out of bounds, the monster is removed.
   */
  private void boundsCheck(Monster localRiverMonster, Iterator<Monster> monsterIterator) {
      
	  if (localRiverMonster.getBounds().x + localRiverMonster.getWidth() < 0.1F)
      {
        monsterIterator.remove();
        removeActor(localRiverMonster);
        System.out.println("Size: " + this.monsters.size); // Print size --> REMOVE
      } // End if out of bounds check
	  
  } // End boundsCheck
  
  /*
   * Draws the in game sprites as well as the timer font
   */
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    paramSpriteBatch.setColor(Color.WHITE);
    super.draw(paramSpriteBatch, paramFloat);
  } // End draw
  
} // End PlantesFerry
