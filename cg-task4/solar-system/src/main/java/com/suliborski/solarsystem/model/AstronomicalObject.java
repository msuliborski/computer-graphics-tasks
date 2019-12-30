package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

@Data
public class AstronomicalObject {
    private PApplet context;

    private float x;
    private float y;

    private float radius;
    private float angle;
    private float distance;


    public AstronomicalObject(PApplet c, float r, float a, float d) {
        this.context = c;
        this.radius = r;
        this.angle = a;
        this.distance = d;
    }

}