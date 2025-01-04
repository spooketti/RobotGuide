package frc.robot.subsystems.Intake;

public interface IntakeIO {

    public static class IntakeData
    {
        public double intakeGoalVolts = 0;
        public double intakeTemperatureCelsius = 0;
        public double intakeVelocityRadPerSec = 0;
    }

    public default void updateData(IntakeData data)
    {

    }

    public default void setVoltage(double volts)
    {

    }
}
