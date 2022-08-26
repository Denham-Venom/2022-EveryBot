// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private VictorSPX leftParent = new VictorSPX(Constants.Drive.leftParentID);
  private VictorSPX leftChild = new VictorSPX(Constants.Drive.leftChildID);
  private VictorSPX rightParent = new VictorSPX(Constants.Drive.rightParentID);
  private VictorSPX rightChild = new VictorSPX(Constants.Drive.rightChildID);

  public DriveTrain() {
    motorConfig();
  }


  /* Instead of having to write out the whole motor config, we can instead
   * use the Lazy libraries and it'll do the motor config for us
   */
  private void motorConfig() {
    // Sets all motors to factory default.
    leftParent.configFactoryDefault();
    rightParent.configFactoryDefault();
    leftChild.configFactoryDefault();
    rightChild.configFactoryDefault();

    // --------------------------------------------
    // Netutral Mode brake for staying still
    leftParent.setNeutralMode(NeutralMode.Brake);
    rightParent.setNeutralMode(NeutralMode.Brake);
    leftChild.setNeutralMode(NeutralMode.Brake);
    rightChild.setNeutralMode(NeutralMode.Brake);
    // --------------------------------------------------

    //--------------------------------------
    // Inverted so the robot doesn't spin
    leftParent.setInverted(false);
    rightParent.setInverted(true);
    leftChild.setInverted(false);
    rightChild.setInverted(true);
    // -------------------------------------

    // ------------------------------------
    // Acceleration Ramping :)
    leftParent.configOpenloopRamp(0.25);
    leftParent.configClosedloopRamp(0);
    rightParent.configOpenloopRamp(0.25);
    rightParent.configClosedloopRamp(0);
    //-------------------------------------

    // Motors follow each other
    leftChild.follow(leftParent);
    rightChild.follow(rightParent);
    // --------------------------------------

  }

  /**
   * Sets left motors of drivetrain with percent output
   * 
   * @param output percent [-1.0, 1.0]
   */
  public void setLeftMotors(double output) {
    leftParent.set(ControlMode.PercentOutput, output);
  }

  public void setRightMotors(double output) {
    rightParent.set(ControlMode.PercentOutput, output);
  }

  public void stopMotors() {
    setLeftMotors(0);
    setRightMotors(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
