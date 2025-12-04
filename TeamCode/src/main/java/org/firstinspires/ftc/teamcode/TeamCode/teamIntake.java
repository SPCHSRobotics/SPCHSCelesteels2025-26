package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamIntake {
    public DcMotor IntakeMotor;

    public teamIntake(HardwareMap hardwareMap) {
        //call intake motor
        IntakeMotor = hardwareMap.get(DcMotor.class,"IntakeMotor");

        //set intake motor power
        IntakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void teamIntakeFunction(Gamepad gamepad1, Telemetry telemetry){

        double intakeOn = 1;
        boolean intaking = false;
        //holding down a turns on intake
        if (gamepad1.aWasPressed()) {
           intaking = !intaking;
        }

        if (intaking) {
            IntakeMotor.setPower(intakeOn);
        }  else IntakeMotor.setPower(0);

        }


        //show what the intake power is on driver hub
        //telemetry.addData("intake power:",(intaking) ? "ON" : "OFF");

    }