package org.firstinspires.ftc.teamcode.alinaCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Alina kawaii OpMode", group="Linear OpMode")
public class AlinaMain extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        //initialize hardware
        alinaDrive alinaDrive = new alinaDrive(hardwareMap);

        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until driver presses STOP
        while (opModeIsActive()) {
            //call all the functions
            alinaDrive.alinaDriveFunction(gamepad1, telemetry);

            // Show the elapsed game time, wheel power... (more stuff later :3)
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.update();
        }
    }
}
