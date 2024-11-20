// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.Constants;

public class ShooterSim implements ShooterIO {
  private FlywheelSim bottomMotor = new FlywheelSim(DCMotor.getNEO(1), 1, 0.02);
  private FlywheelSim topMotor = new FlywheelSim(DCMotor.getNEO(1), 1, 0.02);
  private double bottomGoalVolts = 0;
  private double topGoalVolts = 0;
  
  public ShooterSim() 
  {

  }

  @Override
  public void setVoltage(double bottomGoalVolts,double topGoalVolts)
  {
    this.bottomGoalVolts = bottomGoalVolts;
    this.topGoalVolts = topGoalVolts;
    bottomMotor.setInputVoltage(this.bottomGoalVolts);
    topMotor.setInputVoltage(this.topGoalVolts);
  }

  @Override
  public void updateData(ShooterData data) {
    bottomMotor.update(Constants.SimConstants.simLoopPeriodic);
    topMotor.update(Constants.SimConstants.simLoopPeriodic);

    data.topTemperatureCelsius = 0;
    data.topVelocityRadPerSec = topMotor.getAngularVelocityRadPerSec();
    data.topGoalVolts = this.topGoalVolts;

    data.bottomTemperatureCelsius = 0;
    data.bottomVelocityRadPerSec = bottomMotor.getAngularVelocityRadPerSec();
    data.bottomGoalVolts = this.bottomGoalVolts;
  }
}
