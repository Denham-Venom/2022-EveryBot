// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class TeleopDrive extends CommandBase {
  /** Creates a new TeleopDrive. */
  private DriveTrain drive;
  private Joystick pilot;
  private double speed;
  private boolean isTeleop;
  
  public TeleopDrive(DriveTrain drive, Joystick pilotController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    pilot = pilotController;
    isTeleop = true;
    addRequirements(drive);
  }

  public TeleopDrive(DriveTrain drive, double speed) {
    this.drive = drive;
    this.speed = speed;
    isTeleop = false;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(isTeleop) {
      double leftStickY = pilot.getRawAxis(XboxController.Axis.kLeftY.value);
      double rightStickX = pilot.getRawAxis(XboxController.Axis.kRightX.value);

      drive.setLeftMotors(leftStickY + rightStickX);
      drive.setRightMotors(leftStickY - rightStickX);
    } else {
      drive.setLeftMotors(speed);
      drive.setRightMotors(speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
