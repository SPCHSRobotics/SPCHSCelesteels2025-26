package org.firstinspires.ftc.teamcode.lucyCode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

/**
 *
 *      This is for me to create utility functions for my other stuff to call
 *      These are meant to be reusable in different circumstances
 *
 */
public class lucyUtilFuncs {


    /**
     * @param colorSensor
     * This will take input of color sensor object and read the color it has
     * This is to specifically return string of the color, rather than base rgb values
     *
     * This is setup for either green or purple
     *
     * @return
     */

    public static String readColor(NormalizedColorSensor colorSensor) {

        String colorReading = null;

        NormalizedRGBA sensorValues = colorSensor.getNormalizedColors();

        if ((sensorValues.green > 30) && (sensorValues.green > sensorValues.red))
            colorReading = "Green";

        else if ((sensorValues.red > 30) && (sensorValues.red > sensorValues.green))
            colorReading = "Purple";


        return colorReading;
    }
}
