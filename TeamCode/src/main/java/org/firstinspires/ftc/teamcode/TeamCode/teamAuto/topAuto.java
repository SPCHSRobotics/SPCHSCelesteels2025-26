package org.firstinspires.ftc.teamcode.TeamCode.teamAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Top Auto",group="Linear OpMode")
public class topAuto extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    public DcMotor leftBackDrive;
    public DcMotor leftFrontDrive;
    public DcMotor rightBackDrive;
    public DcMotor rightFrontDrive;
    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;
    public DcMotor intakeMotor;



    static final double FORWARD_SPEED = 1;

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        leftFrontDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "backRightDrive");

        outtakeMotorLeft = hardwareMap.get(DcMotor.class, "LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class, "RightOuttake");

        intakeMotor = hardwareMap.get(DcMotor.class,"intakeMotor");


        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Step through each leg of the path, ensuring that the OpMode has not been stopped along the way.

        // Step 1:  Drive forward for 3 seconds
        leftFrontDrive.setPower(FORWARD_SPEED);
        leftBackDrive.setPower(FORWARD_SPEED);
        rightFrontDrive.setPower(FORWARD_SPEED);
        rightBackDrive.setPower(FORWARD_SPEED);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Forward: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        // stop

        intakeMotor.setPower(0);
        outtakeMotorLeft.setPower(0);
        outtakeMotorRight.setPower(0);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);

    }
    }

