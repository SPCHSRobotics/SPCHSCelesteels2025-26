package org.firstinspires.ftc.teamcode.TeamCode.teamAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Bottom Auto",group="Linear OpMode")
public class bottomAuto extends LinearOpMode{

    private final ElapsedTime runtime = new ElapsedTime();

    public DcMotor leftBackDrive;
    public DcMotor leftFrontDrive;
    public DcMotor rightBackDrive;
    public DcMotor rightFrontDrive;
    public DcMotor outtakeMotorLeft;
    public DcMotor outtakeMotorRight;
    public DcMotor lesserIntakeMotor;
    public DcMotor greaterIntakeMotor;


    static final double REVERSE_SPEED = -0.4;

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        leftFrontDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "backRightDrive");

        outtakeMotorLeft = hardwareMap.get(DcMotor.class, "LeftOuttake");
        outtakeMotorRight = hardwareMap.get(DcMotor.class, "RightOuttake");

        lesserIntakeMotor = hardwareMap.get(DcMotor.class, "lesserIntakeMotor");
        greaterIntakeMotor = hardwareMap.get(DcMotor.class,"greaterIntakeMotor");


        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Step through each leg of the path, ensuring that the OpMode has not been stopped along the way.

        // Step 1:  Drive reverse for 1 second
        leftFrontDrive.setPower(REVERSE_SPEED);
        leftBackDrive.setPower(REVERSE_SPEED);
        rightFrontDrive.setPower(REVERSE_SPEED);
        rightBackDrive.setPower(REVERSE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.1)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        // stop
        lesserIntakeMotor.setPower(0);
        greaterIntakeMotor.setPower(0);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);

    }
}
