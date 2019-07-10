package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

/*
 * Move the robot forward for a specified number of milliseconds.
 * Hints:
 *  1. second equals 1000 milliseconds
 *  2. Call System.currentTimeMillis() to get the number of milliseconds that have passed since 
 *     January 1, 1970 12:00am GMT
 * 
*/
public class MoveForMilliSeconds extends Command {
    long stopTime;
    int millis;
  private HCDriveTrain driveTrain;


  public MoveForMilliSeconds(HCDriveTrain driveTrain, int millis) {
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
    this.millis = millis;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    stopTime = System.currentTimeMillis() + millis ;
    
    driveTrain.moveForward(.2);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.moveForward(.2);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() >= stopTime;
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