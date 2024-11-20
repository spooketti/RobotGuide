package frc.robot.subsystems.TankDrive;

import edu.wpi.first.math.controller.PIDController;

public class TankConfig {
    public static final PIDController TankPID = new PIDController(1, 0, 0);
}
