/*
 * @author Kevin Borling
 * GameTimer is a 60 second timer that decreases by 1 every second.
 */

package com.spokanevalley.plantesferry;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GameTimer {
	
	long startTime;
	
	public GameTimer()
	{
		this.startTime = 6000;
	}
	
	/*
	 * Starts the current game timer
	 */
	public void start() {
		        startTime--;
		        delay(1);
	}
	
	/*
	 * Pauses the current game timer
	 */
	public void pause() {
		
	}
	
	/*
	 * Stops the current game timer
	 */
	public void stop() {

	}
	
	/*
	 * Resets the timer back to 60 seconds
	 */
	public void reset() {
		this.startTime = 6000;
	}
	
	/*
	 * Sets a 1 second delay on the current timer
	 */
	public void delay(long delayMillis) {
		float delay = delayMillis;
		Timer.schedule(new Task(){
		    @Override
		    public void run() {
		    }
		}, delay);
	}
	
	/*
	 * Returns a 2 digit time in seconds
	 */
	public String toString() {
		return "" + startTime / 100;
	}
}