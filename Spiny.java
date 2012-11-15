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
		turnGunLeft(90);
		// Robot main loop
		while(true) {
			move();
			
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
		back(80);
	}	
	public void onHitRobot(HitRobotEvent e){

			if (boink == 0){
				boink = 1;
			} else{
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
	public void move()
	{
			if (boink == 0){
				
			//	turnGunRight(180);
				setTurnRight(10000);
				setMaxVelocity(7);
				back(10000);
				boink = 1;
			} else{
				//turnGunRight(180);
				setTurnRight(10000);
				setMaxVelocity(5);
				ahead(10000);
				boink = 0;
			}
	}
}				
					