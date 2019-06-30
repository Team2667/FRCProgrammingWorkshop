/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

public class DistanceSensorStop extends Command {
  private HCDriveTrain driveTrain;
  private double distanceInInches;


  public DistanceSensorStop(HCDriveTrain driveTrain, int distanceInInches) {
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    driveTrain.moveForward(.2);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    distanceInInches = driveTrain.getDistanceInInches();
    driveTrain.moveForward(.2);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(distanceInInches <= 20) {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    driveTrain.stop();
  
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    driveTrain.stop();
  }
}
