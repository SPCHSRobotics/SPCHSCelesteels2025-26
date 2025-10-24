package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
        outtakeMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        outtakeMotorRight.setDirection(DcMotor.Direction.FORWARD    );

        outtakeMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtakeMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void teamOuttakeFunction(Gamepad gamepad2, Telemetry telemetry){

        double outtakePower = 0;
        //when x is held, full power (6000 rpm), when b is held, half power (3000?), when both released, no power
        if (gamepad2.xWasPressed()){
            outtakePower=1;
            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);

        } else if (gamepad2.bWasPressed()) {
            outtakePower=0.5;
            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);


        } else if (gamepad2.bWasReleased()|| gamepad2.xWasReleased()){
            outtakePower=0;
            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);

        }
        telemetry.addData("outtake power:",outtakePower);

    }
}
