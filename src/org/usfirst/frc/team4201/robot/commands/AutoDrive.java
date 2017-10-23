package org.usfirst.frc.team4201.robot.commands;

import org.usfirst.frc.team4201.robot.Robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	double leftSpeed = 0;
	double rightSpeed = 0;
	double time = 0;
	
	
	Timer stopwatch;
	
	public AutoDrive(double leftSpeed, double rightSpeed, double time) {
		
		requires(Robot.driveTrain);
		stopwatch = new Timer();
		this.time = time;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
	}
	
	protected void initialize() {
		Robot.driveTrain.setDriveControlByPower();
		stopwatch.start();
		CameraServer.getInstance().startAutomaticCapture();
		
	}
	@Override
	protected void execute() {
		Robot.driveTrain.setLeftRightMotorOutputs(leftSpeed , rightSpeed );
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return stopwatch.get()>time;
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.setLeftRightMotorOutputs(0, 0);
		stopwatch.stop();
	}
	
	protected void interupted() {
		Robot.driveTrain.setLeftRightMotorOutputs(0, 0);
		stopwatch.stop();
	}

	
}