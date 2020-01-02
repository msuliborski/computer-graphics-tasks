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
        getContext().noStroke();
        getContext().fill(255, 255, 255);
        getContext().specular(getColor().x, getColor().y, getColor().z);
        getContext().emissive(0);

//        if (isSpecular()) {
//        getContext().noStroke();
//        getContext().shininess(1.0f);
//            getContext().specular(255, 255, 255);
//        } else {
//            getContext().fill(getColor().x, getColor().y, getColor().z);
//            getContext().stroke(255, 30);
//        }


        if (getImage() != null) {
            PShape s = getContext().createShape(SPHERE, getRadius());
            s.setTexture(getImage());
            getContext().shape(s, 0, 0);
        } else if (getShape() != null) {
            getShape().scale(0.005f);
            getContext().shape(getShape(), 0, 0);
        } else {
            getContext().noStroke();
            getContext().fill(255, 255, 255);
            getContext().sphere(getRadius());
        }

        getContext().popMatrix();
    }
}
