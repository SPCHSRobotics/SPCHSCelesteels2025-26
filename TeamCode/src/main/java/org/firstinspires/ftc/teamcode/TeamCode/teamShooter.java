package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamShooter {

    public DcMotor shooterMotor;


    public teamShooter(HardwareMap hardwareMap) {
        //call intake motor
        shooterMotor = hardwareMap.get(DcMotor.class,"shooterMotor");


        //set intake motor reverse
        shooterMotor.setDirection(DcMotor.Direction.FORWARD);

        shooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void teamShooterFunction(Gamepad gamepad2, Telemetry telemetry) {

        double shootingPower = 0.6;

        //hold down a to rev up shooter
        if (gamepad2.aWasPressed()) {
            shooterMotor.setPower(shootingPower);
        } else if (gamepad2.aWasReleased()) {
            shooterMotor.setPower(0);
        }

    }
}
