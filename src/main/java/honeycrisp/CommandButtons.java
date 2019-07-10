package honeycrisp;

import edu.wpi.first.wpilibj.command.Command;

public interface CommandButtons{
    public void addButtonPress(Command command, int button);
    public void addButtonHeld(Command command, int button);
    public void addButtonRelease(Command command, int button);
    public void addJoystickCommand(JoystickCommand command);
}