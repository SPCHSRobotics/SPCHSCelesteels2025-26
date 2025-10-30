package org.firstinspires.ftc.teamcode.userSandboxes.lucyCode.auto.topBlue;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeamCode.teamDrive;
import org.firstinspires.ftc.teamcode.TeamCode.teamIntake;
import org.firstinspires.ftc.teamcode.TeamCode.teamOuttake;
import org.firstinspires.ftc.teamcode.TeamCode.temporaryServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.userSandboxes.lucyCode.auto.topBlue.lucyAutoCoordinatesTopBlue.*;



@Autonomous(name="Robot: Auto Drive By Encoder", group="Robot")
public class lucyAutoTopBlue extends LinearOpMode {

    // Init motors
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;

    private final ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        frontLeftDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "leftBackDrive");

        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontLeftDrive.setTargetPosition(0);
        backLeftDrive.setTargetPosition(0);
        backRightDrive.setTargetPosition(0);
        frontRightDrive.setTargetPosition(0);

        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //AutoLegs activeLeg = AutoLegs.start;
        double [] targetCoordinates = lucyAutoCoordinatesTopBlue.startingPosition;
        double [] previousCoordinates = lucyAutoCoordinatesTopBlue.startingPosition;
        double [] relativeCoordinates = {0,0,0};

        for (int activeLeg = 0; activeLeg < lucyAutoCoordinatesTopBlue.NUMBER_OF_LEGS; activeLeg++) {

            switch (activeLeg) {
                case 1:
                    targetCoordinates = lucyAutoCoordinatesTopBlue.legOne;
                    previousCoordinates = lucyAutoCoordinatesTopBlue.startingPosition;

                    break;
                case 2:
                    targetCoordinates = lucyAutoCoordinatesTopBlue.legTwo;
                    previousCoordinates = lucyAutoCoordinatesTopBlue.legOne;

                    break;

            }

            for (int i = 0; i < targetCoordinates.length; i++) {
                relativeCoordinates[i] = targetCoordinates[i] - previousCoordinates[i];
            }

            encoderTranslationalMove(lucyAutoCoordinatesTopBlue.DRIVE_SPEED, relativeCoordinates, 5);


            telemetry.addData("Status", "Run Time" + runtime);
            telemetry.update();
        }

    }


    public void encoderTranslationalMove(double speed,
                             double [] relativeCoordinates,
                             double timeoutS) {

        double xTranslation = relativeCoordinates[0];
        double yTranslation = relativeCoordinates[1];
        double heading      = relativeCoordinates[2];


        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        // Calculate arc length for heading turn
        double rotationArc = (heading / 360) * lucyAutoCoordinatesTopBlue.ROBOT_CIRCUMFERENCE;


        double frontLeftTranslation     = yTranslation + xTranslation + rotationArc;
        double frontRightTranslation    = yTranslation - xTranslation - rotationArc;
        double backLeftTranslation      = yTranslation - xTranslation + rotationArc;
        double backRightTranslation     = yTranslation + xTranslation - rotationArc;

        // Ensure that the OpMode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newFrontLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (frontLeftTranslation * lucyAutoCoordinatesTopBlue.COUNTS_PER_INCH);
            newFrontRightTarget = frontRightDrive.getCurrentPosition() + (int) (frontRightTranslation * lucyAutoCoordinatesTopBlue.COUNTS_PER_INCH);
            newBackLeftTarget = backLeftDrive.getCurrentPosition() + (int) (backLeftTranslation * lucyAutoCoordinatesTopBlue.COUNTS_PER_INCH);
            newBackRightTarget = backLeftDrive.getCurrentPosition() + (int) (backRightTranslation * lucyAutoCoordinatesTopBlue.COUNTS_PER_INCH);
            frontLeftDrive.setTargetPosition(newFrontLeftTarget);
            frontRightDrive.setTargetPosition(newFrontRightTarget);
            backLeftDrive.setTargetPosition(newBackLeftTarget);
            backRightDrive.setTargetPosition(newBackRightTarget);

            // Turn On RUN_TO_POSITION
            frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            frontLeftDrive.setPower(Math.abs(speed));
            frontRightDrive.setPower(Math.abs(speed));
            backLeftDrive.setPower(Math.abs(speed));
            backRightDrive.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (frontLeftDrive.isBusy() && frontRightDrive.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Running to", " %7d :%7d", newFrontLeftTarget, newFrontRightTarget);
                telemetry.addData("Currently at", " at %7d :%7d",
                        frontLeftDrive.getCurrentPosition(), frontRightDrive.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            frontLeftDrive.setPower(0);
            frontRightDrive.setPower(0);
            backLeftDrive.setPower(0);
            backRightDrive.setPower(0);

            // Turn off RUN_TO_POSITION
            frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(250);   // optional pause after each move.
        }
    }
}
