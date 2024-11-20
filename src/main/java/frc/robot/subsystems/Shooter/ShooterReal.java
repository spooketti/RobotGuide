package frc.robot.subsystems.Shooter;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ShooterReal implements ShooterIO {
    private CANSparkMax bottomMotor = new CANSparkMax(0,MotorType.kBrushless);
  private CANSparkMax topMotor = new CANSparkMax(0,MotorType.kBrushless);
  private double bottomGoalVolts = 0;
  private double topGoalVolts = 0;
  
  public ShooterReal() 
  {
    topMotor.setInverted(true);
  }

  @Override
  public void setVoltage(double bottomGoalVolts,double topGoalVolts)
  {
    this.bottomGoalVolts = bottomGoalVolts;
    this.topGoalVolts = topGoalVolts;
    bottomMotor.setVoltage(this.bottomGoalVolts);
    topMotor.setVoltage(this.topGoalVolts);
  }

  @Override
  public void updateData(ShooterData data) {

    data.topTemperatureCelsius = topMotor.getMotorTemperature();
    data.topVelocityRadPerSec = (topMotor.getEncoder().getVelocity()*Math.PI*2)/60;
    data.topGoalVolts = this.topGoalVolts;

    data.bottomTemperatureCelsius = bottomMotor.getMotorTemperature();
    data.bottomVelocityRadPerSec = (bottomMotor.getEncoder().getVelocity()*Math.PI*2)/60;
    data.bottomGoalVolts = this.bottomGoalVolts;
  }
}
