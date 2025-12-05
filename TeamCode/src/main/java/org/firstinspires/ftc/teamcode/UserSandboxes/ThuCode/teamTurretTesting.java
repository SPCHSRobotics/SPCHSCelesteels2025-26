package org.firstinspires.ftc.teamcode.userSandboxes.ThuCode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@TeleOp(name = "Thu tests Spinning Turret OpMode", group = "Linear OpMode")
public class teamTurretTesting extends LinearOpMode {
    public DcMotor spinningMotor;
    @Override
    public void runOpMode() {

        spinningMotor = hardwareMap.get(DcMotor.class, "spinning motor");
        spinningMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spinningMotor.setDirection(DcMotor.Direction.REVERSE);


        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {
            teamTurretTestingFunction(gamepad1, telemetry);
            telemetry.update();
        
        }

    }

    public void teamTurretTestingFunction(Gamepad gamepad2, Telemetry telemetry){
        double max;

        double axial   = -gamepad2.left_stick_y;
        double lateral =  -gamepad2.left_stick_x;
        double yaw     =  gamepad2.right_stick_x;

        double spinningMotorPower = axial - lateral + yaw;

        max = (Math.abs(spinningMotorPower));
        if (max > 1.0) {
            spinningMotorPower /= max;
        }
        spinningMotor.setPower(spinningMotorPower);
        telemetry.addData("Spinning motor", "%4.2f, %4.2f",spinningMotorPower, spinningMotorPower);
    }

}
