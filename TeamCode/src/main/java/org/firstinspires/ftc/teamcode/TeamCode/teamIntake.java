package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamIntake {
    public DcMotor intakeMotor;

    //initialization function, hardware map for intake motor
    public teamIntake(HardwareMap hardwareMap) {

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void teamIntakeFunction(Gamepad gamepad2, Telemetry telemetry) {
        double intakePower = 0;

        if (gamepad2.aWasPressed()) {
            intakePower = 1;
            intakeMotor.setPower(intakePower);
            //show what the intake power is on the driver hub
            telemetry.addData("intake power:", intakePower);
            telemetry.update();

        } else if (gamepad2.bWasPressed()) {
            intakePower = 0;
            intakeMotor.setPower(intakePower);
            //show what the intake power is on the driver hub
            telemetry.addData("intake power:", intakePower);
            telemetry.update();
        }
        //show what the intake power is on the driver hub
        /*telemetry.addData("intake power:", "%4.2f", intakePower);
        telemetry.update();*/

    }

}