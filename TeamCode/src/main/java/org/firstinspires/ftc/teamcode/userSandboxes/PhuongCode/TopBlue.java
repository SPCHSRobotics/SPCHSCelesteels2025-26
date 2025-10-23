package org.firstinspires.ftc.teamcode.userSandboxes.PhuongCode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import  com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "TopBlue", group = "Linear OpMode")
@Configurable
public class TopBlue extends LinearOpMode {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;


    @Override
    public void runOpMode() throws InterruptedException {


        waitForStart();
        //
        while(opModeIsActive()){
            if (pathState == 1) {

                
            }
            if (pathState == 2){

            }
            if (pathState == 3){

            }
        }
    }
}