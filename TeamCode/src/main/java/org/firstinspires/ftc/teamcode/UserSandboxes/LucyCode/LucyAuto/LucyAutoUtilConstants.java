package org.firstinspires.ftc.teamcode.UserSandboxes.LucyCode.LucyAuto;

public class LucyAutoUtilConstants {
    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // No External Gearing.
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     ROBOT_RADIUS            = 9.0;      // Radius of bot in inches
    static final double     ROBOT_CIRCUMFERENCE     = ROBOT_RADIUS * 2 * 3.1415;
}
