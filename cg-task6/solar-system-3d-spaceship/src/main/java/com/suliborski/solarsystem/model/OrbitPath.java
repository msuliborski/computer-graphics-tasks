package com.suliborski.solarsystem.model;

import processing.core.PApplet;

public class OrbitPath {

    private PApplet context;
    private Planet planet;

    public OrbitPath(PApplet c, Planet p) {
        this.context = c;
        this.planet = p;
    }

    void render() {
        context.pushMatrix();
        context.stroke(255, 100);
        context.noFill();
        context.ellipse(0, 0, planet.getOrbitDistance()*2, planet.getOrbitDistance()*2);
        context.popMatrix();
    }
}
