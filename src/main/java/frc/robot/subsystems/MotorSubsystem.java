package frc.robot.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj.XboxController;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase {
    private CANSparkMax motor = new CANSparkMax(Constants.MOTOR_CAN_ID, MotorType.kBrushless); // Create the Spark Max object in the program and include the CAN id and the type of motor used with the controller
    private RelativeEncoder encoder = motor.getEncoder(); // Grab the attached encoder

    public void setMotor(double joyY) {
         joyY /=2;
        SmartDashboard.putNumber("Encoder", encoder.getVelocity());
        SmartDashboard.putNumber("JoyPos", joyY);
        System.out.println("command: " + joyY + " drive: " + motor.getAppliedOutput() + " encvel:" + encoder.getVelocity() );
        motor.set(joyY);
       
    }
}