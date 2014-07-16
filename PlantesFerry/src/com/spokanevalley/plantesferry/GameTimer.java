/*
 * @author Kevin Borling
 * GameTimer is a clock that starts at 0 and increments by 1 every second.
 * This is used as the score for the game.
 */

package com.spokanevalley.plantesferry;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GameTimer {
	
	long startTime;
	
	public GameTimer()
	{
		this.startTime = 0;
	} // End GameTimer Constructor
	
	/*
	 * Starts the current game timer
	 */
	public void start() {
		this.startTime++;
		delay(1);
	}
	/*
	 * Adds 3 Seconds to the game timer
	 */
	public void addTime() {
		this.startTime += 300;
	}
	
	/*
	 * Pauses the current game timer
	 */
	public void pause() {}
	
	/*
	 * Stops the current game timer
	 */
	public void stop() {}
	
	/*
	 * Resets the timer back to 60 seconds
	 */
	public void reset() {
		this.startTime = 0;
	} // End reset
	
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
	} // End delay
	
	/*
	 * Returns a 2 digit time in seconds
	 */
	public String toString() {
		return "" + startTime / 100;
	} // End toString
}