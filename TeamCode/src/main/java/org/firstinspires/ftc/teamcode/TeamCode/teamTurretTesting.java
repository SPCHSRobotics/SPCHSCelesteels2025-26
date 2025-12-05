package org.firstinspires.ftc.teamcode.TeamCode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@TeleOp(name = "Thu tests Spinning Turret OpMode", group = "Linear OpMode")
public class teamTurretTesting extends LinearOpMode {

    public DcMotor spinningMotor;


    @Override
    public void runOpMode() {
        spinningMotor = hardwareMap.get(DcMotor.class, "spinningMotor");
        spinningMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {
            telemetry.update();
            double max;

            double spinningMotorPower = gamepad1.left_stick_x;

            max = (Math.abs(spinningMotorPower));
            if (max > 1.0) {
                spinningMotorPower /= max;
            }
            spinningMotor.setPower(spinningMotorPower);

            telemetry.addData("Spinning motor", "%4.2f, %4.2f",spinningMotorPower, spinningMotorPower);
        
        }

    }

}
