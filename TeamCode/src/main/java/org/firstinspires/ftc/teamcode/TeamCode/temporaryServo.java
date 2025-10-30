package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class temporaryServo {
    public Servo servoArm;

    public temporaryServo(HardwareMap hardwareMap){
        servoArm = hardwareMap.get(Servo.class,"servoArm");
    }

    public void temporaryServoFunction (Gamepad gamepad2, Telemetry telemetry){
        double servoPose=0;

        // TODO: move set position to outside if statements
        if (gamepad2.yWasPressed()){
            servoPose = 1;
            servoArm.setPosition(servoPose);

        }else if (gamepad2.yWasReleased()){
            servoPose = 0.5;
            servoArm.setPosition(servoPose);

        }

        telemetry.addData("servo pose:", servoPose);
    }
}
