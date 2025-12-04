package org.firstinspires.ftc.teamcode.userSandboxes.sofiaCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@TeleOp(name = "Sofia tests webcam", group = "Linear OpMode")
public abstract class AprilTagWebcamID extends OpMode {
    AprilTagWebcam aprilTagWebcam = new AprilTagWebcam();
    @Override
    public void init () {
        aprilTagWebcam.init(hardwareMap, telemetry);
    }
    @Override
    public void loop() {
         aprilTagWebcam.update();
        AprilTagDetection id20 = aprilTagWebcam.getTagBySpecificId(20);
        aprilTagWebcam.displayDetectionTelemtry(id20);
    }
}
