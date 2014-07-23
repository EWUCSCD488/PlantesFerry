package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen, GestureDetector.GestureListener {
  private PlantesFerry plantesferry = new PlantesFerry();
  private Stage stage = new Stage();
  BitmapFont scoreFont;
  SpriteBatch paramSpriteBatch;
  GameState state = GameState.PLAY;
	
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
    	this.plantesferry.playerDino.tryMoveUp();
    if (paramFloat2 > 100.0F)
    	this.plantesferry.playerDino.tryMoveDown();
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
  public void render(float delta)
  {
	  switch(this.state) {
	  	case PLAY:
	  		Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
	  		Gdx.gl.glClear(16384);
	  		this.stage.act(delta);
	  		this.stage.draw();
	  		displayStats();
	  		break;
	  	case PAUSE:
	  		pause();
	  		break;
	  	case STOP:
	  		dispose();
	  		break;
	  	case RESTART:
	  		break;
	  	default:
	  		break;
	} // End switch
  } // End render
  
  /*
   * Displays the current score and number of lives.
   * Also plays the background music.
   */
  private void displayStats() {
	    // Display Apple Icon and Score (Bottom Left)
		this.paramSpriteBatch.begin();
		this.paramSpriteBatch.draw(Assets.apple, 85, 15);
		this.scoreFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		this.scoreFont.setScale(2.5f);
		this.scoreFont.draw(this.paramSpriteBatch, ""+ Assets.score, 125, 60);
		//this.scoreFont.draw(this.paramSpriteBatch, ""+ Assets.score, (Gdx.graphics.getWidth() / 3), (Gdx.graphics.getHeight() / 4));
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
		if(Assets.isInvinsible)
		{
			this.paramSpriteBatch.draw(Assets.bubble, 110, 1015);
			this.scoreFont.draw(this.paramSpriteBatch, ""+ (int)((11.0E+009F - (TimeUtils.nanoTime() - Assets.isInvinsibleTime)) / 1000000000), 125, 1075);
		}
		//this.timerFont.draw(paramSpriteBatch, ""+paramFloat, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		this.paramSpriteBatch.end();
		
	    // Set background music and loop it forever
	    Assets.backgroundMusic.play();
	    Assets.backgroundMusic.setLooping(true);
  }
  
  /*
   * Sets the Viewport to the size of the game: 800 x 480 = current size.
   */
  public void resize(int paramInt1, int paramInt2)
  {
    this.stage.setViewport(800.0F, 480.0F, true);
    this.stage.getCamera().translate(-this.stage.getGutterWidth(), -this.stage.getGutterHeight(), 0.0F);
  } // End resize
  
  /*
   * Pauses the background music.
   * Displays the menu background image with text.
   * User must tap once to resume game.
   */
  public void pause() {
	  Assets.backgroundMusic.pause();
	  this.paramSpriteBatch.begin();
	  paramSpriteBatch.draw(Assets.menubg, 0.0F, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	  this.scoreFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
	  this.scoreFont.setScale(2.5f);
	  this.scoreFont.draw(this.paramSpriteBatch, "Paused", Gdx.graphics.getWidth() / 2.0F, Gdx.graphics.getHeight() / 2.0F);
	  this.paramSpriteBatch.end();
	  this.paramSpriteBatch.begin();
	  this.scoreFont.setScale(1.5f);
	  this.scoreFont.draw(this.paramSpriteBatch, "Tap Once to resume", (Gdx.graphics.getWidth() / 2.0F) - 50.0F, (Gdx.graphics.getHeight() / 2.0F) - 100.0F);
	  this.paramSpriteBatch.end();
  } // End pause
  
  /*
   * Sets the Input Processor to handle touch events.
   * Sets the Game music to repeat.
   */
  public void show()
  {
    Gdx.input.setInputProcessor(new GestureDetector(this));
  } // End show()
  
  public boolean tap(float paramFloat1, float paramFloat2, int tapNum, int paramInt2) { 
	  if(tapNum > 1)
		  this.state = GameState.PAUSE;
	  if(tapNum == 1)
		  this.state = GameState.PLAY;
	  return false; 
  } // End tap
  
  /* Unimplemented methods */
  public void resume() {}
  
  public boolean longPress(float paramFloat1, float paramFloat2) { return false; } // End longPress
  
  public boolean pan(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return false; } // End pan
  
  public boolean pinch(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24) { return false; } // End pinch
  
  public boolean touchDown(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) { return false; } // End touchDown
  
  public boolean zoom(float paramFloat1, float paramFloat2){ return false; } // End zoom
  
} // End GameScreen
