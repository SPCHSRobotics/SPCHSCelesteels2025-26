package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamIntake {
    public DcMotor intakeMotor;
    boolean intaking = false;
    boolean lastButton = false;
    boolean toggleState = false;

    public teamIntake(HardwareMap hardwareMap) {
        //call intake motor
        intakeMotor = hardwareMap.get(DcMotor.class,"IntakeMotor");

        //set intake motor power
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void teamIntakeFunction(Gamepad gamepad1, Telemetry telemetry){

        double intakeOn = 1;

        //holding down a turns on intake
        if (gamepad1.a) {
           intaking = true;
        } else {
            intaking = false;
        }

        if (intaking && !lastButton) {
            toggleState = !toggleState;
        }

        if (toggleState){
            intakeMotor.setPower(.5);
        } else {
            intakeMotor.setPower(0);
        }
        lastButton = intaking;

        }


        //show what the intake power is on driver hub
        //telemetry.addData("intake power:",(intaking) ? "ON" : "OFF");

    }