package com.nortal.clark.training.assignment.controller;

import com.nortal.clark.training.assignment.model.CityMap;
import com.nortal.clark.training.assignment.model.Clark;
import com.nortal.clark.training.assignment.model.Direction;
import com.nortal.clark.training.assignment.model.Position;
import com.nortal.clark.training.assignment.model.SpeedLevel;
import com.nortal.clark.training.assignment.model.VoiceCommand;

import java.util.List;

public class You {

    private List<Position> targetsToCapture;

    public VoiceCommand getNextStep(Clark clark, CityMap cityMap) {
        VoiceCommand voiceCommand = new VoiceCommand(Direction.SOUTH, SpeedLevel.L0_RUNNING_HUMAN);

        // TODO: Implement algorithm to return command to Clark to capture all the targets on the city map provided
        //<<SOLUTION START>>

        if (targetsToCapture == null) {
            targetsToCapture = cityMap.getTargets();
        }

        Position targetToCapture = targetsToCapture.get(0);
        System.out.println(clark + " ->> x=" + targetToCapture.x + ", y=" + targetToCapture.y);

        int diffX = Math.abs(targetToCapture.x - clark.getPosition().x);
        int diffY = Math.abs(targetToCapture.y - clark.getPosition().y);

        SpeedLevel horizontalSpeedLevel = thinkOfSpeedLevel(diffX, clark.getHorizontal());
        SpeedLevel verticalSpeedLevel = thinkOfSpeedLevel(diffY, clark.getVertical());
        
        if (diffX < 2 && diffY < 2) {
            System.out.println("Removing target");
            //Consider it captured
            targetsToCapture.remove(0);
        //rightTop
        } else if (targetToCapture.x > clark.getPosition().x && targetToCapture.y >= clark.getPosition().y) {
            if (diffX >= diffY) {
                voiceCommand = new VoiceCommand(Direction.EAST, horizontalSpeedLevel);
            } else {
                voiceCommand = new VoiceCommand(Direction.NORTH, verticalSpeedLevel);
            }    
        //rightBottom
        } else if (targetToCapture.y < clark.getPosition().y && targetToCapture.x >= clark.getPosition().x) {
            if (diffX >= diffY) {
                voiceCommand = new VoiceCommand(Direction.EAST, horizontalSpeedLevel);
            } else {
                voiceCommand = new VoiceCommand(Direction.SOUTH, verticalSpeedLevel);
            }
        //leftTop
        } else if (targetToCapture.x <= clark.getPosition().x && targetToCapture.y > clark.getPosition().y) {
            if (diffX >= diffY) {
                voiceCommand = new VoiceCommand(Direction.WEST, horizontalSpeedLevel);
            } else {
                voiceCommand = new VoiceCommand(Direction.NORTH, verticalSpeedLevel);
            }
        //leftBottom
        } else if (targetToCapture.y <= clark.getPosition().y && targetToCapture.x < clark.getPosition().x) {
            if (diffX >= diffY) {
                voiceCommand = new VoiceCommand(Direction.WEST, horizontalSpeedLevel);
            } else {
                voiceCommand = new VoiceCommand(Direction.SOUTH, verticalSpeedLevel);
            }
        }

        System.out.println(voiceCommand);
        //<<SOLUTION END>>
        return voiceCommand;
    }



    //<<SOLUTION START>>
    private SpeedLevel thinkOfSpeedLevel(int distanceDiff, double speed) {            
        if (distanceDiff <= 50 && distanceDiff >= 10)
            return SpeedLevel.L3_SUPER_SONIC;
        if (distanceDiff < 10)
            return SpeedLevel.L2_SUB_SONIC;
        
        return SpeedLevel.L4_MACH_9350;
    }
    //<<SOLUTION END>>
}
