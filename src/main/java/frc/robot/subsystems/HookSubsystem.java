package frc.robot.subsystems;
import java.util.*;
import com.revrobotics.*;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HookSubsystem extends SubsystemBase {
    private CANSparkMax hookMotor = new CANSparkMax(Constants.MOTOR_CAN_ID, MotorType.kBrushless); // Create the Spark Max object in the program and include the CAN id and the type of motor used with the controller
    private RelativeEncoder hookEncoder = hookMotor.getEncoder(); // Grab the attached encoder
    private final SparkPIDController hookController;
    hookController = hookMotor.getPIDController();
    hookController.setP(0);
    hookController.setI(0);
    hookController.setD(0);
    hookController.setFF(0);


    public void raiseMotor() {   
        private CANSparkMax hookRaising = new CANSparkMax(Constants.MAXIMUMHOOK_HEIGHT, MotorType.kBrushless); 
        System.out.println("Raising Hook");
        hookController.setReference(hookEncoder.getDegrees(), ControlType, kPosition);
        hookController.setReference(0, ControlType.kPosition);
        hookRaising.set(0.5);
        double i = hookEncoder.getPosition();
        while (i<5){
            i = hookEncoder.getPosition();
        }
        hookRaising.stopMotor();

    }

    public void downHook() {
        private CANSparkMax hookDepth = new CANSparkMax(Constants.MAXIMUMHOOK_DEPTH, MotorType.kBrushless); 
        hookController.setReference(hook.getDegrees(), ControlType,kPosition);
        hookController.setReference(angle, ControlType.kPosition);
        System.out.println("Down Hook");
        hookDepth.set(-0.5);
        hookEncoder.setPosition(0);
        double i = hookEncoder.getPosition();
        while (i>-5){
            i = hookEncoder.getPosition();
        }
        hookDepth.stopMotor();
    }
    
    protected void execute() {
        //SmartDashboard.putNumber("Shooter Angle", .getPosition());
        SmartDashboard.putNumber("Hook Height", hookEncoder.getPosition());
        SmartDashboard.putNumber("Hook Depth", hookEncoder.getPosition());        
        //SmartDashboard.putNumber("Speed", );
        //SmartDashboard.putNumber("Left Drive Encoder", 0);
        //SmartDashboard.putNumber("Right Drive Encoder", 0);
        //SmartDashboard.putNumber("Swerve Angle", 0);
    }
}
