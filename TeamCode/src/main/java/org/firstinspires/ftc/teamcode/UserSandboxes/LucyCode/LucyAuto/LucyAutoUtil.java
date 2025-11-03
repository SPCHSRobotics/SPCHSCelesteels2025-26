package org.firstinspires.ftc.teamcode.UserSandboxes.LucyCode.LucyAuto;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LucyAutoUtil {

    public static void encoderTranslationalMove(double speed,
                                         double[] initialCoordinates, double[] targetCoordinates,
                                         DcMotor frontLeftDrive, DcMotor frontRightDrive,
                                         DcMotor backLeftDrive, DcMotor backRightDrive) {


        // Translate coordinates
        double[] relativeMovements = CoordinateUtil.calculateRelativeCircularMovement(
                initialCoordinates, targetCoordinates, LucyAutoUtilConstants.ROBOT_CIRCUMFERENCE);

        // Breakdown array into it's components
        double xTranslation = relativeMovements[0];
        double yTranslation = relativeMovements[1];
        double rotationArc  = relativeMovements[2];


        // Create variables to be used for this function
        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        // Handle combining movement in 3 degrees of movement for lateral, strafe and rotation
        // TODO: this make require additional math to account for imperfect strafing
        double frontLeftTranslation     = yTranslation + xTranslation + rotationArc;
        double frontRightTranslation    = yTranslation - xTranslation - rotationArc;
        double backLeftTranslation      = yTranslation - xTranslation + rotationArc;
        double backRightTranslation     = yTranslation + xTranslation - rotationArc;

        // Determine new target position
        newFrontLeftTarget  = frontLeftDrive.getCurrentPosition()  + (int) (frontLeftTranslation  * LucyAutoUtilConstants.COUNTS_PER_INCH);
        newFrontRightTarget = frontRightDrive.getCurrentPosition() + (int) (frontRightTranslation * LucyAutoUtilConstants.COUNTS_PER_INCH);
        newBackLeftTarget   = backLeftDrive.getCurrentPosition()   + (int) (backLeftTranslation   * LucyAutoUtilConstants.COUNTS_PER_INCH);
        newBackRightTarget  = backLeftDrive.getCurrentPosition()   + (int) (backRightTranslation  * LucyAutoUtilConstants.COUNTS_PER_INCH);

        // Pass target positions to motors
        frontLeftDrive.setTargetPosition(newFrontLeftTarget);
        frontRightDrive.setTargetPosition(newFrontRightTarget);
        backLeftDrive.setTargetPosition(newBackLeftTarget);
        backRightDrive.setTargetPosition(newBackRightTarget);

        // Set Motor speed
        frontLeftDrive.setPower(Math.abs(speed));
        frontRightDrive.setPower(Math.abs(speed));
        backLeftDrive.setPower(Math.abs(speed));
        backRightDrive.setPower(Math.abs(speed));


    }
}
