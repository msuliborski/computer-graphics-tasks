package com.suliborski.solarsystem.model;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Star extends AstronomicalObject {

    private float rotationSpeed;
    private List<Planet> planets;

    public Star(PApplet c, float r, float a, float d) {
        super(c, r, a, d);
        setX(getContext().width/2);
        setY(getContext().height/2);
        this.rotationSpeed = getContext().random(0.1f, 0.2f);
        planets = new ArrayList<>();
    }

    public void addPlanet(Planet p) {
        planets.add(p);
    }

    public void render() {
        getContext().fill(255, 255, 0);
        getContext().ellipse(getX(), getY(), getRadius()*2, getRadius()*2);
        for (Planet p : planets)
            p.render();
    }

}
