// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.Constants;

public class IntakeSim implements IntakeIO {
  private FlywheelSim intakeMotor = new FlywheelSim(DCMotor.getNEO(1), 1, 0.02);
  private double intakeGoalVolts = 0;
  
  public IntakeSim() 
  {

  }

  @Override
  public void setVoltage(double goalVolts)
  {
    this.intakeGoalVolts = goalVolts;
    intakeMotor.setInputVoltage(this.intakeGoalVolts);
  }

  @Override
  public void updateData(IntakeData data) {
    intakeMotor.update(Constants.SimConstants.simLoopPeriodic);

    data.intakeTemperatureCelsius = 0;
    data.intakeVelocityRadPerSec = intakeMotor.getAngularVelocityRadPerSec();
    data.intakeGoalVolts = this.intakeGoalVolts;
  }
}
