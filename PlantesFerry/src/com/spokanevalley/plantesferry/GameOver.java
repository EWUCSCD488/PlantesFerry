package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameOver implements Screen, GestureListener {

	  //private PlantesFerry plantesferry = new PlantesFerry();
	  private Stage stage = new Stage();
	  BitmapFont scoreFont;
	  SpriteBatch paramSpriteBatch;
	  
	public GameOver() {
	    //this.stage.addActor(this.plantesferry);
	    
		this.scoreFont = new BitmapFont(Gdx.files.internal("fonts/gamefont.fnt"),
	  									Gdx.files.internal("fonts/gamefont_0.png"), false);
		this.paramSpriteBatch = new SpriteBatch();
	}
	  
	@Override
	public void render(float delta) {
	    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
	    Gdx.gl.glClear(16384);
	    this.stage.act(delta);
	    this.stage.draw();
	    displayStats();
	  } // End render
	  
	  /*
	   * Displays Game Over and Score
	   */
	  private void displayStats() {
			this.paramSpriteBatch.begin();
			this.scoreFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			this.scoreFont.setScale(2.5f);
			this.scoreFont.draw(paramSpriteBatch, "Game Over", Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
			this.scoreFont.draw(paramSpriteBatch, "Score: " + Assets.score, Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getWidth() / 2);
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

	/*
	 * Disable the Input Processor when the game is minimized.
	 */
	public void hide()
	{
	    Gdx.input.setInputProcessor(null);
	} // End hide

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Dispose of any sprite batch used in game.
	 */
	public void dispose() {
		this.paramSpriteBatch.dispose();
	} // End dispose

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
