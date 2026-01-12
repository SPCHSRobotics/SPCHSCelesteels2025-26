package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamIntake {
    public DcMotor intakeMotor;

    public teamIntake(HardwareMap hardwareMap) {
        //call intake motor
        intakeMotor = hardwareMap.get(DcMotor.class,"intakeMotor");

        //set intake motor power
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void teamIntakeFunction(Gamepad gamepad1, Telemetry telemetry) {

        //holding right bumper turns on intake
        if (gamepad1.rightBumperWasPressed()) {
            intakeMotor.setPower(1);
        } else if (gamepad1.rightBumperWasReleased()) {
            intakeMotor.setPower(0);
        }
        //holding x outtakes
        if (gamepad1.xWasPressed()){
            intakeMotor.setPower(-1);
        } else if (gamepad1.xWasReleased()){
            intakeMotor.setPower(0);
        }
        telemetry.addData("intaking power:", intakeMotor);
    }
    }