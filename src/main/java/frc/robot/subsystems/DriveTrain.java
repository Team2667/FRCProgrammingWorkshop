/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DistanceSensorStop;
import frc.robot.commands.MoveForMilliSeconds;
import frc.robot.commands.TurnCounterClockwise;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import honeycrisp.CommandButtons;
import honeycrisp.subsystems.HCDriveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class DriveTrain extends HCDriveTrain {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  XboxController joy;
  private Drive defaultCommand;

  public DriveTrain(WPI_TalonSRX leftFront,  WPI_TalonSRX rightFront,  WPI_TalonSRX leftRear,  WPI_TalonSRX rightRear){
    super(leftFront, rightFront, leftRear, rightRear);
  }

  public DriveTrain(SpeedControllerGroup leftSide, SpeedControllerGroup rightSide){
    super(leftSide,rightSide);
  }

   @Override
  public void addCommands(CommandButtons gameController) {
    DistanceSensorStop dstop = new DistanceSensorStop(this,20);
    SmartDashboard.putData("Distance Sensor Stop",dstop);
    TurnCounterClockwise turnCounter = new TurnCounterClockwise(this, 45.0);
    SmartDashboard.putData("Turn Counter Clockwise", turnCounter);
    MoveForMilliSeconds moveForTime = new MoveForMilliSeconds(this, 5000);
    SmartDashboard.putData("Move for Milli Seconds", moveForTime);
    defaultCommand = new Drive(this);
    gameController.addJoystickCommand(defaultCommand);
  }

  @Override
  public void updateSmartDashboardValues() {
//    SmartDashboard.putNumber("Distance Sensor", getDistanceInInches());
//    SmartDashboard.putNumber("Gyro Angle", getAngle());
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(defaultCommand);
  }
}
