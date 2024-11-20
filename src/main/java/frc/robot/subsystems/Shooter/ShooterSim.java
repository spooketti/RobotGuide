// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSim implements ShooterIO {
  private FlywheelSim bottomMotor = new FlywheelSim(DCMotor.getNEO(0), 0, 0);
  private FlywheelSim topMotor = new FlywheelSim(DCMotor.getNEO(0), 0, 0);
  private double goalVolts = 0;
  
  public ShooterSim() {}

  public void test()
  {
    bottomMotor.
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
