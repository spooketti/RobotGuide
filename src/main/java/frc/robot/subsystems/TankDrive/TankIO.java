package frc.robot.subsystems.TankDrive;

public interface TankIO {

    public static class TankData
    {
        public double topLeftGoalVolts = 0;
        public double topLeftTemperatureCelsius = 0;
        public double topLeftVelocityRadPerSec = 0;
        
        public double topRightGoalVolts = 0;
        public double topRightTemperatureCelsius = 0;
        public double topRightVelocityRadPerSec = 0;

        public double bottomLeftGoalVolts = 0;
        public double bottomLeftTemperatureCelsius = 0;
        public double bottomLeftVelocityRadPerSec = 0;
        
        public double bottomRightGoalVolts = 0;
        public double bottomRightTemperatureCelsius = 0;
        public double bottomRightVelocityRadPerSec = 0;
    }

    public default void updateData(TankData data)
    {

    }

    public default void setVoltage(double left, double topVolt)
    {

    }
}
