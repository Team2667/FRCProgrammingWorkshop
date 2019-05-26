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

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements CommandButtons{

  private HashMap<String,Command> commands;

  @Override
  public void addCommand(Command command, String commandName, int button){

  }

  @Override
  public Command getCommand(String commandName){
    return commands.get(commandName);
  }


}
