package frc.robot.subsystems.Shooter;

public interface ShooterIO {

    public static class shooterData
    {
        public double bottomVolts = 0;
        public double bottomTemperatureCelsius = 0;
        public double bottomVelocityRadPerSec = 0;
        
        public double topVolts = 0;
        public double topTemperatureCelsius = 0;
        public double topVelocityRadPerSec = 0;
    }

    public default void updateData(shooterData data)
    {

    }

    public default void setVoltage(double volts)
    {

    }
}
