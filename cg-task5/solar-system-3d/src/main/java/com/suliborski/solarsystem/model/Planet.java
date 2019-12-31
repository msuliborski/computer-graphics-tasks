package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

@Data
public class Planet extends AstronomicalObject {

    private Star star;
    private OrbitPath orbitPath;
    private List<Moon> moons = new ArrayList<>();;

    public Planet(PApplet c, Star s, float r, float a, float d) {
        super(c, r, a, d);
        this.star = s;

        setOrbitSpeed((float) (0.05f / sqrt(getOrbitDistance()))); //speed of the planet
        setOrbitSlope(getContext().random((float)(-PI/16), (float)(PI/16))); //slope of orbit
        setOrbitInstantAngle(getContext().random(0, (float) (2 * PI))); // start position of a planet
        setRotationSpeed(0.03f); // how fast it spins
        setRotationSlope(getContext().random((float)(-PI), (float)(PI))); //rotation slope

        orbitPath = new OrbitPath(getContext(), this);
    }

    public void addMoon(Moon m) {
        moons.add(m);
    }

    void render() {

        setOrbitInstantAngle(getOrbitInstantAngle() + getOrbitSpeed());
        setX(getContext().cos(getOrbitInstantAngle()) * getOrbitDistance());
        setY(getContext().sin(getOrbitInstantAngle()) * getOrbitDistance());
        setRotationInstantAngle(getRotationInstantAngle() + getRotationSpeed());

        getContext().pushMatrix();
        getContext().rotateY(getOrbitSlope());
        orbitPath.render();
        getContext().translate(getX(), getY());
        for (Moon m : moons)
            m.render();
        getContext().rotateY((getRotationSlope()));
        getContext().rotate(getRotationInstantAngle());
        if (isSpecular()) {
//            getContext().specular(getColor().x, getColor().y, getColor().z);
            getContext().specular(255, 255, 255555);
            getContext().noStroke();
        } else {
            getContext().fill(getColor().x, getColor().y, getColor().z);
            getContext().stroke(255, 30);
        }
        if (getShape() == null) getContext().sphere(getRadius());
        else {getShape().scale(0.005f); getContext().shape(getShape(), 0, 0);}
        getContext().popMatrix();
    }
}
