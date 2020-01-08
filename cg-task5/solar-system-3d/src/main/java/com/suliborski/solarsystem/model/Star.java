package com.suliborski.solarsystem.model;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

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

        getContext().pointLight(255, 255, 255, 0, 0, 0);


        for (Planet p : planets)
            p.render();

        getContext().rotateY((getRotationSlope()));
        getContext().rotate(getRotationInstantAngle());

        this.setColor();
        getContext().emissive(getColor().x, getColor().y, getColor().z);
        getContext().noStroke();
        getContext().shape(getShape(), 0, 0);

        getContext().popMatrix();
    }
}
