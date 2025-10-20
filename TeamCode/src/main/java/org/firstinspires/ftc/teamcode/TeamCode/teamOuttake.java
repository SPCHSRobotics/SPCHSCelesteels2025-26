package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamOuttake {
    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;

    public teamOuttake(HardwareMap hardwareMap) {
        //call intake motor
        outtakeMotorLeft = hardwareMap.get(DcMotor.class,"LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class,"RightOuttake");


        //set intake motor reverse
        outtakeMotorLeft.setDirection(DcMotor.Direction.REVERSE);
        outtakeMotorRight.setDirection(DcMotor.Direction.FORWARD);
    }

    public void teamOuttakeFunction(Gamepad gamepad2, Telemetry telemetry){

        double outtakePower = 0;

        if (gamepad2.xWasPressed()){
            outtakePower=67;

            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);
        } else if (gamepad2.yWasPressed()) {
            outtakePower=0;
            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);
        }

        //show what the intake power is on driver hub
        telemetry.addData("outtake power:",outtakePower);
        telemetry.update();

    }
}
