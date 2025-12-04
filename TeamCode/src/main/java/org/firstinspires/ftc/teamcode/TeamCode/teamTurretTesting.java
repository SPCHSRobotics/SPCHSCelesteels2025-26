package org.firstinspires.ftc.teamcode.TeamCode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@TeleOp(name = "Thu tests Spinning Turret OpMode", group = "Linear OpMode")
public class teamTurretTesting extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {
            telemetry.update();
        
        }

    }

}
