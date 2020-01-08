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

    protected void setShapeAndColour(){
        if (isSpecular){
            getContext().noStroke();
            getContext().fill(getColor().x, getColor().y, getColor().z);
            getContext().specular(getColor().x, getColor().y, getColor().z);
            getContext().sphere(getRadius());
        } else if (getShape() != null) {
            getShape().scale(0.005f);
            getShape().setTexture(getImage());
            getContext().noStroke();
            getContext().noFill();
            getContext().shape(getShape(), 0, 0);
        } else if (getImage() != null) {
            getContext().noStroke();
            getContext().noFill();
            PShape s = getContext().createShape(SPHERE, getRadius());
            s.setTexture(getImage());
            getContext().shape(s, 0, 0);
        } else {
            getContext().noStroke();
            getContext().fill(getColor().x, getColor().y, getColor().z);
            getContext().sphere(getRadius());
        }
    }
}