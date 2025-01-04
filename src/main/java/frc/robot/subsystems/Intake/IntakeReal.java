package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class IntakeReal implements IntakeIO {
  private CANSparkMax intakeMotor = new CANSparkMax(0,MotorType.kBrushless);
  private double intakeGoalVolts = 0;
  
  public IntakeReal() 
  {
    
  }

  @Override
  public void setVoltage(double volts)
  {
    this.intakeGoalVolts = volts;
    intakeMotor.setVoltage(this.intakeGoalVolts);
  }

  @Override
  public void updateData(IntakeData data) {

    data.intakeGoalVolts = intakeMotor.getMotorTemperature();
    data.intakeVelocityRadPerSec = (intakeMotor.getEncoder().getVelocity()*Math.PI*2)/60;
    data.intakeGoalVolts = this.intakeGoalVolts;
  }
}
