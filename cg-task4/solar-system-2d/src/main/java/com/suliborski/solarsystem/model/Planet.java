package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

@Data
public class Planet extends AstronomicalObject {

    private Star star;
    private OrbitPath orbitPath;
    private List<Moon> moons = new ArrayList<>();;

    public Planet(PApplet c, Star s, float r, float a, float d) {
        super(c, r, a, d);
        this.star = s;

        setAngle(getContext().random(0, (float) (2 * Math.PI)));
        setAngularVelocity((float) (3f / getDistance()));

        orbitPath = new OrbitPath(getContext(), this);
    }

    public void addMoon(Moon m) {
        moons.add(m);
    }

    void render() {
        setAngle(getAngle() + getAngularVelocity());
        setX(getContext().cos(getAngle()) * getDistance());
        setY(getContext().sin(getAngle()) * getDistance());

        getContext().pushMatrix();
        orbitPath.render();
        getContext().translate(getX(), getY());
        getContext().fill(getColor().x, getColor().y, getColor().z);
        getContext().ellipse(0, 0, getRadius() * 2, getRadius() * 2);
        for (Moon m : moons)
            m.render();
        getContext().popMatrix();
    }
}
