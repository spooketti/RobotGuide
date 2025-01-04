package frc.robot.subsystems.Swerve;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.Swerve.SwerveModuleIO.SwerveData;

public class Swerve extends SubsystemBase{

    private SwerveDrivePoseEstimator swerveEstimator;
    private SwerveModuleIO[] modules = new SwerveModuleIO[4];
    private SwerveData[] swerveData = new SwerveData[4];

    public Swerve()
    {
        if(Constants.SimConstants.isSim)
        {
            for(int i=0;i<4;i++)
            {
                
            }
        }
        else
        {   
        }
        swerveEstimator = new SwerveDrivePoseEstimator(Constants.Swerve.driveKinematics, new Rotation2d(0,0), 
        new SwerveModulePosition[] {swerveData[0].}, null)
    }




}
