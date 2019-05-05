/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import honeycrisp.subsystems.HCDriveTrainBuilder;

/**
 * Add your docs here.
 */
public class DriveTrainBuilder extends HCDriveTrainBuilder<DriveTrain>{
    protected DriveTrain newDriveTrain(WPI_TalonSRX leftFront,  WPI_TalonSRX rightFront,  WPI_TalonSRX leftRear,  WPI_TalonSRX rightRear){
        return new DriveTrain(leftFront, rightFront,leftRear,rightRear);
    }
    
}
