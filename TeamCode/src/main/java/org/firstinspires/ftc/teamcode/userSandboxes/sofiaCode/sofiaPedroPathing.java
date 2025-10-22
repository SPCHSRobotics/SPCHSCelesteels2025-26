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

         grabPPG1 = follower.pathBuilder
                 .addPath(new BezierLine(scorePose, intakePPG1))
                 .setLinearHeadingInterpolation(scorePose.getHeading(), intakePPG1())
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
                    .addPath(new BezierLine(scorePose, intakePGP1)
                    .setLinearInterpolation(scorePose.getHeading(), scorePose.
 */
