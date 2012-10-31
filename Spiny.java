package doderpy;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Spiny - a robot by (your name here)
 */
public class Spiny extends AdvancedRobot
{
	/**
	 * run: Spiny's default behavior
	 */
	int boink = 0;
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		 setColors(Color.black,Color.white,Color.white); // body,gun,radar
		
		// Robot main loop
		while(true) {
			// Tell the game that when we take move,
			// we'll also want to turn right... a lot.
			setTurnRight(10000);
			// Limit our speed to 5
			setMaxVelocity(5);
			// Start moving (and turning)
			ahead(10000);
			// Repeat.
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		calledShot(e.getDistance());
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(50);
	}	
	public void onHitRobot(HitRobotEvent e){

			if (boink == 0){
				setTurnRight(10000);
				setMaxVelocity(10);
				back(10000);
				boink = 1;
			} else{
				setTurnRight(10000);
				setMaxVelocity(5);
				ahead(10000);
				boink = 0;
			}
			
			
	}
	public void calledShot(double robotDistance) {
		if (robotDistance > 200 || getEnergy() < 15) {
			fire(1);
		} else if (robotDistance > 50) {
			fire(2);
		} else if (robotDistance < 50){
			fire(Rules.MAX_BULLET_POWER);
		}

		 else {
			fire(1);
		}
	}
}
								