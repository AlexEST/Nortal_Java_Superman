package com.nortal.clark.training.assignment.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Clark implements Serializable {

    /**
     * Positive speed = moving east
     * Negative speed = moving west
     */
    private double horizontal = 0;
    /**
     * Positive speed = moving north
     * Negative speed = moving south
     */
    private double vertical = 0;
    private Position position = new Position(1, 1);

    public Clark() {
    }

    public double getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(double horizontal) {
        this.horizontal = horizontal;
    }

    public double getVertical() {
        return vertical;
    }

    public void setVertical(double vertical) {
        this.vertical = vertical;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    
    @Override
    public String toString() {
        return String.format("Clark {horizontal=%s, vertical=%s, position=(%s ; %s)}",
                horizontal,
                vertical,
                position.x,
                position.y);
    }
}

