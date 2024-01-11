// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.MotorSubsystem;

public class RobotContainer {
    private final MotorSubsystem MotorSubsystem = new MotorSubsystem();
    Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);

    public Command getTeleopCommand() {
        return new RunCommand(() -> {
            joystick.getRawButton(0);
            MotorSubsystem.triggerMotor(joystick.getTrigger());
            }, MotorSubsystem);
    }
}