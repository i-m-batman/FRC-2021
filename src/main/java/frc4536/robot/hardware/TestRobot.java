package frc4536.robot.hardware;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc4536.lib.CIMEncoder;
import frc4536.lib.IEncoderMotor;
import frc4536.lib.VirtualMotor;
import frc4536.lib.VirtualEncoderMotor;

public class TestRobot implements RobotFrame {
    // TODO: these need tick values!
    // TODO: all of these values are sinful    
    private final double ksVolts = 2;
    private final double kvVoltSecondsPerMeter = 0.353;
    private final double kaVoltSecondsSquaredPerMeter = 0.00864;
    private final double kPDriveVel = 0.0233;
    private final double kTrackWidthMeters = 0.71;
    private final double kMaxSpeedMetersPerSecond = 8;
    private final double kMaxAccelerationMetersPerSecondSquared = 3;
    private final double kRamseteB = 2;
    private final double kRamseteZeta = 0.7;
    public RobotConstants m_constants = new RobotConstants(ksVolts, 
                                                           kvVoltSecondsPerMeter, 
                                                           kaVoltSecondsSquaredPerMeter, 
                                                           kPDriveVel, 
                                                           kTrackWidthMeters, 
                                                           kMaxSpeedMetersPerSecond, 
                                                           kMaxAccelerationMetersPerSecondSquared, 
                                                           kRamseteB, 
                                                           kRamseteZeta);

    IEncoderMotor m_topFlywheel = new VirtualEncoderMotor("Top Flywheel",8.0*0.478779);
    IEncoderMotor m_bottomFlywheel = new VirtualEncoderMotor("Bottom Flywheel",8.0*0.478779);
    VirtualMotor m_intakeMotor = new VirtualMotor("Intake Motor");
    VirtualMotor m_beltMotor = new VirtualMotor("Belt Motor");
    VirtualMotor m_climberArmMotor = new VirtualMotor("Climber Motor");
    VirtualMotor m_liftMotor = new VirtualMotor("Lift Motor");

    AHRS m_navx = new AHRS();
    Encoder m_leftEncoder = new Encoder(0,1);
    Encoder m_rightEncoder = new Encoder(2,3);
    CIMEncoder m_leftMotors = new CIMEncoder(new SpeedControllerGroup(new Spark(0), new Spark(1)), m_leftEncoder, 2048);
    CIMEncoder m_rightMotors = new CIMEncoder(new SpeedControllerGroup(new Spark(2), new Spark(3)), m_rightEncoder, 2048);

    @Override
    public RobotConstants getConstants() {
        return m_constants;
    }

    @Override
    public IEncoderMotor getDrivetrainRightMotor() {
        return m_rightMotors;
    }

    @Override
    public IEncoderMotor getDrivetrainLeftMotor() {
        return m_leftMotors;
    }

    @Override
    public SpeedController getClimberArmMotor() {
        return m_climberArmMotor;
    }

    @Override
    public SpeedController getLiftMotor() {
        return m_liftMotor;
    }

    @Override
    public SpeedController getIntakeMotor() {
        return m_intakeMotor;
    }

    @Override
    public SpeedController getBeltMotor() {
        return m_beltMotor;
    }

    @Override
    public AHRS getDrivetrainNavX() {
        return m_navx;
    }
    @Override
    public IEncoderMotor getTopShooterFlywheelMotor() {
        return m_topFlywheel;
    }

    @Override
    public IEncoderMotor getBottomShooterFlywheelMotor() {
        return m_bottomFlywheel;
    }
}