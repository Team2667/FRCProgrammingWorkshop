/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.CommandButtons;
import honeycrisp.JoystickCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements CommandButtons{
  public XboxController xbox;

  public OI(){
    xbox = new XboxController(0);
  }

  @Override
  public void addButtonPress(Command command, int button){
    JoystickButton jButton = new JoystickButton(xbox,button);
    jButton.whenPressed(command);
  }

  @Override
  public void addButtonHeld(Command command, int button){
    JoystickButton jButton = new JoystickButton(xbox, button);
    jButton.whileHeld(command);
  }

  @Override
  public void addButtonRelease(Command command, int button){
    JoystickButton jButton = new JoystickButton(xbox, button);
    jButton.whenReleased(command);
  }

  @Override
  public void addJoystickCommand(JoystickCommand command){
    command.addJoystick(xbox);
  }
}
