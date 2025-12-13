package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class teamTurretHead {
    public DcMotor spinningMotor;


    public teamTurretHead (HardwareMap hardwareMap) {
        spinningMotor = hardwareMap.get(DcMotor.class, "turretMotor");
        spinningMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spinningMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void teamTurretFunction(Gamepad gamepad2, Telemetry telemetry){
        double max;

        double spinningMotorPower = gamepad2.left_stick_x;

        max = (Math.abs(spinningMotorPower));
        if (max > 1.0) {
            spinningMotorPower /= max * .5;
        }
        spinningMotor.setPower(spinningMotorPower);
        telemetry.addData("Spinning motor", "%4.2f, %4.2f",spinningMotorPower, spinningMotorPower);

    }


}