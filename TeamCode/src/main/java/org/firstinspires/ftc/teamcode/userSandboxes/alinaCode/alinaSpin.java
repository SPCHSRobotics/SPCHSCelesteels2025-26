package org.firstinspires.ftc.teamcode.userSandboxes.alinaCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//alina outtake function
public class alinaSpin {
    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;

    public alinaSpin(HardwareMap hardwareMap) {
        //call intake motor
        outtakeMotorLeft = hardwareMap.get(DcMotor.class,"LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class,"RightOuttake");


        //set intake motor reverse
        outtakeMotorLeft.setDirection(DcMotor.Direction.REVERSE);
        outtakeMotorRight.setDirection(DcMotor.Direction.FORWARD);
    }

    public void alinaSpinFunction(Gamepad gamepad2, Telemetry telemetry){

        double outtakePower;
        //when x is held, full power (6000 rpm), when b is held, half power (3000?), when both released, no power
        if (gamepad2.xWasPressed()){
            outtakePower=1;
            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);

        } else if (gamepad2.bWasPressed()) {
            outtakePower=0.5;
            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);

        } else {
            outtakePower=0;
            outtakeMotorLeft.setPower(outtakePower);
            outtakeMotorRight.setPower(outtakePower);

        }

        //show what the intake power is on driver hub
        telemetry.addData("outtake power:",outtakePower);
        telemetry.update();

    }
}
