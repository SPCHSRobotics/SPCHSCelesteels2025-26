package org.firstinspires.ftc.teamcode.TeamCode.teamAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;



@Autonomous(name="Scrimmage Bottom Red", group="Robot")
public class bottomRed extends LinearOpMode {

    /* Declare OpMode members. */
   public DcMotor frontLeftDrive = null;
   public DcMotor frontRightDrive = null;
   public DcMotor backLeftDrive = null;
   public DcMotor backRightDrive = null;
    public DcMotor outtakeMotorLeft = null;
    public DcMotor outtakeMotorRight = null;

    private final ElapsedTime runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 1;
    static final double     SHOOTING_FULL_POWER = 1;


    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        frontLeftDrive = hardwareMap.get(DcMotor.class, "front_left_drive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "front_right_drive");
        backRightDrive = hardwareMap.get(DcMotor.class, "back_left_drive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "back_right_drive");
        //call outtake motor
        outtakeMotorLeft = hardwareMap.get(DcMotor.class, "LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class, "RightOuttake");
        //set outtake motor reverse
        outtakeMotorLeft.setDirection(DcMotor.Direction.REVERSE);
        outtakeMotorRight.setDirection(DcMotor.Direction.FORWARD);

        outtakeMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtakeMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Step through each leg of the path, ensuring that the OpMode has not been stopped along the way.

        // Step 1:  Drive forward for 3 seconds
        frontLeftDrive.setPower(FORWARD_SPEED);
        frontRightDrive.setPower(FORWARD_SPEED);
        backLeftDrive.setPower(FORWARD_SPEED);
        backRightDrive.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
            //Step 2: Turn
            frontLeftDrive.setPower(FORWARD_SPEED);
            frontRightDrive.setPower(-FORWARD_SPEED);
            backLeftDrive.setPower(FORWARD_SPEED);
            backRightDrive.setPower(-FORWARD_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                telemetry.addData("Path", "aiming", runtime.seconds());
                telemetry.update();
            }

         // Step 3:  Stop
            frontLeftDrive.setPower(0);
            frontRightDrive.setPower(0);
            backLeftDrive.setPower(0);
            backRightDrive.setPower(0);

            telemetry.addData("Path", "Complete");
            telemetry.update();
            sleep(1000);
            //turn outtake on
            outtakeMotorLeft.setPower(SHOOTING_FULL_POWER);
            outtakeMotorRight.setPower(SHOOTING_FULL_POWER);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 3.0)) {
                telemetry.addData("Outtake Status:", "On", runtime.seconds());
                telemetry.update();
                //turn outtake off
                outtakeMotorRight.setPower(0);
                outtakeMotorLeft.setPower(0);
                telemetry.addData("Outtake Status:", "Complete");
                telemetry.update();
                sleep(8000);

            }

        }
    }}




