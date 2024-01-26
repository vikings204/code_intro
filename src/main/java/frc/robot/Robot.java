package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.HookSubsystem;
import edu.wpi.first.apriltag.AprilTagDetection;
import edu.wpi.first.apriltag.AprilTagDetector;
import edu.wpi.first.apriltag.AprilTagPoseEstimator;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.math.geometry.Transform3d;



/**
This sample program shows how to control a motor using a joystick.

Certain lines of code include comments indicating the purpose.
Some comments also have indications towards which file this code would reside in an actual robot
Read through to develop your understanding of how robotics code works.
 */

public class Robot extends TimedRobot {
    private Command autonomousCommand;
    private Command teleopCommand;

    private RobotContainer robotContainer;

  //AutoSelector
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>(); 


  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    SmartDashboard.putData(CommandScheduler.getInstance());

  }


  @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
  }

  //Periodically called during autonomous.
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        //custom auto code here
        break;
      case kDefaultAuto:
      default:
        //default auto code here
        break;
    }
  }

  @Override
  public void teleopInit() {
    teleopCommand = robotContainer.getTeleopCommand();
    if (autonomousCommand != null) {
        autonomousCommand.cancel();
      }
    }
  
  double counter = 0.0;

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Counter", counter++);
  }
}
