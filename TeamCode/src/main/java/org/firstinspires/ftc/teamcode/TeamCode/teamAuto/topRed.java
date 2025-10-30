package org.firstinspires.ftc.teamcode.TeamCode.teamAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Scrimmage Top Red Auto",group="Linear OpMode")
public class topRed extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;

    public Servo servoArm;
    static final double FORWARD_SPEED = 1;
    static final double TURN_SPEED = 0.3;
    static final double SHOOTING_SPEED = .75;
    static final double SCOOP_POSITION = 1;
    static final double DEFAULT_POSITION = 0.5;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
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
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        outtakeMotorLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakeMotorRight.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakeMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtakeMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        runtime.reset();

        // Step 1:  Drive forward for 3 seconds
        frontRightDrive.setPower(FORWARD_SPEED);
        backRightDrive.setPower(FORWARD_SPEED);
        frontLeftDrive.setPower(FORWARD_SPEED);
        backLeftDrive.setPower(FORWARD_SPEED);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Spin left for 2 seconds
        frontLeftDrive.setPower(-TURN_SPEED);
        backLeftDrive.setPower(-TURN_SPEED);
        frontRightDrive.setPower(TURN_SPEED);
        backRightDrive.setPower(TURN_SPEED);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 2)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
            outtakeMotorLeft.setPower(SHOOTING_SPEED);
            outtakeMotorRight.setPower(SHOOTING_SPEED);
            runtime.reset();

            while (opModeIsActive() && (runtime.seconds() < 3.0)) {
                telemetry.addData("Outtake Status:", "On", runtime.seconds());
                telemetry.update();
            }
            //turn outtake off
            outtakeMotorRight.setPower(0);
            outtakeMotorLeft.setPower(0);
            telemetry.addData("Outtake Status:", "Complete");
            telemetry.update();
            sleep(8000);

            //set sevro position
            servoArm.setPosition(SCOOP_POSITION);
            while (opModeIsActive() && (runtime.seconds() < 2.0)) {
                telemetry.addData("servo:", "position: 1", runtime.seconds());
                telemetry.update();
            }

            //go back to original position
            servoArm.setPosition(DEFAULT_POSITION);
            while (opModeIsActive() && (runtime.seconds() < 2.0)) {
                telemetry.addData("servo:", "position: 2", runtime.seconds());
                telemetry.update();
            }
            while (opModeIsActive() && (runtime.seconds() < 2)) {
                telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
                telemetry.update();
                outtakeMotorLeft.setPower(SHOOTING_SPEED);
                outtakeMotorRight.setPower(SHOOTING_SPEED);
                runtime.reset();

                while (opModeIsActive() && (runtime.seconds() < 3.0)) {
                    telemetry.addData("Outtake Status:", "On", runtime.seconds());
                    telemetry.update();
                }
                //turn outtake off
                outtakeMotorRight.setPower(0);
                outtakeMotorLeft.setPower(0);
                telemetry.addData("Outtake Status:", "Complete");
                telemetry.update();
                sleep(8000);

                //Step 3: Go forward for 3 seconds
                frontRightDrive.setPower(FORWARD_SPEED);
                backRightDrive.setPower(FORWARD_SPEED);
                frontLeftDrive.setPower(FORWARD_SPEED);
                backLeftDrive.setPower(FORWARD_SPEED);
                runtime.reset();

                while (opModeIsActive() && (runtime.seconds() < 3.0)) {
                    telemetry.addData("Path", "Leg 3: %4.1f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // Step 4:  Stop
                frontLeftDrive.setPower(0);
                frontRightDrive.setPower(0);

                telemetry.addData("Path", "Complete");
                telemetry.update();
                sleep(1000);
            }
        }
    }

