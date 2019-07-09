package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

public class TurnCounterClockwise extends Command{
    private HCDriveTrain driveTrain;
    private double angleO;

  public TurnCounterClockwise(HCDriveTrain driveTrain, double angle) {
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    driveTrain.turnCounterClockwise(1);
    angleO = driveTrain.getAngle() % 360 - 45;
    System.out.println(angleO);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.turnCounterClockwise(1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double angleF = driveTrain.getAngle() % 360;
    if(angleF <= angleO){
      System.out.println(angleF);
      return true;
    }
    System.out.println(angleF);
    return false;
  }
    // angleO = -45
    // angleF = 0, -20.999, -30, -40, -48

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