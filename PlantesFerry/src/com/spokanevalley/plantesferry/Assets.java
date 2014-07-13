package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets
{
  public static TextureAtlas atlas;
  public static TextureRegion playerDino;
  public static TextureRegion monster;
  public static TextureRegion checkpoint;
  public static TextureRegion underwaterbg;
  public static Music backgroundMusic;
  public static Sound checkpointSound;
  public static Sound monsterSound;
  public static BitmapFont timerFont;
  public static BitmapFont scoreFont;

  
  public static void dispose()
  {
    atlas.dispose();
  }
  
  public static void load()
  {
	/* Load Image Atlas */
    atlas = new TextureAtlas(Gdx.files.internal("gfx/texture.atlas"));
    
    /* Load Sound Effects */
    backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sfx/rainbowbunchie.mp3"));
    checkpointSound = Gdx.audio.newSound(Gdx.files.internal("sfx/FX051.mp3"));
    monsterSound = Gdx.audio.newSound(Gdx.files.internal("sfx/FX051.mp3"));
    
    /* Load Character / Background Sprites */
    playerDino = atlas.findRegion("waterdino");
    underwaterbg = atlas.findRegion("underwater");
    monster = atlas.findRegion("monster");
    checkpoint = atlas.findRegion("lights");
  }
}
// End Assets