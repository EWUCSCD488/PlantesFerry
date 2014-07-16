package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen, GestureDetector.GestureListener {
  private PlantesFerry plantesferry = new PlantesFerry();
  private Stage stage = new Stage();
  BitmapFont scoreFont;
  SpriteBatch paramSpriteBatch;
  
  /*
   * Set the game stage and initialized the score font.
   */
  public GameScreen()
  {
    this.stage.addActor(this.plantesferry);
    
	this.scoreFont = new BitmapFont(Gdx.files.internal("fonts/gamefont.fnt"),
  									Gdx.files.internal("fonts/gamefont_0.png"), false);
	this.paramSpriteBatch = new SpriteBatch();
  } // End Constructor
  
  /*
   * Dispose of any sprite batch used in game.
   */
  public void dispose() {
	  this.paramSpriteBatch.dispose();
  } // End dispose
  
  /*
   * When a fling gesture is detected, try to move up or down if possible.
   */
  public boolean fling(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramFloat2 < -100.0F)
    	this.plantesferry.playerCanoe.tryMoveUp();
    if (paramFloat2 > 100.0F)
    	this.plantesferry.playerCanoe.tryMoveDown();
    return false;
  } // End fling
  
  /*
   * Disable the Input Processor when the game is minimized.
   */
  public void hide()
  {
    Gdx.input.setInputProcessor(null);
  } // End hide
  
  /*
   * Renders and displays the background and moving sprites
   * Displays the number of lives and score
   */
  public void render(float paramFloat)
  {
    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Gdx.gl.glClear(16384);
    this.stage.act(paramFloat);
    this.stage.draw();
    displayStats();
  } // End render
  
  /*
   * Displays the current score and number of lives.
   */
  private void displayStats() {
	    // Display Apple Icon and Score (Bottom Left)
		this.paramSpriteBatch.begin();
		this.paramSpriteBatch.draw(Assets.apple, 85, 15);
		this.scoreFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		this.scoreFont.setScale(2.5f);
		this.scoreFont.draw(this.paramSpriteBatch, ""+ Assets.score, 125, 60);
		// Display Lives (Top Right)
		if(Assets.lives > 0)
		{
			if(Assets.lives > 2)
			{
				this.paramSpriteBatch.draw(Assets.playerDino, 1625, 1000);
				this.paramSpriteBatch.draw(Assets.playerDino, 1700, 1000);
				this.paramSpriteBatch.draw(Assets.playerDino, 1775, 1000);
			}
			if(Assets.lives == 2)
			{
				this.paramSpriteBatch.draw(Assets.playerDino, 1625, 1000);
				this.paramSpriteBatch.draw(Assets.playerDino, 1700, 1000);
			}
			if(Assets.lives == 1)
				this.paramSpriteBatch.draw(Assets.playerDino, 1625, 1000);
		}
		//this.timerFont.draw(paramSpriteBatch, ""+paramFloat, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		this.paramSpriteBatch.end();
  }
  
  /*
   * Sets the Viewport to the size of the game: 800 x 480 = current size.
   */
  public void resize(int paramInt1, int paramInt2)
  {
    this.stage.setViewport(800.0F, 480.0F, true);
    this.stage.getCamera().translate(-this.stage.getGutterWidth(), -this.stage.getGutterHeight(), 0.0F);
  } // End resize
  
  public void resume() {}
  
  public void pause() {}
  
  /*
   * Sets the Input Processor to handle touch events.
   * Sets the Game music to repeat.
   */
  public void show()
  {
    Gdx.input.setInputProcessor(new GestureDetector(this));
    // Set background music and loop it forever
    Assets.backgroundMusic.play();
    Assets.backgroundMusic.setLooping(true);
  } // End show()
  
  /* Unimplemented methods */
  public boolean longPress(float paramFloat1, float paramFloat2) { return false; } // End longPress
  
  public boolean pan(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return false; } // End pan
  
  public boolean pinch(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24) { return false; } // End pinch
  
  public boolean tap(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) { return false; } // End tap
  
  public boolean touchDown(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) { return false; } // End touchDown
  
  public boolean zoom(float paramFloat1, float paramFloat2){ return false; } // End zoom
  
} // End GameScreen
