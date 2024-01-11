package frc.robot.subsystems;

import com.revrobotics.*;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase {
    
    private CANSparkMax motor = new CANSparkMax(Constants.MOTOR_CAN_ID, MotorType.kBrushless); 
     private CANSparkMax motor2 = new CANSparkMax(Constants.MOTOR2_CAN_ID, MotorType.kBrushless); // Create the Spark Max object in the program and include the CAN id and the type of motor used with the controller
    private RelativeEncoder encoder = motor.getEncoder(); // Grab the attached encoder
    private RelativeEncoder encoder2 = motor2.getEncoder(); // Grab the attached encoder

     public void setMotor(double joyY) {
        joyY=joyY/1;
        SmartDashboard.putNumber("Encoder", encoder.getVelocity());
        SmartDashboard.putNumber("JoyPos", joyY);
        System.out.println("command: " + joyY + " drive: " + motor.getAppliedOutput() + " encvel:" + encoder.getVelocity() );
        motor.set(joyY);
        motor2.set(joyY);
            
        
    }
    
    public void triggerMotor(boolean trigger) {
        if(trigger){
        SmartDashboard.putNumber("Encoder", encoder.getVelocity());
        SmartDashboard.putNumber("JoyPos", Constants.SHOOTERSPEED);
        System.out.println("command: " + Constants.SHOOTERSPEED + " drive: " + motor.getAppliedOutput() + " encvel:" + encoder.getVelocity() );
        motor.set(Constants.SHOOTERSPEED);
        motor2.set(Constants.SHOOTERSPEED);
        }
        else{
               SmartDashboard.putNumber("Encoder", encoder.getVelocity());
        SmartDashboard.putNumber("JoyPos", Constants.SHOOTERSPEED);
        System.out.println("command: " + Constants.SHOOTERSPEED + " drive: " + motor.getAppliedOutput() + " encvel:" + encoder.getVelocity() );
        motor.set(0);
        motor2.set(0);
        }
            
        
    }
    

    
}