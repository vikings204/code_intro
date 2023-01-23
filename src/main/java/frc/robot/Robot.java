// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This sample program shows how to control a motor using a joystick. In the operator control part
 * of the program, the joystick is read and the value is written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and motor controller inputs also range from -1 to 1
 * making it easy to work together.
 *
 * <p>In addition, the encoder value of an encoder connected to ports 0 and 1 is consistently sent
 * to the Dashboard.
 */
public class Robot extends TimedRobot {
  private static final int kMotorPort = 2;
  private static final int kJoystickPort = 0;
  //private static final int kEncoderPortA = 0;
  //private static final int kEncoderPortB = 1;

  private CANSparkMax m_motor;
  private Joystick m_joystick;
  private RelativeEncoder m_encoder;

  @Override
  public void robotInit() {
    m_motor = new CANSparkMax(kMotorPort, MotorType.kBrushless);
    m_encoder = m_motor.getEncoder();
    m_joystick = new Joystick(kJoystickPort);
    //m_encoder = new SparkMaxRelativeEncoder(m_motor, Encoder, 1);
    //m_encoder = new Encoder(kEncoderPortA, kEncoderPortB);
    // Use SetDistancePerPulse to set the multiplier for GetDistance
    // This is set up assuming a 6 inch wheel with a 360 CPR encoder.
    //m_encoder.setDistancePerPulse((Math.PI * 6) / 360.0);
  }

  /*
   * The RobotPeriodic function is called every control packet no matter the
   * robot mode.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Encoder", m_encoder.getVelocity());
    SmartDashboard.putNumber("JoyPos", m_joystick.getY());
    System.out.println("command: " + m_joystick.getY() + " drive: " + m_motor.getAppliedOutput() + " encvel:" + m_encoder.getVelocity() );
  }

  @Override
  public void teleopPeriodic() {
    m_motor.set(m_joystick.getY());
  }
}
