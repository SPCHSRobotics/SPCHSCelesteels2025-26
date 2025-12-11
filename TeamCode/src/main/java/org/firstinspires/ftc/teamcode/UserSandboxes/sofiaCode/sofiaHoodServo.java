package org.firstinspires.ftc.teamcode.userSandboxes.sofiaCode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class sofiaHoodServo {
    public Servo hoodServo;

    public void sofiaHoodServo (HardwareMap hardwareMap) {
        hoodServo = hardwareMap.get(Servo.class, "hood servo");
        hoodServo.setDirection(Servo.Direction.REVERSE);
    }
    public void hoodServoFunction(Gamepad gamepad2, Telemetry telemetry){
        double backfield = 1;
        double frontfield = 0;
        if (gamepad2.dpad_down){
            hoodServo.setPosition(backfield);

        } else if (gamepad2.dpad_up) {
            hoodServo.setPosition(frontfield);

        }
    }
}
