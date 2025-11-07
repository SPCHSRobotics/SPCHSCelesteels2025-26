package org.firstinspires.ftc.teamcode.TeamCode.teamAuto;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Top Blue Auto",group="Linear OpMode")
public class topBlue extends LinearOpMode{

    private final ElapsedTime runtime = new ElapsedTime();

    public DcMotor backLeftDrive;
    public DcMotor frontLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor frontRightDrive;
    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;
    public DcMotor lesserIntakeMotor;
    public DcMotor greaterIntakeMotor;


    static final double REVERSE_SPEED = -0.4;
    static final double TURN_SPEED = 0.7;
    static final double TOP_SHOOTER_SPEED = 0.7;
    static final double INTAKE_SPEED = 1;

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");

        outtakeMotorLeft = hardwareMap.get(DcMotor.class, "LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class, "RightOuttake");

        lesserIntakeMotor = hardwareMap.get(DcMotor.class, "lesserIntakeMotor");
        greaterIntakeMotor = hardwareMap.get(DcMotor.class,"greaterIntakeMotor");


        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        outtakeMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        outtakeMotorRight.setDirection(DcMotor.Direction.FORWARD);

        lesserIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
        greaterIntakeMotor.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Step through each leg of the path, ensuring that the OpMode has not been stopped along the way.

        // Step 1:  Drive reverse for 1 second
        frontLeftDrive.setPower(REVERSE_SPEED);
        backLeftDrive.setPower(REVERSE_SPEED);
        frontRightDrive.setPower(REVERSE_SPEED);
        backRightDrive.setPower(REVERSE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.1)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // stop bot and start shooter
        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);

        outtakeMotorLeft.setPower(TOP_SHOOTER_SPEED);
        outtakeMotorRight.setPower(TOP_SHOOTER_SPEED);
        lesserIntakeMotor.setPower(INTAKE_SPEED);
        greaterIntakeMotor.setPower(INTAKE_SPEED);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // intake the ball up the ramp and turn right off the white line
        lesserIntakeMotor.setPower(INTAKE_SPEED);
        greaterIntakeMotor.setPower(INTAKE_SPEED);
        outtakeMotorLeft.setPower(0);
        outtakeMotorRight.setPower(0);
        frontLeftDrive.setPower(TURN_SPEED);
        backLeftDrive.setPower(TURN_SPEED);
        backRightDrive.setPower(-TURN_SPEED);
        frontRightDrive.setPower(-TURN_SPEED);

        runtime.reset();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        // stop
        lesserIntakeMotor.setPower(0);
        greaterIntakeMotor.setPower(0);
        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);

    }
}
