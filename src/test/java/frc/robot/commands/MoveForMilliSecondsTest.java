/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Command;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Add your docs here.
 */
public class MoveForMilliSecondsTest {
    private DriveTrain dt;
    private MoveForMilliSeconds mfms;
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;
    private static int duration = 100;

    @Before
    public void setUp(){
        leftSide = mock(SpeedControllerGroup.class);
        rightSide = mock(SpeedControllerGroup.class);
        AnalogInput sensor = mock(AnalogInput.class);

       when (sensor.getVoltage()).thenReturn(100 * 0.009766).thenReturn(50 *  0.009766).thenReturn(5 *  0.009766);
        

        dt = new DriveTrain(leftSide, rightSide);
        dt.setDistanceSensor(sensor);
        mfms = new MoveForMilliSeconds(dt,duration);
    }

    @Test
    public void doesStartWhenInitialized(){
        mfms.initialize();
        verify(leftSide,times(1)).set(anyDouble());
        verify(rightSide,times(1)).set(anyDouble());
        verify(leftSide,times(0)).stopMotor();
        verify(leftSide,times(0)).stopMotor();
    }

    @Test
    public void executeSetsSpeed(){
        mfms.initialize();
        mfms.execute();
        verify(leftSide,times(2)).set(anyDouble());
        verify(rightSide,times(2)).set(anyDouble());
        verify(leftSide,times(0)).stopMotor();
        verify(leftSide,times(0)).stopMotor();
    }

    @Test
    public void isFinishedReturnsTrueAfterTime(){
        mfms.initialize();
        assertFalse(mfms.isFinished());
        try{
            Thread.sleep(duration + 1);
        } catch(InterruptedException exp){
        }
        assertTrue(mfms.isFinished());
    }
    
    @Test
    public void motorIsStopedWhenEndIsCalled(){
        mfms.initialize();
        mfms.end();
        verify(leftSide,times(1)).stopMotor();
        verify(rightSide,times(1)).stopMotor();
    }

    @Test
    public void motorIsStoppedWhenInturrptedIsCalled(){
        mfms.initialize();
        mfms.interrupted();
        verify(leftSide,times(1)).stopMotor();
        verify(rightSide,times(1)).stopMotor();
    }
}
