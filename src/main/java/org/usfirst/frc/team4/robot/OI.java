
package org.usfirst.frc.team4.robot;


import org.usfirst.frc.team4.robot.commands.DeployRamp;
import org.usfirst.frc.team4.robot.commands.PulseHatchRelease;
import org.usfirst.frc.team4.robot.commands.ToggleCompressor;
import org.usfirst.frc.team4.robot.commands.ToggleLED;
import org.usfirst.frc.team4.robot.commands.teleOPVision.FrontRocket;
import org.usfirst.frc.team4.robot.commands.teleOPVision.SideRocket;
import org.usfirst.frc.team4.robot.constants.ControllerConstants;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is usually used for declaring what buttons do things.
 */
public class OI {

	public double leftX(Joystick cont) {
		return cont.getRawAxis(ControllerConstants.AXIS_LEFT_X);
	}

	public double leftY(Joystick cont) {
		return cont.getRawAxis(ControllerConstants.AXIS_LEFT_Y);
	}

	public double rightX(Joystick cont) {
		return cont.getRawAxis(ControllerConstants.AXIS_RIGHT_X);
	}

	public double rightY(Joystick cont) {
		return cont.getRawAxis(ControllerConstants.AXIS_RIGHT_Y);
	}

	public double leftTrigger(Joystick cont) {
		return cont.getRawAxis(ControllerConstants.TRIGGER_RIGHT);
	}

	public OI() {

		//Driver
		ControllerConstants.driveA.whileHeld(new FrontRocket());
		ControllerConstants.driveB.whileHeld(new SideRocket());
		ControllerConstants.driveRightBumper.toggleWhenPressed(new ToggleLED());
		ControllerConstants.driveStart.toggleWhenPressed(new DeployRamp());

		//Operator
		ControllerConstants.operatorA.whenPressed(new PulseHatchRelease());
		ControllerConstants.operatorStart.toggleWhenPressed(new ToggleCompressor());
		

	}
}
