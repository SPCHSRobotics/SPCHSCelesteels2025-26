package org.firstinspires.ftc.teamcode.userSandboxes.alinaCode.alinaAuto;

//approximated coordinates as of 10/30/2025
public class alinaCoordinates {

    final double [] startingCoordinate = {24,120,315};
    final double [] scoringCoordinate1 = {48,96,315};
    final double [] scoringCoordinate2 = {48,96,135};
    final double [] aprilTagCoordinate = {48,96,60};

    // Calculate the COUNTS_PER_INCH for your specific drive train.
    // Go to your motor vendor website to determine your motor's COUNTS_PER_MOTOR_REV
    // For external drive gearing, set DRIVE_GEAR_REDUCTION as needed.
    // For example, use a value of 2.0 for a 12-tooth spur gear driving a 24-tooth spur gear.
    // This is gearing DOWN for less speed and more torque.
    // For gearing UP, use a gear ratio less than 1.0. Note this will affect the direction of wheel rotation.
    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // No External Gearing.
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;
    static final double     ROBOT_RADIUS            = 9;
    static final double     ROBOT_CIRCUMFERENCE     = ROBOT_RADIUS * 2 * 3.14159;
}
