// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TeleopShoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
   
  // Joysticks
  private final Joystick driverController = new Joystick(0);
  private final Joystick operatorController = new Joystick(1);

  // Pilot Buttons
  private final JoystickButton intakeButton = new JoystickButton(driverController, XboxController.Button.kRightBumper.value);

  // Operator Buttons
  private final JoystickButton opIntake = new JoystickButton(operatorController, XboxController.Button.kRightBumper.value);
  private final JoystickButton opOuttake = new JoystickButton(operatorController, XboxController.Button.kLeftBumper.value);
  // private final JoystickButton opIntakeButton = new JoystickButton(operatorController, XboxController.Button.kLeftBumper.value);
  // private final JoystickButton shootButton = new JoystickButton(operatorController, XboxController.Button.kRightBumper.value);
  // private final JoystickButton armControlButton = new JoystickButton(operatorController, XboxController.Button.kB.value);
  
  // The robot's subsystems and commands are defined here...
  private final DriveTrain drivetrain = new DriveTrain();
  private final Shooter shooter = new Shooter();

  //private final TeleopDrive m_drive = new TeleopDrive(m_drivetrain, pilotDriverController);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drivetrain.setDefaultCommand(new TeleopDrive(drivetrain, driverController));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    intakeButton.whileHeld(new TeleopShoot(shooter, Constants.Intake.intakePower));

    opIntake.whileHeld(new TeleopShoot(shooter, Constants.Intake.intakePower));
    opOuttake.whileHeld(new TeleopShoot(shooter, Constants.Intake.outtakePower));
    // opIntakeButton.whileHeld(new TeleopShoot(shooter, Constants.Intake.intakePower));
    // shootButton.whileHeld(new TeleopShoot(shooter, Constants.Shooter.shooterPower));
    // armControlButton.whenPressed(new TeleopArm(intakeArm));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }
}