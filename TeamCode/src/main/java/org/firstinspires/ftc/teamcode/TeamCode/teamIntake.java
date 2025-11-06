package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class teamIntake {
    public DcMotor lesserIntakeMotor;
    public DcMotor greaterIntakeMotor;

    public teamIntake(HardwareMap hardwareMap) {
        //call intake motor
        lesserIntakeMotor = hardwareMap.get(DcMotor.class,"lesserIntakeMotor");
        greaterIntakeMotor = hardwareMap.get(DcMotor.class,"greaterIntakeMotor");

        //set intake motor reverse
        lesserIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
        greaterIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void teamIntakeFunction(Gamepad gamepad2, Telemetry telemetry){

        double intakePower = 0;
        //holding down a turns on intake
        if (gamepad2.aWasPressed()){
            intakePower=1;
            lesserIntakeMotor.setPower(intakePower);
            greaterIntakeMotor.setPower(intakePower);

        } else if (gamepad2.aWasReleased()) {
            intakePower=0;
            lesserIntakeMotor.setPower(intakePower);
            greaterIntakeMotor.setPower(intakePower);

        }


        //show what the intake power is on driver hub
        telemetry.addData("intake power:",intakePower);

    }
    }