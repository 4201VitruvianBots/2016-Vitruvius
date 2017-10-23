package org.usfirst.frc.team4201.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveCommandGroup extends CommandGroup{
	
	public AutoDriveCommandGroup() {
		addSequential(new AutoDrive(.5, .5, .5));
		addSequential(new AutoDrive(0, .5, .5));
	}
}

