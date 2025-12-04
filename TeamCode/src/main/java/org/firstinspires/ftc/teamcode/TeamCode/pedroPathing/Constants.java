package org.firstinspires.ftc.teamcode.TeamCode.pedroPathing;

import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Constants {

    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(6.8)
            .forwardZeroPowerAcceleration(1)
            .lateralZeroPowerAcceleration(1)
            .translationalPIDFCoefficients(new PIDFCoefficients(.1, .1, .1,.1))
            .translationalPIDFSwitch(1)
            .secondaryTranslationalPIDFCoefficients(new PIDFCoefficients(.1, .1, .1,.1))
            .headingPIDFCoefficients(new PIDFCoefficients(.1, .1, .1,.1))
            .secondaryHeadingPIDFCoefficients(new PIDFCoefficients(.1, .1, .1,.1))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(.1, .1, .1,.1,.1))
            .secondaryDrivePIDFCoefficients(new FilteredPIDFCoefficients(.1, .1, .1,.1,.1))
            .drivePIDFSwitch(.1)
            .centripetalScaling(2);
    public static MecanumConstants driveConstants = new MecanumConstants()
            .leftFrontMotorName("leftFrontDrive")
            .leftRearMotorName("leftBackDrive")
            .rightFrontMotorName("rightFrontDrive")
            .rightRearMotorName("rightBackDrive")
            .leftFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .xVelocity(.1)
            .yVelocity(.1);
    public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(.1)
            .strafePodX(.1)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED);

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(driveConstants)
                .pinpointLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
}