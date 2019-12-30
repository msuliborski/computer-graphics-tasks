package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

@Data
public class Planet extends AstronomicalObject {

    private float slope;

    private Star star;
    private OrbitPath orbitPath;
    private List<Moon> moons = new ArrayList<>();;

    public Planet(PApplet c, Star s, float r, float a, float d) {
        super(c, r, a, d);
        this.star = s;
        this.slope = 0;

        setAngle(getContext().random(0, (float) (2 * Math.PI)));
        setAngularVelocity((float) (0.01f / Math.sqrt(getDistance())));

        orbitPath = new OrbitPath(getContext(), this);
    }

    public void addMoon(Moon m) {
        moons.add(m);
    }

    void render() {
        getContext().fill(getColor().x, getColor().y, getColor().z);

        setCurrentDistance((float) Math.sqrt(Math.pow(star.getX() - getX(), 2) + Math.pow(star.getY() - getY(), 2)));
        setAngle((float) (getAngle() + getAngularVelocity() * Math.pow(getCurrentDistance(), 2) / Math.pow(getMaxDistance(), 2)));
        setX(getContext().cos(getAngle()) * getMaxDistance());
        setY(getContext().sin(getAngle()) * getMinDistance());

        getContext().pushMatrix();
        getContext().translate((float) (star.getX() + Math.sqrt(Math.pow(getMaxDistance(), 2) - Math.pow(getMinDistance(), 2)) * getContext().cos(slope)), (float) (star.getY() + Math.sqrt(Math.pow(getMaxDistance(), 2) - Math.pow(getMinDistance(), 2)) * getContext().sin(slope)));
        getContext().rotate(slope);
        getContext().ellipse(getX(), getY(), getRadius() * 2, getRadius() * 2);
        orbitPath.render();
        for (Moon m : moons)
            m.render();
        getContext().popMatrix();
    }
}
