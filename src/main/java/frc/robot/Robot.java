package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
This sample program shows how to control a motor using a joystick.

Certain lines of code include comments indicating the purpose.
Some comments also have indications towards which file this code would reside in an actual robot
Read through to develop your understanding of how robotics code works.
 */
public class Robot extends TimedRobot {
    private Command teleopCommand;

    private RobotContainer robotContainer;

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
  }

  @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
      teleopCommand = robotContainer.getTeleopCommand();
      if (teleopCommand != null) {
        teleopCommand.cancel();
        teleopCommand.schedule();
      }
    }
}
