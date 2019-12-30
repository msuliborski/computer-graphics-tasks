package com.suliborski.solarsystem.model;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Planet extends AstronomicalObject {

    private float rotationSpeed;
    private float angularVelocity;
    Star star;
    private List<Moon> moons;

    public Planet(PApplet c, Star s, float r, float a, float d) {
        super(c, r, a, d);
        this.star = s;
        this.rotationSpeed = getContext().random(0.1f, 0.2f);
        this.angularVelocity = getContext().random(0.01f, 0.03f);
        moons = new ArrayList<>();
    }

    public void addMoon(Moon m) {
        moons.add(m);
    }

    void render() {
        this.getContext().pushMatrix();
        this.getContext().fill(0, 255, 0);

        setAngle(getAngle() + angularVelocity);

        setX(getContext().cos(getAngle()) * getDistance());
        setY(getContext().sin(getAngle()) * getDistance());

        getContext().translate(star.getX(), star.getY());

        getContext().ellipse(getX(), getY(), getRadius()*2, getRadius()*2);


        for (Moon m : moons)
            m.render();

        getContext().popMatrix();
    }

}
