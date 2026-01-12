package org.firstinspires.ftc.teamcode.TeamCode.teamAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//auto for right next to blue goal
@Autonomous(name="Blue Auto",group="Linear OpMode")
public class blueAuto extends LinearOpMode {

//declare motors
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor shooterMotor;
    public DcMotor intakeMotor;


    private ElapsedTime runtime = new ElapsedTime();


    static final double REVERSE_SPEED = -0.4;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");


        shooterMotor = hardwareMap.get(DcMotor.class, "shooterMotor");

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Send telemetry to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();


        // Step 1:  Drive reverse for 1 second
        frontLeftDrive.setPower(REVERSE_SPEED);
        backLeftDrive.setPower(REVERSE_SPEED);
        frontRightDrive.setPower(REVERSE_SPEED);
        backRightDrive.setPower(REVERSE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // stop bot and rev up the shooter
        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);

        shooterMotor.setPower(1);


        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 8)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // roll the balls up to shooter
        intakeMotor.setPower(1);

        runtime.reset();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
            telemetry.addData("Path", "Leg 3: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        //pause for reload
        intakeMotor.setPower(0);

        runtime.reset();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
            telemetry.addData("Path", "Leg 4: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // roll the balls up to shooter
        intakeMotor.setPower(1);

        runtime.reset();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
            telemetry.addData("Path", "Leg 5: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        //pause for reload
        intakeMotor.setPower(0);

        runtime.reset();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
            telemetry.addData("Path", "Leg 6: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // roll the balls up to shooter
        intakeMotor.setPower(1);

        runtime.reset();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
            telemetry.addData("Path", "Leg 7: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // strafe left for 2 seconds
        intakeMotor.setPower(0);
        shooterMotor.setPower(0);
        frontLeftDrive.setPower(-.4);
        backLeftDrive.setPower(.4);
        frontRightDrive.setPower(.4);
        backRightDrive.setPower(-.4);

        runtime.reset();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 8: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // stop
        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);

    }
    }

