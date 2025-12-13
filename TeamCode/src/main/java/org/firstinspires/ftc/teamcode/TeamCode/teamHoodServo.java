package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamHoodServo {

    public Servo hoodServo;

    public teamHoodServo (HardwareMap hardwareMap) {

        hoodServo = hardwareMap.get(Servo.class, "hoodServo");
        hoodServo.setDirection(Servo.Direction.REVERSE);

    }

    public void hoodServoFunction(Gamepad gamepad2, Telemetry telemetry){

        double backfield = 1;
        double frontfield = 0;
        double servoPosition = 0;
        
        if (gamepad2.x){
            hoodServo.setPosition(backfield);
            servoPosition = backfield;

        } else if (gamepad2.y) {
            hoodServo.setPosition(frontfield);
            servoPosition = frontfield;

        }
        
        telemetry.addData("servo position:",servoPosition);

    }
}
