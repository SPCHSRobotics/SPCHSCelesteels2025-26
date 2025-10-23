package org.firstinspires.ftc.teamcode.userSandboxes.alinaCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class alinaIntake {
    public DcMotor intakeMotor;

    public alinaIntake(HardwareMap hardwareMap) {
        //call intake motor
        intakeMotor = hardwareMap.get(DcMotor.class,"intakeMotor");
        //set intake motor reverse
        intakeMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void alinaIntakeFunction(Gamepad gamepad2, Telemetry telemetry){

        double intakePower = 0;
        //holding down a turns on intake
        if (gamepad2.aWasPressed()){
            intakePower=1;
            intakeMotor.setPower(intakePower);

        } else if (gamepad2.aWasReleased()) {
            intakePower=0;
            intakeMotor.setPower(intakePower);

        }

        //show what the intake power is on driver hub
        telemetry.addData("intake power:",intakePower);
        telemetry.update();

    }
}
