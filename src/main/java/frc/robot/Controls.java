package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.example.ExampleSetSpeedCommand;
import frc.robot.subsystems.ExampleSubsystem;

public class Controls {
    public static final boolean EXAMPLE_ENABLED = true;
    public static final int DRIVE_CONTROLLER_PORT = 0;

    private final CommandXboxController driverController;

    // Normally, more descriptive names are better, but in this case, we care
    // about making the subsystem access easy
    private final Subsystems s;

    public Controls(Subsystems s) {
        driverController = new CommandXboxController(DRIVE_CONTROLLER_PORT);
        this.s = s;
        if (EXAMPLE_ENABLED) {
            bindExampleControls();
        }
    }

    private void bindExampleControls() {
        DoubleSupplier getleftY =() -> driverController.getLeftY();
        driverController.a().onTrue(s.exampleSubsystem.setSpeedCmd(getleftY));
        
    }
}
