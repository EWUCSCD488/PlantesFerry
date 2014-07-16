package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
  public static TextureAtlas atlas;
  public static TextureRegion playerDino;
  public static TextureRegion monster;
  public static TextureRegion apple;
  public static TextureRegion underwaterbg;
  public static Music backgroundMusic;
  public static Sound appleSound;
  public static Sound monsterSound;
  public static long score;

  
  public static void dispose()
  {
    atlas.dispose();
  } // End dispose
  
  public static void load()
  {
	/* Load Image Atlas */
    atlas = new TextureAtlas(Gdx.files.internal("gfx/texture.atlas"));
    
    /* Load Sound Effects */
    backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sfx/rainbowbunchie.mp3"));
    appleSound = Gdx.audio.newSound(Gdx.files.internal("sfx/bite.wav"));
    monsterSound = Gdx.audio.newSound(Gdx.files.internal("sfx/FX051.mp3"));
    
    /* Load Character / Background Sprites */
    playerDino = atlas.findRegion("waterdino");
    underwaterbg = atlas.findRegion("underwater");
    monster = atlas.findRegion("monster64");
    apple = atlas.findRegion("apple32");
  } // End load
  
} // End Assets
