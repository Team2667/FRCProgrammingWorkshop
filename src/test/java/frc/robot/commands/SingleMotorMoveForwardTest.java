package frc.robot.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import frc.robot.subsystems.SingleMotor;

public class SingleMotorMoveForwardTest{
    SingleMotor singleMotor;
    SingleMotorMoveForward smmf;
    WPI_TalonSRX talon;

    @Test
    public void intializeStartsTheMotor(){
        smmf.initialize();
        verify(talon,times(1)).set(anyDouble());
        verify(talon,times(0)).set(0);
    }

    @Test
    public void executeContinuesToMoveTheMotor(){
        smmf.initialize();
        smmf.execute();
        verify(talon,times(2)).set(anyDouble());
        verify(talon,times(0)).set(0);
    }

    @Test
    public void isFinishedReturnsTrueWhenTheButtonIsPressed(){
        smmf.initialize();
        smmf.execute();
        assertFalse(smmf.isFinished());
        smmf.execute();
        assertTrue(smmf.isFinished());
    }

    @Test
    public void endStopsTheMotor(){
        smmf.initialize();
        smmf.execute();
        smmf.end();
        verify(talon,times(1)).set(0);
    }

    @Test
    public void interuptedAlsoStopsTheMotor(){
        smmf.initialize();
        smmf.execute();
        smmf.interrupted();
        verify(talon,times(1)).set(0);
    }

    @Before
    public void setUp(){
        talon = mock(WPI_TalonSRX.class);
        DigitalInput stopButton = mock(DigitalInput.class);
        when(stopButton.get()).thenReturn(false).thenReturn(true);
        singleMotor = new SingleMotor(talon,stopButton);
        smmf = new SingleMotorMoveForward(singleMotor);
    }
}