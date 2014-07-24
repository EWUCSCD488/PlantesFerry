package com.plantesferry.game;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.plantesferry.game.GameSetup;

public class MainActivity extends AndroidApplication {
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AndroidApplicationConfiguration localAndroidApplicationConfiguration = new AndroidApplicationConfiguration();
    localAndroidApplicationConfiguration.useGL20 = true;
    initialize(new GameSetup(), localAndroidApplicationConfiguration);
  }
}// End MainActivity