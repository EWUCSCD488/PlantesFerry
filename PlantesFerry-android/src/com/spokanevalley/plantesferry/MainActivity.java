package com.spokanevalley.plantesferry;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity
  extends AndroidApplication
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AndroidApplicationConfiguration localAndroidApplicationConfiguration = new AndroidApplicationConfiguration();
    localAndroidApplicationConfiguration.useGL20 = false;
    initialize(new GameSetup(), localAndroidApplicationConfiguration);
  }
}