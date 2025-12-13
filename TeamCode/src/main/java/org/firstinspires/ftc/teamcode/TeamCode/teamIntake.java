package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamIntake {
    public DcMotor intakeMotor;
    boolean intaking = false;
    boolean intakeLastButton = false;
    boolean intakeToggleState = false;
    boolean outtaking = false;
    boolean outtakeLastButton = false;
    boolean outtakeToggleState = false;

    public teamIntake(HardwareMap hardwareMap) {
        //call intake motor
        intakeMotor = hardwareMap.get(DcMotor.class,"intakeMotor");

        //set intake motor power
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void teamIntakeFunction(Gamepad gamepad1, Telemetry telemetry){

        //pressing a toggles intake on and off
        if (gamepad1.a) {
           intaking = true;
        } else {
            intaking = false;
        }

        if (intaking && !intakeLastButton) {
            intakeToggleState = !intakeToggleState;
        }

        if (intakeToggleState){
            intakeMotor.setPower(1);
        } else {
            intakeMotor.setPower(0);
        }
        intakeLastButton = intaking;

        //pressing b toggles outtake on and off
        if(gamepad1.b) {
            outtaking = true;
        } else {
            outtaking = false;
        }

        if(outtakeToggleState && !outtakeLastButton){
            outtakeToggleState = !outtakeToggleState;
        }

        if (outtakeToggleState){
            intakeMotor.setPower(-1);
        } else {
            intakeMotor.setPower(0);
        }
        outtakeLastButton = outtaking;

        }

        //show what the intake power is on driver hub
        //telemetry.addData("intake power:",(intaking) ? "ON" : "OFF");

    }