package frc.robot.subsystems.Shooter;

public interface ShooterIO {

    public static class ShooterData
    {
        public double bottomGoalVolts = 0;
        public double bottomTemperatureCelsius = 0;
        public double bottomVelocityRadPerSec = 0;
        
        public double topGoalVolts = 0;
        public double topTemperatureCelsius = 0;
        public double topVelocityRadPerSec = 0;
    }

    public default void updateData(ShooterData data)
    {

    }

    public default void setVoltage(double bottomVolt, double topVolt)
    {

    }
}
