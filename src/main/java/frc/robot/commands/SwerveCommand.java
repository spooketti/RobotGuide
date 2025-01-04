package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class SwerveCommand extends Command{

private double leftX = 0;
private double leftY = 0;
private double rightY = 0;

public SwerveCommand(double leftX, double leftY, double rightY)
{
    this.leftX = leftX;
    this.leftY = leftY;
    this.rightY = rightY;
}

@Override
public void initialize() 
{
    
}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
}
