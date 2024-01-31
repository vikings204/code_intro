package frc.robot.subsystems;
import java.util.*;
import com.revrobotics.*;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HookSubsystem extends SubsystemBase {
    private CANSparkMax hookMotor;  // Create the Spark Max object in the program and include the CAN id and the type of motor used with the controller
    private RelativeEncoder hookEncoder; // Grab the attached encoder
    private final SparkPIDController hookController; 

    public HookSubsystem() {
        hookMotor = new CANSparkMax(Constants.MOTOR_CAN_ID, MotorType.kBrushless); // Create the Spark Max object in the program and include the CAN id and the type of motor used with the controller
        hookEncoder = hookMotor.getEncoder(); // Grab the attached encoder
        hookController = hookMotor.getPIDController();
        hookController = hookMotor.getPIDController();
        hookController.setP(0);
        hookController.setI(0);
        hookController.setD(0);
        hookController.setFF(0);
    }


    

    
    double i = hookEncoder.getPosition();

    //raises the hook motor
    public void raiseMotor() {
        //private CANSparkMax hookRaising = new CANSparkMax(Constants.MAXIMUMHOOK_HEIGHT, MotorType.kBrushless); 
        System.out.println("Raising Hook");
        hookController.setReference(hookEncoder.getDegrees(), ControlType.kPosition);
    }

    //lowers the hook motor
    public static void downHook() {
        private CANSparkMax hookDepth = new CANSparkMax(Constants.MAXIMUMHOOK_DEPTH, MotorType.kBrushless); 
        hookController.setReference(hook.getDegrees(), ControlType,kPosition);
        hookController.setReference(angle, ControlType.kPosition);
        System.out.println("Down Hook");
        hookDepth.set(-0.5);
        hookEncoder.setPosition(0);
        while (i>-5){
            i = hookEncoder.getPosition();
        }
        hookDepth.stopMotor();
    }
}
    
    //Shuffleboard
    Shuffleboard.getTab("Hook Height")
        .addPersistent("Max Height", MAXIMUMHOOK_HEIGHT)
        .withWidget(BuiltInWidgets.kNumberSlider)
        .withProperties(Map.of("min", 0, "max", 5))
        .withSize(330,270)
        .withPosition(500,0)  
        .getEntry();
    Shuffleboard.getTab("Hook Depth")
        .addPersistent("Max Depth", MAXIMUMHOOK_DEPTH)
        .withWidget(BuiltInWidgets.kNumberSlider)
        .withProperties(Map.of("min", 0, "max", -5))
        .withSize(330,270)
        .withPosition(500,275)  
        .getEntry();
    Shuffleboard.getTab("Shooter Angle")
        .addPersistent("Shooter Angle", SHOOTER_ANGLE)
        .withSize(800,530)
        .withPosition(850,0)  
        .getEntry();
    Shuffleboard.getTab("Speed")
        .addPersistent("Speed", SPEED)
        .withSize(330,520)
        .withPosition(500,550)  
        .getEntry();
    Shuffleboard.getTab("Front Left Drive Encoder")
        .addPersistent("Front Left Drive Encoder", FRONTLEFT_DRIVE_ENCODER)
        .withSize(495,269)
        .withPosition(0,0)  
        .getEntry();
    Shuffleboard.getTab("Front Right Drive Encoder")
        .addPersistent("Front Right Drive Encoder", FRONTRIGHT_DRIVE_ENCODER)
        .withSize(495,269)
        .withPosition(0,270)  
        .getEntry();
    Shuffleboard.getTab("Back Left Drive Encoder")
        .addPersistent("Back Left Drive Encoder", BACKLEFT_DRIVE_ENCODER)
        .withSize(495,269)
        .withPosition(0,540)  
        .getEntry();
    Shuffleboard.getTab("Right Drive Encoder")
        .addPersistent("Back Right Drive Encoder", BACKRIGHT_DRIVE_ENCODER)
        .withSize(495,269)
        .withPosition(0,810)  
        .getEntry(); 
    Shuffleboard.getTab("Swerve Angle")
        .addPersistent("Swerve Angle", SWERVE_ANGLE)
        .withSize(800,530)
        .withPosition(850,545)  
        .getEntry();
    protected void execute() {
        SmartDashboard.putNumber("Hook Height", hookEncoder.getPosition());
        SmartDashboard.putNumber("Hook Depth", hookEncoder.getPosition());
        //SmartDashboard.putNumber("Shooter Angle", .getPosition());        
        //SmartDashboard.putNumber("Speed", );
        //SmartDashboard.putNumber("Front Left Drive Encoder", 0);
        //SmartDashboard.putNumber("Front Right Drive Encoder", 0);
        //SmartDashboard.putNumber("Back Left Drive Encoder", 0);
        //SmartDashboard.putNumber("Back Right Drive Encoder", 0);
        //SmartDashboard.putNumber("Swerve Angle", 0);
        }

    }
}


