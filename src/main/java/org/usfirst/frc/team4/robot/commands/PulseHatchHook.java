package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PulseHatchHook extends Command {
  public PulseHatchHook() {
     requires(Robot.m_hatchHook);
  }

  @Override
  protected void initialize() {
    Robot.m_hatchHook.hooksForward();
    Robot.m_hatchHook.isOut = false;
    
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    Robot.m_hatchHook.hooksReverse();
    Robot.m_hatchHook.isOut = true;

  }
}
