package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static processing.core.PConstants.SPHERE;

@Data
public class Planet extends AstronomicalObject {

    private Star star;
    private OrbitPath orbitPath;
    private List<Moon> moons = new ArrayList<>();;

    public Planet(PApplet c, Star s, float r, float a, float d) {
        super(c, r, a, d);
        this.star = s;

        setOrbitSpeed((float) (0.8f / getOrbitDistance())); //speed of the planet
        setOrbitSlope(getContext().random((float)(-PI/16), (float)(PI/16))); //slope of orbit
        setOrbitInstantAngle(getContext().random(0, (float) (2 * PI))); // start position of a planet
        setRotationSpeed(0.5f); // how fast it spins
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
        if (getOrbitDistance() == 110) getContext().directionalLight(255, 255, 255, 0, -1, 0);
        if (getOrbitDistance() == 190) getContext().spotLight(255, 255, 255, 0, 0, 0, 0, 0, 0, (float) (2*PI), 1000);

        getContext().rotateY((getRotationSlope()));
        getContext().rotate(getRotationInstantAngle());

        getContext().specular(getColor().x, getColor().y, getColor().z);
        getContext().emissive(0);

        this.setShapeAndColour();

        getContext().popMatrix();
    }
}
