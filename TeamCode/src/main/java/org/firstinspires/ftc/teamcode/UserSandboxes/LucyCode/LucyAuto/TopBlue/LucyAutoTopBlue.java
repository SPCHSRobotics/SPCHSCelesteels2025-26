package org.firstinspires.ftc.teamcode.UserSandboxes.LucyCode.LucyAuto.TopBlue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.UserSandboxes.LucyCode.LucyAuto.LucyAutoUtil;


@Autonomous(name="Robot: Auto Drive By Encoder", group="Robot")
public class LucyAutoTopBlue extends LinearOpMode {

    // Init motors
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;

    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        // Get motor hardware mapping
        frontLeftDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "leftBackDrive");

        // Set all motors to be relative forward
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set initial position
        frontLeftDrive.setTargetPosition(0);
        backLeftDrive.setTargetPosition(0);
        backRightDrive.setTargetPosition(0);
        frontRightDrive.setTargetPosition(0);

        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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
