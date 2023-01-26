package frc.robot.subsystems;''

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.lang.IllegalArgumentException;



public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Drivebase() {

     CANSparkMax m_leftMotor1 = new CANSparkMax(1,kBrushed);
     CANSparkMax m_leftMotor2 = new CANSparkMax(2,kBrushed);
     CANSparkMax m_leftMotor3 = new CANSparkMax(3,kBrushed);
     CANSparkMax m_rightMotor4 = new CANSparkMax(4,kBrushed);
     CANSparkMax m_rightMotor5 = new CANSparkMax(5,kBrushed);
     CANSparkMax m_rightMotor6 = new CANSparkMax(6,kBrushed);

     

     MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_leftMotor1,m_leftMotor2,m_leftMotor3);

     MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_rightMotor1,m_rightMotor2,m_rightMotor3);

     Differentialdrive m_differentialDrive = new Differentialdrive(m_leftGroup,m_rightGroup); 

     m_leftGroup.setInverted(true);

     private final AHRS m_AHRS = new AHRS(Port.kMXP);

     public void arcadeDrive(double xSpeed, double zRotation){
        m_differentialDrive.arcadeDrive(zSpeed, zRotation);

     }  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Angle",m_AHRS.getAngle());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
