package org.firstinspires.ftc.teamcode.userSandboxes.lucyCode.LucyAuto.TopBlue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.LucyHardwareMap;
/*
@Disabled
@Autonomous(name="Robot: Auto Drive By Encoder", group="Robot")
public class LucyAutoTopBlue extends LinearOpMode {

    // Init motors
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;

    private final ElapsedTime runtime = new ElapsedTime();

    LucyHardwareMap hardwareUtil = new LucyHardwareMap();


    @Override
    public void runOpMode() throws InterruptedException {

        hardwareUtil.initAuto();

        // Initialize coordinate arrays
        double [] targetCoordinates = LucyAutoCoordinatesTopBlue.startingPosition;
        double [] previousCoordinates = LucyAutoCoordinatesTopBlue.startingPosition;

        // Repeat once for each leg to move through
        for (int activeLeg = 0; activeLeg < LucyAutoCoordinatesTopBlue.NUMBER_OF_LEGS; activeLeg++) {

            // For each leg set target coordinates
            switch (activeLeg) {
                case 1:
                    targetCoordinates = LucyAutoCoordinatesTopBlue.legOne;
                    previousCoordinates = LucyAutoCoordinatesTopBlue.startingPosition;

                    break;
                case 2:
                    targetCoordinates = LucyAutoCoordinatesTopBlue.legTwo;
                    previousCoordinates = LucyAutoCoordinatesTopBlue.legOne;

                    break;

            }

            // Tell the motors to move to desired location
            LucyAutoUtil.encoderTranslationalMove(LucyAutoCoordinatesTopBlue.DRIVE_SPEED,
                    previousCoordinates, targetCoordinates,
                    frontLeftDrive, frontRightDrive, backLeftDrive, backRightDrive);

            while (opModeIsActive() && (frontLeftDrive.isBusy() || frontRightDrive.isBusy() ||
                                        backLeftDrive.isBusy()  || backRightDrive.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Running to", " %5d :%5d :%5d :%5d",
                        frontLeftDrive.getTargetPosition(), frontRightDrive.getTargetPosition(),
                        backLeftDrive.getTargetPosition(), backRightDrive.getTargetPosition());
                telemetry.addData("Currently at", " at %5d :%5d :%5d :%5d",
                        frontLeftDrive.getCurrentPosition(), frontRightDrive.getCurrentPosition(),
                        backLeftDrive.getCurrentPosition(), backRightDrive.getCurrentPosition());
                telemetry.update();
            }


            telemetry.addData("Status", "Run Time" + runtime);
            telemetry.update();
        }

    }
}

 */
