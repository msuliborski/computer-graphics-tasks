package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;
import processing.core.PVector;

@Data
public class AstronomicalObject {

    private PApplet context;

    private float x;
    private float y;

    private float radius;
    private float angle;
    private float distance;
    private float angularVelocity;

    private PVector color;

    AstronomicalObject(PApplet c, float r, float a, float d) {
        this.context = c;
        this.radius = r;
        this.angle = a;
        this.distance = d;
        this.color = new PVector(255, 255, 255);
        this.angularVelocity = 0;
    }
}