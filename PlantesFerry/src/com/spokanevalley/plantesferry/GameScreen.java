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
  BitmapFont timerFont;
  SpriteBatch paramSpriteBatch;
  
  public GameScreen()
  {
    this.stage.addActor(this.plantesferry);
    
	this.timerFont = new BitmapFont(Gdx.files.internal("fonts/gamefont.fnt"),
  			Gdx.files.internal("fonts/gamefont_0.png"), false);
	paramSpriteBatch = new SpriteBatch();
  } // End Constructor
  
  public void dispose() {}
  
  public boolean fling(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramFloat2 < -100.0F) {
      this.plantesferry.playerCanoe.tryMoveUp();
    }
    if (paramFloat2 > 100.0F) {
      this.plantesferry.playerCanoe.tryMoveDown();
    }
    return false;
  } // End fling
  
  public void hide()
  {
    Gdx.input.setInputProcessor(null);
  } // End hide
  
  public boolean longPress(float paramFloat1, float paramFloat2)
  {
    return false;
  } // End longPress
  
  public boolean pan(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return false;
  } // End pan
  
  public void pause() {}
  
  public boolean pinch(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24)
  {
    return false;
  } // End pinch
  
  public void render(float paramFloat)
  {
    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Gdx.gl.glClear(16384);
    this.stage.act(paramFloat);
    this.stage.draw();
    
    /*
	this.timerFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
	
	paramSpriteBatch.begin();
	this.timerFont.setScale(2.5f);
	this.timerFont.draw(paramSpriteBatch, ""+(paramFloat/1000), 125, 60);
	//this.timerFont.draw(paramSpriteBatch, ""+paramFloat, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
	paramSpriteBatch.end();
	*/
  } // End render
  
  public void resize(int paramInt1, int paramInt2)
  {
    this.stage.setViewport(800.0F, 480.0F, true);
    this.stage.getCamera().translate(-this.stage.getGutterWidth(), -this.stage.getGutterHeight(), 0.0F);
  } // End resize
  
  public void resume() {}
  
  public void show()
  {
    Gdx.input.setInputProcessor(new GestureDetector(this));
    // Set background music and loop it forever
    //TODO: Move background music
    Assets.backgroundMusic.play();
    Assets.backgroundMusic.setLooping(true);
  } // End show()
  
  public boolean tap(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    return false;
  } // End tap
  
  public boolean touchDown(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    return false;
  } // End touchDown
  
  public boolean zoom(float paramFloat1, float paramFloat2)
  {
    return false;
  } // End zoom
}