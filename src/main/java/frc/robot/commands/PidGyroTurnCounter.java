package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

public class PidGyroTurnCounter extends Command implements PIDOutput{
    private HCDriveTrain driveTrain;
    private PIDController pidController;
    private double angle;


    public PidGyroTurnCounter(HCDriveTrain driveTrain, double angle) {
        this.driveTrain = driveTrain;
        this.requires(driveTrain);
        this.angle = angle;
      }
    
      // Called just before this Command runs the first time
      @Override
      protected void initialize() {
        driveTrain.resetGyro();
        pidController = driveTrain.getGyroPIDController(angle, this);
        pidController.setP(.04);
        pidController.setI(0);
        pidController.setD(0);
        pidController.setPercentTolerance(1.0);
        pidController.enable();
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

      public void pidWrite(double p){
          System.out.println(p);
      }
}