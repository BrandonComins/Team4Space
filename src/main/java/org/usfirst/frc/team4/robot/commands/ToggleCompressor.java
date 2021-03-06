package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command will toggle the compressor
 */
public class ToggleCompressor extends Command {

    public ToggleCompressor() {
         requires(Robot.m_hatchHook);
    }

    protected void initialize() {
        Robot.m_hatchHook.compressorStart();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
        Robot.m_hatchHook.compressorStop();
    }
}
