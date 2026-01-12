package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamShooter {

    public DcMotor shooterMotor;


    public teamShooter(HardwareMap hardwareMap) {
        //call intake motor
        shooterMotor = hardwareMap.get(DcMotor.class,"shooterMotor");


        //set intake motor reverse
        shooterMotor.setDirection(DcMotor.Direction.REVERSE);
        shooterMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void teamShooterFunction(Gamepad gamepad1, Telemetry telemetry) {

        double shootingPower = 1;

        //hold down left bumper to rev up shooter
        if (gamepad1.leftBumperWasPressed()) {
            shooterMotor.setPower(shootingPower);
        } else if (gamepad1.leftBumperWasReleased()) {
            shooterMotor.setPower(0);
        }
        telemetry.addData("shooting power:", shootingPower);
    }
}
