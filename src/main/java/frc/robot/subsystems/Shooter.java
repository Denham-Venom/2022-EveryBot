// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private VictorSPX shooter = new VictorSPX(Constants.Shooter.shooterID);

  public Shooter() {
    shooter.configFactoryDefault();
    shooter.setInverted(false);
    shooter.setNeutralMode(NeutralMode.Brake);
  }

  /**
   * Sets shooter motor with percent output
   * 
   * @param output percent [-1.0, 1.0]
   */
  public void setShooterPower(double output) {
    shooter.set(ControlMode.PercentOutput, output);
  }

  public void stopShooter() {
    setShooterPower(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
