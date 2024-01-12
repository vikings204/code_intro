// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.HookSubsystem;

public class RobotContainer {
    private final HookSubsystem HookSubsystem = new HookSubsystem();
    Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);

    public Command getTeleopCommand() {
        return new RunCommand(() -> {
            double i = joystick.getY();
            System.out.println(i);
            if(i>0.1) {
                HookSubsystem.raiseMotor();
            }   else if (i<-0.1) {
                    HookSubsystem.downHook();
            }
        }, HookSubsystem);
    }
}