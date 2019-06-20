package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import honeycrisp.CommandButtons;
import honeycrisp.subsystems.HCSubsystem;

public class SingleMotor extends HCSubsystem{
    WPI_TalonSRX talon;
    DigitalInput stopButton;

    public SingleMotor(WPI_TalonSRX talon, DigitalInput stopButton){
        this.talon = talon;
        this.stopButton = stopButton;
    }

    public void moveForward(){
        talon.set(.25);
    }

    public void moveReverse(){
        talon.set(-.25);
    }

    public boolean isStop(){
        return stopButton.get();
    }

    public void stop(){
        talon.set(0);
    }

    public void addCommands(CommandButtons commandButtons){
       
    }

    @Override
    public void updateSmartDashboardValues(){
        
    }
}