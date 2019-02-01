/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */



package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Rover Ruckus Autonomous Depot", group = "Autonomous")

public class RoverRuckusAutonomousDepot extends LinearOpMode
{
    Hardware h = new Hardware(DcMotor.RunMode.RUN_TO_POSITION);
    
    private String Date;
    private ElapsedTime runtime = new ElapsedTime();

    public int currentDegrees;

    long start = System.currentTimeMillis();

    int driveTime;

    ////////////////START////////////////
    @Override
    public void runOpMode() throws InterruptedException
    {
        try{
            h.init(hardwareMap);
        }catch(Exception e)
        {
            telemetry.addData("Something failed to initialize", ":");
            telemetry.update();
            e.printStackTrace();
        }


        //Calibrate gyro

        h.MRGyro.calibrate();
        while(h.MRGyro.isCalibrating() && opModeIsActive())
        {
            telemetry.update();
            telemetry.addData("Gyro:", "calibrating");
        }
        telemetry.addData("Calibration", "complete");
        telemetry.update();

        waitForStart();
////////////////AUTONOMOUS////////////////

        h.motorLift.setTargetPosition(9600);
        h.motorLift.setPower(1);

        Thread.sleep(6000);

        h.motorLift.setTargetPosition(0);

        h.turn(45);

        h.drive(true, 2, 1);

        h.turn(0);

        h.drive(true, 42, 1);

        h.turn(180);

        h.markerDropServo.setPosition(0);
        Thread.sleep(2000);
        h.markerDropServo.setPosition(0.3);

        h.turn(135);

        h.drive(true, 70, 1);

        while(opModeIsActive())
        {
            telemetry.addData("gyro:", h.MRGyro.getHeading());
            telemetry.addData("integated z:", h.MRGyro.getIntegratedZValue());
            telemetry.addData("current degrees:", currentDegrees);

            telemetry.update();
        }
    }
}