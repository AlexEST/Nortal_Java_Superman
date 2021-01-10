package com.nortal.clark.training.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class VoiceCommand implements Serializable {
    @Getter
    @Setter
    private Direction direction = Direction.EAST;
    @Getter
    @Setter
    private SpeedLevel speedLevel = SpeedLevel.L0_RUNNING_HUMAN;

}
