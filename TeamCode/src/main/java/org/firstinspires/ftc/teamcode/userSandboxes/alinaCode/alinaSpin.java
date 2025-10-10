package org.firstinspires.ftc.teamcode.userSandboxes.alinaCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//alina outtake function
public class alinaSpin {
    public DcMotor outtakeMotor;

    public alinaSpin(HardwareMap hardwareMap) {
        //call intake motor
        outtakeMotor = hardwareMap.get(DcMotor.class,"outtakeMotor");
        //set intake motor reverse
        outtakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void alinaSpinFunction(Gamepad gamepad2, Telemetry telemetry){

        double outtakePower = 0;

        if (gamepad2.xWasPressed()){
            outtakePower=200;

            outtakeMotor.setPower(outtakePower);
        } else if (gamepad2.yWasPressed()) {
            outtakePower=0;
            outtakeMotor.setPower(outtakePower);
        }

        //show what the intake power is on driver hub
        telemetry.addData("outtake power:", "%4.2f",outtakePower);
        telemetry.update();

    }
}
