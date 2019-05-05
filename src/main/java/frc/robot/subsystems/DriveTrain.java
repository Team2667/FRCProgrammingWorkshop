/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.DistanceSensorStop;
import honeycrisp.HCGameController;
import honeycrisp.subsystems.HCDriveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class DriveTrain extends HCDriveTrain {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DriveTrain(WPI_TalonSRX leftFront,  WPI_TalonSRX rightFront,  WPI_TalonSRX leftRear,  WPI_TalonSRX rightRear){
    super(leftFront, rightFront, leftRear, rightRear);
  }

  public DriveTrain(SpeedControllerGroup leftSide, SpeedControllerGroup rightSide){
    super(leftSide,rightSide);
  }

   @Override
  public void addCommands(HCGameController gameController) {
    DistanceSensorStop dstop = new DistanceSensorStop(this);
    gameController.addCommand(dstop, 1);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
