/*
 * @author Kevin Borling
 * GameTimer is a clock that starts at 0 and increments by 1 every second.
 * This is used as the score for the game.
 */

package com.spokanevalley.plantesferry;


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
	 * Returns a 2 digit time in seconds
	 */
	public String toString() {
		return "" + startTime / 100;
	} // End toString
}