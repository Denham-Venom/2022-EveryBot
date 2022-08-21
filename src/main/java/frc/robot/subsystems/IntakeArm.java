// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeArm extends SubsystemBase {
  /** Creates a new IntakeArm. */
  private TalonFX arm = new TalonFX(Constants.Intake.intakeArmID);

  public IntakeArm() {
    arm.configFactoryDefault();
    arm.setInverted(false);
    arm.setNeutralMode(NeutralMode.Brake);

  }
  
  public void controlArm() {
    
    // if(Constants.Intake.armUp){
    //   if(Timer.getFPGATimestamp() < Constants.Intake.armTimeUp){
    //     arm.set(TalonFXControlMode.PercentOutput, Constants.Intake.armTravel);
    //   }
    //   else{
    //     arm.set(TalonFXControlMode.PercentOutput, Constants.Intake.armHoldUp);
    //   }
    // }
    // else{
    //   if(Timer.getFPGATimestamp() < Constants.Intake.armTimeDown){
    //     arm.set(TalonFXControlMode.PercentOutput, -Constants.Intake.armTravel);
    //   }
    //   else{
    //     arm.set(TalonFXControlMode.PercentOutput, -Constants.Intake.armHoldUp);
    //   }
    // }
  }

  /**
   * Sets intake arm motor with percent output
   * 
   * @param output percent [-1.0, 1.0]
   */
  // public void setIntakeArm(double output) {
  //   arm.set(TalonFXControlMode.PercentOutput, output);
  // }

  // public void stopIntakeArm() {
  //   setIntakeArm(0);
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
