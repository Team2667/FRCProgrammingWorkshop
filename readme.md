This is a tutorial for programming an FRC robot. The tutorial assums with just a drive train. The drive train should have 4 motor controlers, one for each wheel. It should also have an analog distance sensor and a 
ADXRS450 Gyro.

In the frc.robot.commands package under the sources root, there are 3 commands for the DriveTrain that are yet to be implementedc. 
 * DistanceSensorStop - Moves the robot forward until the distance sensor reads that there is an object in front of it a certain distance.
 * MoveForMilliSecons - Moves the robot forward until a specified number of milli seconds have passed.
 * TurnCounterClockwise - Turns the robot counter clock wise until it has turned more than a specified number of degrees.

 For each command, there is a junit test class. Once all of the junit tests pass, deploy the code on a robot and
 test it.

The following are commands for running the unit test cases. They are designed to be executed in a terminal window within the visual code IDE. 

To run all the unit test cases:
.\gradlew.bat test

To run test cases in a specific class
.\gradlew.bat test --tests frc.robot.commands.DistanceSensorStopTest
.\gradlew.bat test --tests frc.robot.commands.MoveForMilliSecondsTest
.\gradlew.bat test --tests frc.robot.commands.TurnCounterClockwiseTest
.\gradlew.bat test --tests frc.robot.commands.SingleMotorMoveForwardTest

These commands will display any errors in the terminal window. It will also create an easy to read report. The report can be found in the build folder under reports\tests\test. To see the report:
1. Right mouse click on build\reports\tests\test\index.html in the IDE Explorer window and then select 'reval in explorer'.
2. This will open the directory in Microsoft explorer.
3. Double click on index.html. This will display a report with the test run results in a web browser.

Once you have the report displayed in a web browser, you can hit F5 after every test run to display the report with new results.
 