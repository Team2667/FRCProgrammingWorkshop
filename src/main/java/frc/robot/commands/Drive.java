/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.JoystickCommand;
import honeycrisp.subsystems.HCDriveTrain;

public class Drive extends Command implements JoystickCommand{
  private HCDriveTrain driveTrain;
  private XboxController joy;

  public Drive(HCDriveTrain driveTrain) {
    requires(driveTrain);
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
  }

  @Override
  public void addJoystick(XboxController joy){
    this.joy = joy;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.arcadeDrive(joy);
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
