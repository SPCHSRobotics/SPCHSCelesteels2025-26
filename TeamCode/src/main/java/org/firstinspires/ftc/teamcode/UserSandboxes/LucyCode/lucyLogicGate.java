package org.firstinspires.ftc.teamcode.UserSandboxes.LucyCode;

import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

public class lucyLogicGate {

    /**
     * Read color of incoming artifact and send it to color designated chamber
     * @param inputServo
     *      Controls which chamber an ingoing artifact goes to
     * @param artifactReader
     *      Reads the color of an incoming artifact
     * @param artifactCount
     *      The amount of purple and green artifacts in the chamber
     *      [0] is purple
     *      [1] is green
     */
    public int[] artifactInputControl (Servo inputServo, NormalizedColorSensor artifactReader,
                                      int[] artifactCount) {
        String inputArtifactColor = null;

        int purpleCount = artifactCount[0];
        int greenCount  = artifactCount[1];

        inputArtifactColor = lucyUtilFuncs.readColor(artifactReader);

        // Based on artifact color send it to correct chamber and record amount in chamber
        switch (inputArtifactColor) {

            case "Purple":
                inputServo.setPosition(lucyConstDefinitions.INTAKE_SERVO_PURPLE);
                purpleCount++;
                break;

            case "Green":
                inputServo.setPosition(lucyConstDefinitions.INTAKE_SERVO_GREEN);
                greenCount++;
                break;


        }

        // group artifacts counts into array to return as single object
            // This is required because you can only return a single object, not two separate ints
        artifactCount[0] = purpleCount;
        artifactCount[1] = greenCount;

        return artifactCount;
    }

    /**
     *  Handle the controls of the chambers feeding into the output launcher
     *      Returns amount of purple artifacts in chamber
     * @param outputServo
     *      Handles filter for which artifact to launch
     * @param purpleGate
     *      Releases purple artifact
     * @param purpleCount
     *      How many purple artifacts are in chamber
     */
    public static int launchPurple (Servo outputServo, Servo purpleGate, int purpleCount) {

        if (purpleCount > 0) {
            // Load the artifact
            outputServo.setPosition(lucyConstDefinitions.OUTPUT_CONTROL_PURPLE);
            purpleGate.setPosition(lucyConstDefinitions.PURPLE_GATE_OPEN);

            // TODO: call function to actually launch the artifact

            purpleCount--;
        }

        return purpleCount;
    }

    public static int launchGreen (Servo outputServo, Servo greenGate, int greenCount) {

        if (greenCount > 0) {
            // Load the artifact
            outputServo.setPosition(lucyConstDefinitions.OUTPUT_CONTROL_GREEN);
            greenGate.setPosition(lucyConstDefinitions.GREEN_GATE_OPEN);

            // TODO: call function to actually launch the artifact

            greenCount--;
        }

        return greenCount;
    }

    /**
     *
     * @param outputServo
     *      Filters which artifact is launched
     * @param greenGate
     *      Releases green artifact
     * @param purpleGate
     *      Releases Purple artifact
     * @param artifactCount
     *      The amount of purple and green artifacts in the chamber
     *      [0] is purple
     *      [1] is green
     * @param obeliskCode
     *      PPG, PGP, GPP, code of what the obelisk shows
     * @return
     *      updated artifact count
     */
    public static int[] launchObeliskCombo (Servo outputServo, Servo greenGate, Servo purpleGate,
                                          int[] artifactCount, String obeliskCode) {

        int purpleCount = artifactCount[0];
        int greenCount  = artifactCount[1];

        // Launch artifacts in order based on obelisk code
        switch (obeliskCode) {
            case "PPG":
                purpleCount = launchPurple(outputServo, purpleGate, purpleCount);
                purpleCount = launchPurple(outputServo, purpleGate, purpleCount);
                greenCount  = launchGreen(outputServo, greenGate, greenCount);
                break;

            case "PGP":
                purpleCount = launchPurple(outputServo, purpleGate, purpleCount);
                greenCount  = launchGreen(outputServo, greenGate, greenCount);
                purpleCount = launchPurple(outputServo, purpleGate, purpleCount);
                break;

            case "GPP":
                greenCount  = launchGreen(outputServo, greenGate, greenCount);
                purpleCount = launchPurple(outputServo, purpleGate, purpleCount);
                purpleCount = launchPurple(outputServo, purpleGate, purpleCount);
                break;

        }

        // group artifacts counts into array to return as single object
        // This is required because you can only return a single object, not two separate ints
        artifactCount[0] = purpleCount;
        artifactCount[1] = greenCount;

        return artifactCount;
    }



}
