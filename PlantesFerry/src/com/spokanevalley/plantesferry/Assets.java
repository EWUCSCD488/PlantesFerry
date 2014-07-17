package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
  /* Atlas/Texture Region Declarations */
  private static TextureAtlas atlas;
  public static TextureRegion playerDino;
  public static TextureRegion monster;
  public static TextureRegion apple;
  public static TextureRegion underwaterbg;
  public static TextureRegion menubg;
  /* Music/Sound Effect Declarations */
  public static Music backgroundMusic;
  public static Sound appleSound;
  public static Sound monsterSound;
  /* Score/Life Declaractions */
  public static long score;
  public static int lives;

  /*
   * Dispose the current image atlas.
   */
  public static void dispose()
  {
    atlas.dispose();
  } // End dispose
  
  /*
   * Load the image atlas, audio, score, and sprite images.
   */
  public static void load()
  {
	/* Load Image Atlas */
    atlas = new TextureAtlas(Gdx.files.internal("gfx/texture.atlas"));
    
    /* Load Sound Effects */
    backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sfx/rainbowbunchie.mp3"));
    appleSound = Gdx.audio.newSound(Gdx.files.internal("sfx/bite.wav"));
    monsterSound = Gdx.audio.newSound(Gdx.files.internal("sfx/hurt.wav"));
    
    /* Load Character / Background Sprites */
    underwaterbg = atlas.findRegion("underwater");
    menubg = atlas.findRegion("menu");
    playerDino = atlas.findRegion("waterdino");
    monster = atlas.findRegion("seaurchin");
    apple = atlas.findRegion("apple32");
    
    /* Set Score */
    score = 0;
    /* Set Lives */
    lives = 3;
    
  } // End load
  
} // End Assets
