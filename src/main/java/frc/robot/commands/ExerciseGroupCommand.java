package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExerciseGroupCommand extends CommandGroup{
    public ExerciseGroupCommand(Command MoveForMilliSeconds, Command TurnCounterClockwise){
        this.addSequential(MoveForMilliSeconds);
        this.addSequential(TurnCounterClockwise);
    }
}