package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;

import static processing.core.PConstants.SPHERE;

@Data
public class AstronomicalObject {

    private PApplet context;

    private float x;
    private float y;

    private float radius;
    private float orbitInstantAngle;
    private float orbitDistance;
    private float orbitSpeed;
    private float orbitSlope;
    private float rotationInstantAngle;
    private float rotationSpeed;
    private float rotationSlope;

    private PShape shape;
    private PImage image;
    private boolean isSpecular = false;
    private PVector color;

    AstronomicalObject(PApplet c, float r, float a, float d) {
        this.context = c;
        this.radius = r;
        this.orbitInstantAngle = a;
        this.orbitDistance = d;
        this.orbitSpeed = 0;
        this.orbitSlope = 0;
        this.rotationInstantAngle = 0;
        this.rotationSpeed = 0;
        this.rotationSlope = 0;

        this.color = new PVector(255, 255, 255);

    }

    public void setup(){
        if (getShape() == null) {
            context.beginShape();
            context.noStroke();
            PShape s = context.createShape(SPHERE, getRadius());

            setShape(s);
            context.endShape();
        }

        if (getImage() != null) {
            getShape().setTexture(getImage());
        }
    }

    protected void setColor(){
        getContext().noStroke();
        getContext().fill(getColor().x, getColor().y, getColor().z);
        if (isSpecular) getContext().specular(getColor().x, getColor().y, getColor().z);
    }
}