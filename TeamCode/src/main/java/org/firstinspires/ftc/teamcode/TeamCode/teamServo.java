package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamServo {

    public Servo servoArm;

    public teamServo(HardwareMap hardwareMap) {
        servoArm = hardwareMap.get(Servo.class,"servoArm");

        servoArm.setDirection(Servo.Direction.REVERSE);
    }
    public void teamServoFunction (Gamepad gamepad2, Telemetry telemetry){

        double servoPosition = 0;
        //flick ts
        if (gamepad2.bWasPressed()){
            servoPosition = 0.5;
            servoArm.setPosition(servoPosition);
            //go back to neutral
        } else if (gamepad2.bWasReleased()){
            servoPosition = 0;
            servoArm.setPosition(servoPosition);
        }
        telemetry.addData("servo pose:", servoPosition);
    }
}
