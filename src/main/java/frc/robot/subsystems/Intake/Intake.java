// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake.IntakeIO.IntakeData;

public class Intake extends SubsystemBase {

    public IntakeData intakeData = new IntakeData();
    public double goalVelocityRadPerSec = 0;

    private IntakeIO intakeIO;
    public Intake() {
        intakeIO = new IntakeReal();
        if (Constants.SimConstants.isSim) {
            intakeIO = new IntakeSim();
        }
    }

    public void stop()
    {

        goalVelocityRadPerSec = 0;
        intakeIO.setVoltage(0);
    }

    public void setGoalVelocity(double goalVelocity)
    {
        goalVelocityRadPerSec = goalVelocity;
    }

    private void setVelocity()
    {
       intakeIO.setVoltage(IntakeConfig.intakePID.calculate(intakeData.intakeVelocityRadPerSec,goalVelocityRadPerSec));
    }

    @Override
    public void periodic() {
        intakeIO.updateData(intakeData);
        setVelocity();
        SmartDashboard.putNumber("IntakeVelocity", intakeData.intakeVelocityRadPerSec);
    }
}
