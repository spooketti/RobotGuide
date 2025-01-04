package frc.robot.subsystems.Swerve;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class SwerveModuleSim implements SwerveModuleIO{
    private FlywheelSim driveMotor = new FlywheelSim(DCMotor.getNEO(0), 0, 0);
    private FlywheelSim turnMotor = new FlywheelSim(DCMotor.getNEO(0), 0, 0);
    private PIDController drivePID = new PIDController(1, 0, 0);
    private PIDController turnPID = new PIDController(1, 0, 0);
    private SwerveModuleState simState = new SwerveModuleState();

    private double turnPositionRad = 0;

    //translational velocity = angular velocity * radius

    public SwerveModuleSim()
    {
        turnPID.enableContinuousInput(0, Math.PI*2);
    }

    @Override
    public void updateData(SwerveData swerveData)
    {
        driveMotor.update(0.02);
        turnMotor.update(0.02);

        swerveData.DriveVelocity = driveMotor.getAngularVelocityRadPerSec();
        swerveData.TurnVelocity = turnMotor.getAngularVelocityRadPerSec();
        swerveData.WheelAngle += turnMotor.getAngularVelocityRadPerSec() * 0.02; // m/s * s = m (6.28m circumference math u know)

        if(swerveData.WheelAngle > Math.PI * 2)
        {
            swerveData.WheelAngle %= (Math.PI*2);
        }
        if(swerveData.WheelAngle < 0)
        {
            swerveData.WheelAngle = (swerveData.WheelAngle % (Math.PI*2)) + Math.PI*2;
        }
        turnPositionRad = swerveData.WheelAngle;
    }

    private SwerveModuleState getState()
    {
        return new SwerveModuleState(driveMotor.getAngularVelocityRadPerSec(),new Rotation2d(turnPositionRad));
    }

    



    @Override
    public void setVoltage(double turnVolt, double driveVolt)
    {

    }
    





    
}
