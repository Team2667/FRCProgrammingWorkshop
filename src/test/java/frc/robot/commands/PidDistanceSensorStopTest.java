/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import honeycrisp.util.AnalogValueConverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.verification.AtLeast;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Add your docs here.
 */
@RunWith(MockitoJUnitRunner.class)
public class PidDistanceSensorStopTest {
    private DriveTrain dt;
    private PidDistanceSensorStop dss;
    private MockInputSource inSource;

    @Mock
    private SpeedControllerGroup leftSide;

    @Mock
    private SpeedControllerGroup rightSide;

    @Mock
    private AnalogInput dSensor;

    @Before
    public void setUp(){
        Answer<Double> answer = new Answer<>() {
            public Double answer(InvocationOnMock invocation) throws Throwable {
               return inSource.nextValue();
            }
        };

         inSource = new MockInputSource(AnalogValueConverter::inchesToVoltage,
            40.0, 40.0, 40.0, 40.0,
        39.6, 39.1, 38.5, 38.0, 37.0, 35.0, 32.0, 29.0, 26.9,
        25.4, 20.3
        );

        when (dSensor.pidGet()).thenAnswer(answer);   
        when (dSensor.getPIDSourceType()).thenReturn(PIDSourceType.kDisplacement);  
        dt = new DriveTrain(leftSide, rightSide);
        dt.setDistanceSensor(dSensor);   
        dss = new PidDistanceSensorStop(dt, 20);
    }

    @After
    public void tearDown(){
        dss.end();
    }

    @Test
    public void isPidControllerEnabled(){
        dss.initialize();
        pauseMillis(1000);
        assertTrue(inSource.isStarted());
    }

    private void pauseMillis(int millis){
        try{
            Thread.sleep(millis);
        } catch(InterruptedException exp){

        }
    }
}
