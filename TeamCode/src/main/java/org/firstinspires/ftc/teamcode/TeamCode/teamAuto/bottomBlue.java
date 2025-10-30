package org.firstinspires.ftc.teamcode.TeamCode.teamAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "scrimmage bottom blue auto", group = "Linear OpMode")
public class bottomBlue extends LinearOpMode {
    /* Declare OpMode members. */
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;
    public Servo servoArm;


    private ElapsedTime runtime = new ElapsedTime();


    static final double FORWARD_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;
    static final double SHOOTING_FULL_POWER = 1;
    static final double SCOOP_POSITION=1;
    static final double DEFAULT_POSITION=0.5;
    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        frontLeftDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "leftBackDrive");
        outtakeMotorLeft = hardwareMap.get(DcMotor.class, "LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class, "RightOuttake");

        //set motors
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


        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Step through each leg of the path, ensuring that the OpMode has not been stopped along the way.

        //Step 1: Aiming
        frontLeftDrive.setPower(-TURN_SPEED);
        frontRightDrive.setPower(TURN_SPEED);
        backLeftDrive.setPower(-FORWARD_SPEED);
        backRightDrive.setPower(TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.2)) {
            telemetry.addData("Path", "aiming", runtime.seconds());
            telemetry.update();
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


                    //turn outtake on
                    outtakeMotorLeft.setPower(SHOOTING_FULL_POWER);
                            outtakeMotorRight.setPower(SHOOTING_FULL_POWER);
                            runtime.reset();
                            while (opModeIsActive() && (runtime.seconds() < 3.0)) {
                                telemetry.addData("Outtake Status:", "On", runtime.seconds());
                                telemetry.update();
                            }
                                //turn outtake off
                                outtakeMotorRight.setPower(0);
                                outtakeMotorLeft.setPower(0);
                                    telemetry.addData("Outtake Status:", "Off", runtime.seconds());
                                    telemetry.update();
                                sleep(8000);

                                // Step 2:  Drive forward
                                frontLeftDrive.setPower(FORWARD_SPEED);
                                backLeftDrive.setPower(FORWARD_SPEED);
                                frontLeftDrive.setPower(FORWARD_SPEED);
                                backRightDrive.setPower(FORWARD_SPEED);
                                runtime.reset();
                                while (opModeIsActive() && (runtime.seconds() < 2.0)) {
                                    telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
                                    telemetry.update();
                            }
                                // Step 3:  Stop
                                backLeftDrive.setPower(0);
                                frontLeftDrive.setPower(0);
                                frontRightDrive.setPower(0);
                                backRightDrive.setPower(0);

                                        telemetry.addData("Path", "Complete", runtime.seconds());
                                        telemetry.update();
                                sleep(1000);
                        }
                    }
                }

}
