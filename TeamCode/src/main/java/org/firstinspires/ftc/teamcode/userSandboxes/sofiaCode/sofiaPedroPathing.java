package org.firstinspires.ftc.teamcode.userSandboxes.sofiaCode;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.Timer;

import javax.xml.xpath.XPath;

@Autonomous(name = "sofiaPPBottomBlue", group = "Linear OpMode")
@Configurable
public class sofiaPedroPathing extends LinearOpMode {
private Follower follower;
private Timer patherTimer, actionTimer, opmodeTimer;
private int pathState;

private final Pose startPose = new Pose();
private final Pose scorePose = new Pose();
private final Pose apriltagePose = new Pose();
private final Pose intakePPGPose1 = new Pose();

/* @Autonomous(name = "sofiaPPBottomBlue", group = "Linear OpMode"
 private Follower follower;
 private Timer patherTimer, actionTimer, opmodeTimer;

 private in pathState;
         all the poses needed for Bottom Blue
 private final Pose startPose(where the bot is placed) = new Pose(Coordinates, Math.toRadians(Put in degrees))
 private final Pose scorePose (where the bot needs to be to score) = new Pose (bottom left)
 private final Pose apriltagPose (where the bot needs to be to read the april tag) = new Pose (in front of obelisk)
 private final Pose intakePPGPose1 (1st pick up for PPG, bottom row) = new Pose ()
 private final Pose intakePPGPose2 (2nd pick up for PPG, middle row) = new Pose ()
 private final Pose intakePPGPose3 (3rd pick up for PPG, top row) = new Pose ()
 private final Pose intakePGPPose1 (1st pick up for PGP, bottom row) = new Pose ()
 private final Pose intakePGPPose2 (2nd pick up for PGP, middle row) = new Pose ()
 private final Pose intakePGPPose3 (3rd pick up for PGP, top row) = new Pose ()
 private final Pose intakeGPPPose1 (1st pick up for GPP, bottom row) = new Pose ()
 private final Pose intakeGPPPose2 (2nd pick up for GPP, middle row) = new Pose ()
 private final Pose intakeGPPPose3 (3rd pick up fro GPP, top row) = new Pose ()

 public void buildPaths() // all the interpolation types are bound to change, need to {
         scorePreLoad = new Path (new BezierLinear (how the path will look) (startPose, scorePose));
         scorePreLoad.setLinearHeadingInterpolation(how the bot will change directions/Bezier Path Types)(startPose.getHeading(direction of startPose), scorePose.getHeading());

         apriltagPath = follower.pathBuilder
                  .addPath(new BezierLine(scorePose, apriltagPose))
                  .setLinearHeadingInterpolation(scorePose.getHeading(), apriltagPose.getHeading())
                  .build();

         grabPPG1 = follower.pathBuilder
                 .addPath(new BezierLine(apriltagPose, intakePPG1))
                 .setLinearHeadingInterpolation(apriltagPose.getHeading(), intakePPG1())
                 .build();
         scorePPG1 = follower.pathBuilder
                 .addPath(new BezierLine(intakePPG1, scorePose))
                 .setLinearHeadingInterpolation(intakePPG1.getHeading(), scorePose,getHeading())
                 .build();
         grabPPG2 = follower.pathBuilder
                 .addPath(new BezierLine(scorePose, intakePPG2))
                 .setLinearHeadingInterpolation(scorePose.getHeading(), intakePPG2.getHeading())
                 .build();
         scorePPG2 = follower.pathBuilder
                 .addPath(new BezierLine(intakePPG2, scorePose))
                 .setLinearHeadingInterpolation(intakePPG2.getHeading(), scorePose.getHeading())
                 .build();
         grabPPG3 = follower.pathBuilder
                 .addPath(new BezierLine(scorePose, intakePPG3))
                 .setLinearHeadingInterpolation(scorePose.getHeading(), intakePPG3.getHeading())
                 .build();
         scorePPG3 = follower.pathBuilder
                    .addPath(new BezierLine(intakePPG3, scorePose))
                    .setLinearInterpolation(intakePPG3.getHeading(), scorePose.getHeading())
                    .build();

        grabPGP1 = follower.pathBuilder
                    .addPath(new BezierLine(scorePose, intakePGP1))
                    .setLinearHeadingInterpolation(scorePose.getHeading(), intakePGP1.getHeading())
                    .build();
        scorePGP1 = follower.pathBuilder
                    .addPath(new BezierLine(intakePGP1, scorePose))
                    .setLinearHeadingInterpolation(intakePGP1.getHeading(), scorePose.getHeading())
                    .build();
        grabPGP2 = follower.pathBuilder
                    .addPath(new BezierLine(scorePose, intakePGP2))
                    .setLinearHeadingInterpolation(scorePose.getHeading(), intakePGP2.getHeading())
                    .build();
        scorePGP2 = follower.pathBuilder
                    .addPath(new BezierLine(intakePGP2, scorePose))
                    .setLinearHeadingInterpolation(intakePGP2.getHeading(), scorePose.getHeading())
                    .build();
        grabPGP3 = follower.pathBuilder
                    .addPath(new BezierLine(scorePose, intakePGP3))
                    .setLinearHeadingInterpolation(scorePose.getHeading(), intakePGP3.getHeading())
                    .build();
        scorePGP3 = follower.pathBuilder
                    .addPath(new BezierLine(intakePGP3, scorePose))
                    .setLinearHeadingInterpolation(intakePGP3.getHeading(), scorePose.getHeading())
                    .build();

        grabGPP1 = follower.pathBuilder
                    .addPath(new BezierLine(scorePose, intakeGPP1))
                    .setLinearHeadingInterpolation(scorePose.getHeading(), intakeGGP1.getHeading())
                    .build();
        scoreGPP1 = follower.pathBuilder
                    .addPath(new BezierLine(intakeGPP1, scorePose))
                    .setLinearHeadingInterpolation(intakeGPP1.getHeading(), scorePose.getHeading())
                    .build();
        grabGPP2 = follower.pathBuilder
                    .addPath(new BezierLine(scorePose, intakeGPP2))
                    .setLinearHeadingInterpolation(scorePose.getHeading(), intakeGPP2.getHeading())
                    .build();
        scoreGPP2 = follower.pathBuilder
                    .addPath(new BezierLine(intakeGPP2, scorePose))
                    .setLinearHeadingInterpolation(intakeGPP2.getHeading(), scorePose.getHeading())
                    .build();
        grabGPP3 = follower.pathBuilder
                    .addPath(new BezierLine(scorePose, intakeGPP3))
                    .setLinearHeadingInterpolation(scorePose.getHeading(), intakeGPP3.getHeading())
                    .build();
        scoreGPP3 = follower.pathBuilder
                    .addPath(new BezierLine(intakeGPP3, scorePose))
                    .setLinearHeadingInterpolation(intakeGPP3.getHeading(), scorePose.getHeading())
                    .build();


public void autonomousPathUpdate() {
    switch (pathState) {
        case 0: start to score path
            follower.followPath(scorePreLoad/basically does the scorePreLoad path written above)
            setPathState(1/goes to case 1)
            } break;
        case 1: april tag path
            if (!follower.isBusy()) this checks to see if the bot is actively on a path {
            follower.followPath(apriltagPath,true);
                if(detectedTag == PPG) {
                        setPathState(2);
                    } else if(detectedTag == PGP) {
                        setPathState(number smth);
                    } else if(detectedTag == GPP {
                        setPathState(number smth idk);
                        }
            } break;
        case 2: hopefully this one goes to bottom row in the PPG pattern
            if (!follower.isBusy()) {
            follower.followPath(grabPPG1, true);
            } else {
                intakeOn();
           }
           if (!follower.isBusy() && follower.HasFinishedPath()) {
            intakeOff();
            setPathState(3)
            } break;
        case 3: shoot bottom row
            if (!follower.isBusy()) {
            follower.followPath(scorePPG1, true);
            }
            if (!follower.isBusy() && follower.HasFinishedPath()) {
                outtakeOff


 */
