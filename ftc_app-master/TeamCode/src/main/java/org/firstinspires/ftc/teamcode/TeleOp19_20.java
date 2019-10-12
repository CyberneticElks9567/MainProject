package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name = "TeleOp Sky Stone", group = "TeleOp")
public class TeleOp19_20 extends LinearOpMode
{
    OpMode opmode;

    @Override
    public void runOpMode()
    {
        Hardware h = new Hardware();

        try {
            h.init(hardwareMap, telemetry);
        } catch (Exception e) {
            telemetry.addData("Init Error:", "Something failed to initialize");
            e.printStackTrace();
        }

        telemetry.addData("Initialization ", "complete");
        telemetry.update();

        waitForStart();

        while (opModeIsActive())
        {
            //telemetry.addData("GrabberR= ",h.servoGrabberR.getPosition());
            //telemetry.addData("GrabberL= ",h.servoGrabberL.getPosition());
            //telemetry.addData("Winch= ", h.motorWinch.getCurrentPosition());
            //telemetry.update();

            h.driveOmniDir(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);

            /*if (gamepad1.dpad_up)
            {
                h.motorWinch.setPower(1);
            }
            if (gamepad1.dpad_down)
            {
                h.motorWinch.setPower(-0.5);
            }
            if(!gamepad1.dpad_up && !gamepad1.dpad_down)
            {
                h.motorWinch.setPower(0);
            }

            if (gamepad1.a)
            {
                h.servoGrabberL.setPosition(.4);
                h.servoGrabberR.setPosition(.4);
            }
            if (gamepad1.b)
            {
                h.servoGrabberL.setPosition(0.05);
                h.servoGrabberR.setPosition(0.05);
            }*/

 
        }
    }
}
