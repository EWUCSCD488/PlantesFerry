package com.plantesferry.game;

import com.badlogic.gdx.Game;

public class GameSetup extends Game {
  public static final int HEIGHT = 480;
  public static final int WIDTH = 800;
  private GameScreen gameScreen;
  
  public void create()
  {
    Assets.load();
    this.gameScreen = new GameScreen();
    setScreen(this.gameScreen);
  } // End create
  
  public void dispose()
  {
    Assets.dispose();
    this.gameScreen.dispose();
  } // End dispose
  
} // End GameSetup
