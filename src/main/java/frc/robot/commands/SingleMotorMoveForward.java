package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.SingleMotor;

public class SingleMotorMoveForward extends Command{

    private SingleMotor singleMotor;

    public SingleMotorMoveForward(SingleMotor singleMotor){
        this.singleMotor = singleMotor;
        this.requires(this.singleMotor);
    }

    @Override
    protected void initialize() {
        singleMotor.moveForward();
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        singleMotor.moveForward();
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return singleMotor.isStop();
    }
  
    // Called once after isFinished returns true
    @Override
    protected void end() {
        singleMotor.stop();
    }



    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }

}