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

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Add your docs here.
 */
public class DistanceSensorStopTest {
    private DriveTrain dt;
    private DistanceSensorStop dss;
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;

    @Before
    public void setUp(){
        leftSide = mock(SpeedControllerGroup.class);
        rightSide = mock(SpeedControllerGroup.class);
        AnalogInput sensor = mock(AnalogInput.class);

       when (sensor.getVoltage()).thenReturn(100 * 0.009766).thenReturn(50 *  0.009766).thenReturn(5 *  0.009766);
        

        dt = new DriveTrain(leftSide, rightSide);
        dt.setDistanceSensor(sensor);
        dss = new DistanceSensorStop(dt, 20);
    }

    @Test
    public void doesStartWhenInitialized(){
        verify(leftSide,times(0)).set(anyDouble());
        verify(rightSide,times(0)).set(anyDouble());
        dss.initialize();
        verify(leftSide,times(1)).set(anyDouble());
        verify(rightSide,times(1)).set(anyDouble());
    }

    @Test
    public void executeAdjustsTheSpeed(){
        dss.initialize();
        verify(leftSide,times(1)).set(anyDouble());
        verify(rightSide,times(1)).set(anyDouble());
        dss.execute();
        verify(leftSide,times(2)).set(anyDouble());
        verify(rightSide,times(2)).set(anyDouble());
    }

    @Test
    public void isFinishedReturnedWhen20InchesAway(){
        dss.initialize();
        for (int i = 0; i < 2; ++i){
            dss.execute();
            assertFalse(dss.isFinished());
        }
        dss.execute();
        assertTrue(dss.isFinished());
    }

    
    @Test
    public void motorIsStopedWhenEndIsCalled(){
        dss.initialize();
        verify(leftSide,times(1)).set(anyDouble());
        verify(rightSide,times(1)).set(anyDouble());
        dss.end();
        verify(leftSide,times(1)).stopMotor();
        verify(rightSide,times(1)).stopMotor();
    }

    @Test
    public void motorIsStopedWhenInterruptedCalled(){
        dss.initialize();
        verify(leftSide,times(1)).set(anyDouble());
        dss.interrupted();
        verify(leftSide,times(1)).stopMotor();
    }
}
