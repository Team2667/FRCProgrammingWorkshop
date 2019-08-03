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

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Add your docs here.
 */
@RunWith(MockitoJUnitRunner.class)
public class PidGyroTurnCounterTest {
    private DriveTrain dt;
    private PidGyroTurnCounter cmd;
    private MockInputSource inSource;

    @Mock
    private SpeedControllerGroup leftSide;

    @Mock
    private SpeedControllerGroup rightSide;

    @Mock
    private AnalogInput dSensor;

    @Mock
    private ADXRS450_Gyro gyro;

    @Before
    public void setUp(){
        Answer<Double> answer = new Answer<>() {
            public Double answer(InvocationOnMock invocation) throws Throwable {
               return inSource.nextValue();
            }
        };

         inSource = new MockInputSource(
            0.01, -0.9, -1.16, -4.0, -8.0, -16.0, -20.0, -25.0, -25.0, -25.0
        );

        when (gyro.pidGet()).thenAnswer(answer);   
        when (gyro.getPIDSourceType()).thenReturn(PIDSourceType.kDisplacement);  
        dt = new DriveTrain(leftSide, rightSide);
        dt.setGyro(gyro);   
        cmd = new PidGyroTurnCounter(dt, -25.0);
    }

    @After
    public void tearDown(){
        cmd.end();
    }

    @Test
    public void isPidControllerEnabled(){
        cmd.initialize();
        pauseMillis(2000);
        assertTrue(inSource.isStarted());
        assertTrue(cmd.isFinished());
    }

    private void pauseMillis(int millis){
        try{
            Thread.sleep(millis);
        } catch(InterruptedException exp){

        }
    }
}
