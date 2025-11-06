package org.firstinspires.ftc.teamcode.userSandboxes.alinaCode.alinaAuto;
import static org.firstinspires.ftc.teamcode.userSandboxes.alinaCode.alinaAuto.alinaCoordinates.COUNTS_PER_INCH;
import static org.firstinspires.ftc.teamcode.userSandboxes.alinaCode.alinaAuto.alinaCoordinates.DRIVE_SPEED;
import static org.firstinspires.ftc.teamcode.userSandboxes.alinaCode.alinaAuto.alinaCoordinates.ROBOT_CIRCUMFERENCE;
import static org.firstinspires.ftc.teamcode.userSandboxes.alinaCode.alinaAuto.alinaCoordinates.TURN_SPEED;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//top blue auto NO PEDRO PATHING
@Autonomous(name = "Alina Top Blue auto", group = "Linear OpMode")
public class alinaAutoTopBlue extends LinearOpMode {

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;

    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;
    

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Initialize the drive system variables.
        frontLeftDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "leftBackDrive");
        //call outtake motor
        outtakeMotorLeft = hardwareMap.get(DcMotor.class, "LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class, "RightOuttake");
        //set drivetrain directions and reset encoder
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        outtakeMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        outtakeMotorRight.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Starting at", "%7d :%7d",
                frontRightDrive.getCurrentPosition(),
                frontLeftDrive.getCurrentPosition(),
                backLeftDrive.getCurrentPosition(),
                backRightDrive.getCurrentPosition());
        telemetry.update();

        waitForStart();
        encoderDrive(DRIVE_SPEED,24,-24,0,3);
        encoderDrive(TURN_SPEED,0,0,-180,2);


        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);

    }
        public void encoderDrive ( double speed, double xTranslation, double yTranslation, double heading, double timeoutS ){

            int newBackLeftTarget;
            int newBackRightTarget;
            int newFrontLeftTarget;
            int newFrontRightTarget;


            //find the rotation arc, or how much you need to turn
            double rotationArc = (heading/360) * ROBOT_CIRCUMFERENCE;


            double frontLeftTranslation     = yTranslation - xTranslation + rotationArc;
            double frontRightTranslation    = yTranslation + xTranslation - rotationArc;
            double backLeftTranslation      = yTranslation + xTranslation + rotationArc;
            double backRightTranslation     = yTranslation - xTranslation - rotationArc;

            // Ensure that the OpMode is still active
            if (opModeIsActive()) {


                // Determine new target position, and pass to motor controller
                newBackLeftTarget = backLeftDrive.getCurrentPosition() + (int) (backLeftTranslation * COUNTS_PER_INCH);
                newBackRightTarget = backRightDrive.getCurrentPosition() + (int) (backRightTranslation * COUNTS_PER_INCH);
                newFrontLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (frontLeftTranslation * COUNTS_PER_INCH);
                newFrontRightTarget = frontRightDrive.getCurrentPosition() + (int) (frontRightTranslation * COUNTS_PER_INCH);

                backLeftDrive.setTargetPosition(newBackLeftTarget);
                backRightDrive.setTargetPosition(newBackRightTarget);
                frontRightDrive.setTargetPosition(newFrontRightTarget);
                frontLeftDrive.setTargetPosition(newFrontLeftTarget);

                // Turn On RUN_TO_POSITION
                backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                // reset the timeout time and start motion.
                runtime.reset();
                backLeftDrive.setPower(Math.abs(speed));
                backRightDrive.setPower(Math.abs(speed));
                frontLeftDrive.setPower(Math.abs(speed));
                frontRightDrive.setPower(Math.abs(speed));

                // keep looping while we are still active, and there is time left, and both motors are running.
                // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
                // its target position, the motion will stop.  This is "safer" in the event that the robot will
                // always end the motion as soon as possible.
                // However, if you require that BOTH motors have finished their moves before the robot continues
                // onto the next step, use (isBusy() || isBusy()) in the loop test.
                while (opModeIsActive() &&
                        (runtime.seconds() < timeoutS) &&
                        (backLeftDrive.isBusy() && backRightDrive.isBusy() && frontRightDrive.isBusy() && frontLeftDrive.isBusy())) {

                    // Display it for the driver.
                    telemetry.addData("Running to", " %7d :%7d", newBackLeftTarget, newBackLeftTarget,newFrontLeftTarget,newFrontRightTarget);
                    telemetry.addData("Currently at", " at %7d :%7d", backLeftDrive.getCurrentPosition(), backRightDrive.getCurrentPosition(), frontLeftDrive.getCurrentPosition(),frontRightDrive.getCurrentPosition());
                    telemetry.update();
                }

                // Stop all motion;
                backLeftDrive.setPower(0);
                backRightDrive.setPower(0);
                frontLeftDrive.setPower(0);
                frontRightDrive.setPower(0);

                // Turn off RUN_TO_POSITION
                backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                sleep(250);   // optional pause after each move.
            }


        }

    }
