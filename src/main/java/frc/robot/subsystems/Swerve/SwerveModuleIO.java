package frc.robot.subsystems.Swerve;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public interface SwerveModuleIO {
    public static class SwerveData {
        public SwerveModulePosition position = new SwerveModulePosition();
        public SwerveModuleState theoreticalState = new SwerveModuleState();
        public double DriveVelocity = 0;
        public double DriveGoalVolts = 0;
        // turn motor shi
        public double WheelAngle = 0;
        public double TurnVelocity = 0;
        public double TurnGoalVolts = 0;
    }

    public default void updateData(SwerveData data) {

    }

    public default void setVoltage(double turnVolt, double driveVolt) {
        
    }
}
