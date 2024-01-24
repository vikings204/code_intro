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

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.photovision.vision.opencv.CVMat;
import org.photovision.vision.pipe.CVPipe;


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

  // set up USB camera capture
  CameraServer.startAutomaticCapture();
  CvSink cvSink = CameraServer.getVideo();

  // set up AprilTag detector
  AprilTagDetector detector = new AprilTagDetector();
  AprilTagDetector.Config config = new AprilTagDetector.Config();
  // set config parameters, e.g. config.blah = 5;
  detector.setConfig(config);
  detector.addFamily("tag16h5");

  // Set up Pose Estimator
  AprilTagPoseEstimator.Config poseEstConfig = new AprilTagPoseEstimator.Config(...);
  AprilTagPoseEstimator estimator = new AprilTagPoseEstimator(poseEstConfig);

  Mat mat = new Mat();
  Mat graymat = new Mat();

  while (!Thread.interrupted()) {
  // grab image from camera
    long time = cvSink.getFrame(mat);
    if (time == 0) {
      continue;  // error getting image
    }

    // convert image to grayscale
    Imgproc.cvtColor(mat, graymat, Imgproc.COLOR_BGR2GRAY);
  
    // run detection
    for (AprilTagDetection detection : detector.detect(graymat)) {
    // filter by property

      // run pose estimator
      Transform3d pose = poseEstimator.estimate(detection);
    }
  }
}
