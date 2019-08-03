/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

public class PidDistanceSensorStop extends Command implements PIDOutput{
  private HCDriveTrain driveTrain;
  private PIDController distanceController;
  private int distanceInInches;

  public PidDistanceSensorStop(HCDriveTrain driveTrain, int distanceInInches) {
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
    this.distanceInInches = distanceInInches;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    distanceController = driveTrain.getDistancePIDController(distanceInInches, this);
    distanceController.setP(1);
    distanceController.setI(0);
    distanceController.setD(0);
    distanceController.setPercentTolerance(5);
    distanceController.enable();
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
    driveTrain.stop();
    distanceController.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

  }

  @Override
  public void pidWrite(double d){
    System.out.println(d);
  }
}
