package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamOuttake {
    public DcMotor outtakeMotor;


    public teamOuttake(HardwareMap hardwareMap) {
        //call intake motor
        outtakeMotor = hardwareMap.get(DcMotor.class,"Outtake");


        //set intake motor reverse
        outtakeMotor.setDirection(DcMotor.Direction.FORWARD);

        outtakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void teamOuttakeFunction(Gamepad gamepad1, Telemetry telemetry) {

        double shootingPower = 0.6;
        boolean shooting = false;
        //0.6 is power okay
        //when x is held, full power (6000 rpm), when b is held, 70% power (3000?), when both released, no power

        if (gamepad1.xWasPressed()) {
            shooting = !shooting;
        }

        if (shooting) {
            outtakeMotor.setPower(shootingPower);
        } else outtakeMotor.setPower(0);

        telemetry.addData("outtake power:",(shooting) ? "ON" : "OFF");

    }
}
