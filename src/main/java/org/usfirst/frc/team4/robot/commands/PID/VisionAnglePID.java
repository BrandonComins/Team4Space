package org.usfirst.frc.team4.robot.commands.PID;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.constants.AutoConstants;
import org.usfirst.frc.team4.robot.constants.ControllerConstants;
import org.usfirst.frc.team4.robot.constants.LimelightConstants;
import org.usfirst.frc.team4.robot.subsystems.Limelight;
import org.usfirst.frc.team4.robot.utilities.ElementMath;
import org.usfirst.frc.team4.robot.utilities.SynchronusPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This command allows for vision to correct angle while manually 
 * driving forward. We have it set to Driver A button when held in OI
 */
public class VisionAnglePID extends Command {

	private SynchronusPID pid;

	public VisionAnglePID() {
		requires(Robot.m_driveTrain);
		
		pid = new SynchronusPID(AutoConstants.angleKP, AutoConstants.angleKI, AutoConstants.angleKD, false);
		pid.setSetpoint(0);

		SmartDashboard.putData("Tune Turn Controller", pid);

	}

	protected void initialize() {
		Robot.m_driveTrain.reset();
		if(LimelightConstants.isLedOn == false){
			Robot.m_limelight.setLEDMode(LimelightConstants.eLEDMode.ON);
			LimelightConstants.isLedOn = true;
		}
		else if(LimelightConstants.isVisionMode == false){
				Robot.m_limelight.setCamMode(LimelightConstants.CameraMode.VISION_PROCESSING);
				LimelightConstants.isVisionMode = true;
		}
	}

	protected void execute() {
		double angle = pid.calculate(Limelight.getInstance().getTX());
		Robot.m_driveTrain.arcadeDrive(ElementMath.handleDeadband(-ElementMath.cubeInput(-Robot.m_oi.leftY(ControllerConstants.driveController)), .05), -angle);
		System.out.println(angle);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.m_driveTrain.setPower(0, 0);
		if(LimelightConstants.isLedOn == true){
			Robot.m_limelight.setLEDMode(LimelightConstants.eLEDMode.OFF);
			LimelightConstants.isLedOn = false;
		}
	}

	protected void interrupted() {
		end();
	}
}