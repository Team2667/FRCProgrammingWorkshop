package honeycrisp;

import edu.wpi.first.wpilibj.command.Command;

public interface CommandButtons{
    public void addCommand(Command command, String commandName, int button);
    public Command getCommand(String commandName);
}