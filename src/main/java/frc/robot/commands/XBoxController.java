// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivebase;

/** An example command that uses an example subsystem. */
public class XBoxcontroller extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final XBoxcontroller m_db;

  /**
   * Creates a new ExampleCommand.
   *
   * @param db The subsystem used by this command.
   */
  public XBoxcontroller(XBoxcontroller db) {
    m_db = db;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(db);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_db.arcadeDrive(0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_db.arcadeDrive(RobotContainer.m_controller.getLeftY(),RobotContainer.m_controller.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
