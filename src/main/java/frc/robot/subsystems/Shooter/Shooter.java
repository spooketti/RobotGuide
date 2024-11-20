// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter.ShooterIO.ShooterData;

public class Shooter extends SubsystemBase {

    public ShooterData shooterData = new ShooterData();
    public double goalVelocityRadPerSec = 0;

    private ShooterIO shooterIO;
    public Shooter() {
        shooterIO = new ShooterReal();
        if (Constants.SimConstants.isSim) {
            shooterIO = new ShooterSim();
        }
    }

    public void stop()
    {

        goalVelocityRadPerSec = 0;
        shooterIO.setVoltage(0, 0);
    }

    public void setGoalVelocity(double goalVelocity)
    {
        goalVelocityRadPerSec = goalVelocity;
    }

    private void setVelocity()
    {
       shooterIO.setVoltage(ShooterConfig.shooterPID.calculate(shooterData.bottomVelocityRadPerSec,goalVelocityRadPerSec),
       ShooterConfig.shooterPID.calculate(shooterData.topVelocityRadPerSec,goalVelocityRadPerSec));
    }

    @Override
    public void periodic() {
        shooterIO.updateData(shooterData);
        setVelocity();
        SmartDashboard.putNumber("ShooterVelocity", shooterData.topVelocityRadPerSec);
    }
}
