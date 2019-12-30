package com.suliborski.solarsystem.model;

import processing.core.PApplet;

public class Moon extends AstronomicalObject {

    private float rotationSpeed;
    private float angularVelocity;
    Planet planet;

    public Moon(PApplet c, Planet p, float r, float a, float d) {
        super(c, r, a, d);
        this.planet = p;
        this.rotationSpeed = getContext().random(0.1f, 0.2f);
        this.angularVelocity = getContext().random(0.01f, 0.03f);
    }

    void render() {
        this.getContext().pushMatrix();
        this.getContext().fill(0, 0, 255);

        setAngle(getAngle() + angularVelocity);

        setX(getContext().cos(getAngle()) * getDistance());
        setY(getContext().sin(getAngle()) * getDistance());

        getContext().translate(planet.getX(), planet.getY());

        getContext().ellipse(getX(), getY(), getRadius()*2, getRadius()*2);

        getContext().popMatrix();
    }

}
