package com.spokanevalley.plantesferry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets
{
  public static TextureAtlas atlas;
  public static TextureRegion playerCanoe;
  public static TextureRegion obstruction1;
  public static TextureRegion obstruction2;
  public static TextureRegion obstruction3;
  public static TextureRegion obstruction4;
  public static TextureRegion river;
  
  public static void dispose()
  {
    atlas.dispose();
  }
  
  public static void load()
  {
    atlas = new TextureAtlas(Gdx.files.internal("textureimages.atlas"));
    playerCanoe = atlas.findRegion("playerCanoe");
    river = atlas.findRegion("river");
    obstruction1 = atlas.findRegion("obstruction1");
    obstruction2 = atlas.findRegion("obstruction2");
    obstruction3 = atlas.findRegion("obstruction3");
    obstruction4 = atlas.findRegion("obstruction4");
  }
}
// End Assets