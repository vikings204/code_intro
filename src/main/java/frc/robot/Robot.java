package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
This sample program shows how to control a motor using a joystick.

Certain lines of code include comments indicating the purpose.
Some comments also have indications towards which file this code would reside in an actual robot
Read through to develop your understanding of how robotics code works.
 */
public class Robot extends TimedRobot {
  // The following two constants are usually defined in a Constants.java file
  private static final int MOTOR_CAN_ID = 2; // Defines the CAN id of the Spark Max motor controller
  private static final int JOYSTICK_PORT = 0; // Defines the port id of the joystick

  // The following three variables would be defined within a subsystem.
  private CANSparkMax motor;
  private Joystick joystick;
  private RelativeEncoder encoder; // The encoder is directly attached to the Spark Max, no PWM needed

  @Override
  public void robotInit() {
    // robot container should be defined

    // The following three statements would be located within a subsystem.
    motor = new CANSparkMax(MOTOR_CAN_ID, MotorType.kBrushless); // Create the Spark Max object in the program and include the CAN id and the type of motor used with the controller
    encoder = motor.getEncoder(); // Grab the attached encoder
    joystick = new Joystick(JOYSTICK_PORT); // Create the joystick object
  }

  @Override
  public void robotPeriodic() {
    // The following three calls would be located within a subsystem
    SmartDashboard.putNumber("Encoder", encoder.getVelocity());
    SmartDashboard.putNumber("JoyPos", joystick.getY());
    System.out.println("command: " + joystick.getY() + " drive: " + motor.getAppliedOutput() + " encvel:" + encoder.getVelocity() );
  }

  @Override
  public void teleopInit() {
    // The scheduler should start using the teleop command from robot container
  }

  @Override
  public void teleopPeriodic() {
    // The following call would be located within a subsystem.
    motor.set(joystick.getY());
  }
}
