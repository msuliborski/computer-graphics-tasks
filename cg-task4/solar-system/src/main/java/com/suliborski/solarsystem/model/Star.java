package com.suliborski.solarsystem.model;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Star extends AstronomicalObject {

    private List<Planet> planets;

    public Star(PApplet c, float r, float a, float d) {
        super(c, r, a, d);
        setX(getContext().width/2  - 200);
        setY(getContext().height/2);
        planets = new ArrayList<>();
    }

    public void addPlanet(Planet p) {
        planets.add(p);
    }

    public void render() {
        getContext().fill(getColor().x, getColor().y, getColor().z);

        getContext().pushMatrix();
        getContext().ellipse(getX(), getY(), getRadius()*2, getRadius()*2);
        for (Planet p : planets)
            p.render();
        getContext().popMatrix();
    }
}
