package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets
{
  public static TextureAtlas atlas;
  public static TextureRegion playerCanoe;
  public static TextureRegion obstruction1;
  public static TextureRegion checkpoint;
  public static TextureRegion river;
  public static Music backgroundMusic;
  public static Music checkpointSound;
  public static Music monsterSound;
  public static BitmapFont timerFont;
  
  public static void dispose()
  {
    atlas.dispose();
  }
  
  public static void load()
  {
    atlas = new TextureAtlas(Gdx.files.internal("textureimages.atlas"));
    
    backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sfx/rainbowbunchie.mp3"));
    checkpointSound = Gdx.audio.newMusic(Gdx.files.internal("sfx/FX051.mp3"));
    monsterSound = Gdx.audio.newMusic(Gdx.files.internal("sfx/FX051.mp3"));
    playerCanoe = atlas.findRegion("playerCanoe");
    river = atlas.findRegion("river");
    obstruction1 = atlas.findRegion("obstruction1");
    checkpoint = atlas.findRegion("checkpoint");
  }
}
// End Assets