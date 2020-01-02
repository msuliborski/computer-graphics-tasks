package com.suliborski.solarsystem.model;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.PI;

public class Star extends AstronomicalObject {

    private List<Planet> planets;

    public Star(PApplet c, float r, float a, float d) {
        super(c, r, a, d);
        setX(0);
        setY(0);
        planets = new ArrayList<>();

        setRotationSpeed(0.03f); // how fast it spins
        setRotationSlope((float)(Math.PI/4)); //rotation slope
    }

    public void addPlanet(Planet p) {
        planets.add(p);
    }

    public void render() {

        setRotationInstantAngle(getRotationInstantAngle() + getRotationSpeed());

        getContext().pushMatrix();
        getContext().translate(getX(), getY());
        for (Planet p : planets)
            p.render();
//        getContext().noStroke();
        getContext().emissive(255, 255, 0);
        getContext().pointLight(255, 255, 255, 0, 0, 0);
        getContext().rotateY((getRotationSlope()));
        getContext().rotate(getRotationInstantAngle());

//        getContext().fill(getColor().x, getColor().y, getColor().z);
//        getContext().stroke(255, 30);
//        getContext().pointLight(255, 255, 255, 0, 0, 0); //for the normal behaviour of the sun light
//        getContext().lightFalloff(0, 0, 0.01f); //light falls off right behind the surface of the sun
//        getContext().ambientLight(255, 255, 255, 100, 0, 0); //ambientLight in the center of the sun

        getContext().sphere(getRadius());
//        getContext().spotLight(253, 184, 19, 100, 0, 0, 1, 1, 1, (float) (PI), 0.5f);
        getContext().popMatrix();
    }
}
