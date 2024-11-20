package frc.robot.subsystems.Shooter;

import edu.wpi.first.math.controller.PIDController;

public class ShooterConfig {
     public static final PIDController shooterPID = new PIDController(1, 0, 0);

}
