

package org.usfirst.frc.team4.robot.commands.automodes;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SensorlessDrive extends Command {
  public SensorlessDrive() {
    
    requires(Robot.m_chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_chassis.setPower(1, 1);
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}