package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

public class TurnCounterClockwise extends Command{
    private HCDriveTrain driveTrain;
    private double angle;

  public TurnCounterClockwise(HCDriveTrain driveTrain, double angle) {
    this.driveTrain = driveTrain;
    this.requires(driveTrain);

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  driveTrain.resetGyro();  
    driveTrain.turn(-.5);

    // With the driveTrain.turn() method, negitive speed will turn counter clockwise. Positive will turn clockwise.
    // Be sure to reset the gyro before starting the turn.
  }

  // Called repeatedly when this Command is scheduled to run
  // Execute should continue the turn.
  @Override
  protected void execute() {driveTrain.turn(-5);
  }

  // Make this return true when this Command no longer needs to run execute()
  // driveTrain.getAngle() will return the current angle. If the robot is a few degrees 
  // counter closkwise from where it started, driveTrain.getAngle() will be negitive.
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  // In this case, end() should stop the driveTrain.
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run or the emergency stop is hit.
  // 
  @Override
  protected void interrupted() {
  }
}