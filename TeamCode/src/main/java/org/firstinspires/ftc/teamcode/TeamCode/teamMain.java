package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Celesteels OpMode", group="Linear OpMode")
public class teamMain extends LinearOpMode {

    //reset timer on driver hub
    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        //initialize hardware
        teamDrive teamDrive = new teamDrive(hardwareMap);
        teamIntake teamIntake = new teamIntake(hardwareMap);
        teamOuttake teamOuttake = new teamOuttake(hardwareMap);
        teamTurretHead teamTurretHead = new teamTurretHead(hardwareMap);


        //Wait for the team to start (driver presses START)
        telemetry.addData("Status","Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until driver presses STOP
        while (opModeIsActive()) {
            //call all the functions
            teamDrive.teamDriveFunction(gamepad1,telemetry);
            teamIntake.teamIntakeFunction(gamepad2,telemetry);
            teamOuttake.teamOuttakeFunction(gamepad2,telemetry);
            teamTurretHead.teamTurretFunction(gamepad2,telemetry);

           //Show the elapsed game time, wheel power, intake power...(more stuff later:3)
            telemetry.addData("Status","Run Time" + runtime);
            telemetry.update();
        }


    }
}
