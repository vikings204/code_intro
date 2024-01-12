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
        System.out.println("Raising Hook");
        hookController.setReference(hookEncoder.getDegrees(), ControlType, kPosition);
        hookController.setReference(0, ControlType.kPosition);
        hookMotor.set(0.5);
        double i = hookEncoder.getPosition();
        while (i<5){
            i = hookEncoder.getPosition();
        }
        hookMotor.stopMotor();
        hookController.
    }

    public void downHook() {
        hookController.setReference(hook.getDegrees(), ControlType,kPosition);
        hookController.setReference(angle, ControlType.kPosition);
        System.out.println("Down Hook");
        hookMotor.set(-0.5);
        hookEncoder.setPosition(0);
        double i = hookEncoder.getPosition();
        while (i>-5){
            i = hookEncoder.getPosition();
        }
        hookMotor.stopMotor();
    }
}
