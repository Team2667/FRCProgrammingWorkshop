/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package honeycrisp.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public abstract class HCDriveTrain extends HCSubsystem{
    private DifferentialDrive diffDrive;
    private AnalogInput distanceSensor;
    private ADXRS450_Gyro gyro;

    public HCDriveTrain(WPI_TalonSRX leftFront,  WPI_TalonSRX rightFront,  WPI_TalonSRX leftRear,  WPI_TalonSRX rightRear){
        SpeedControllerGroup leftSideControllerGroup = new SpeedControllerGroup(leftFront, leftRear);
        SpeedControllerGroup rightSideControllerGroup = new SpeedControllerGroup(rightFront, rightRear);
        leftSideControllerGroup.setInverted(true);
        diffDrive = new DifferentialDrive(leftSideControllerGroup, rightSideControllerGroup);
    }

    public void arcadeDrive(XboxController joy) {
        diffDrive.arcadeDrive(joy.getX(), joy.getY());
      }


    public HCDriveTrain(SpeedControllerGroup leftSide, SpeedControllerGroup rightSide){
        diffDrive = new DifferentialDrive(leftSide, rightSide);
    }

    public void moveForward(double power){
       diffDrive.tankDrive(power, power);
    }

    public void turnCounterClockwise(double power){
        diffDrive.tankDrive(0,power);
    }

    public void turnClockwise(double power){
        diffDrive.tankDrive(power,0);
    }

    public void stop(){
        diffDrive.stopMotor();
    }

    public double getDistanceInInches(){
    
        double volts = distanceSensor.getVoltage();
        System.out.println("distance sensor called return " + volts);
        return  volts / 0.009766;
    }

    public void setDistanceSensor(AnalogInput distanceSensor){
        System.out.println("setDistanceSensor is getting called " + distanceSensor);
        this.distanceSensor = distanceSensor;
    }

    public void setGyro(ADXRS450_Gyro gyro){
        this.gyro = gyro;
        this.gyro.calibrate();
    }

    public double getAngle(){
        return gyro.getAngle();
    }
}
