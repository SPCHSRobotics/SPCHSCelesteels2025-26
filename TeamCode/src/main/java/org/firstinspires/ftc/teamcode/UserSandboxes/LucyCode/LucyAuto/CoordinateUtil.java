package org.firstinspires.ftc.teamcode.UserSandboxes.LucyCode.LucyAuto;

public class CoordinateUtil {
    public static double[] rotateCoordinates(double x0, double y0, double degreesToRotate) {

        /// Note: This performs a counter clockwise rotation

        // Array to store translated coordinates (x',y')
        double[] translatedCoordinates = new double[2];

        // Convert degrees to radians
        double theta = Math.toRadians(degreesToRotate);

        // calculate x'
        translatedCoordinates[0] = (x0 * Math.cos(theta)) - (y0 * Math.sin(theta));
        // calculate y'
        translatedCoordinates[1] = (x0 * Math.sin(theta)) + (y0 * Math.cos(theta));


        return translatedCoordinates;
    }


    /// This take inputs of current and target coordinates and calculates relative coordinates and
    /// movement needed to get there
    /// This uses circular arc trajectory as it is much easier to calculate compared to elliptical
    /// trajectory, using avg velocity compared to avg acceleration, and much simpler math.
    /// The downside of this is that the path itself is less efficient.
    public static double[] calculateRelativeCircularMovement (double[] initialCoordinates,
                                                       double[] targetCoordinates, double CIRCUMFERENCE) {

        // Array to store needed movements (same units as inputs)
        double [] relativeMovements     = new double[3];
        double [] relativeCoordinates   = new double[3];

        // Iterate through the arrays to get each individual value
        for (int i = 0; i < targetCoordinates.length; i++) {
            relativeCoordinates[i] = targetCoordinates[i] - initialCoordinates[i];
        }

        // Account for how rotation affects movement
        double degreesToRotate = relativeCoordinates[2] / 2;
        double [] translatedCoordinates = rotateCoordinates(relativeCoordinates[0], relativeCoordinates[1],
                degreesToRotate);

        // Calculate arc length
        double rotationArc = (relativeCoordinates[2] / 360) * CIRCUMFERENCE;

        // Compiles all movements
        relativeMovements[0] = translatedCoordinates[0]; // x movement
        relativeMovements[1] = translatedCoordinates[1]; // y movement
        relativeMovements[2] = rotationArc; // arc length for turn

        return relativeMovements;
    }
}
