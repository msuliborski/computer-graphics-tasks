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
        context.stroke(255, 100);
        context.noFill();

        context.pushMatrix();
        context.ellipse(0, 0, planet.getMaxDistance()*2, planet.getMinDistance()*2);
        context.popMatrix();
    }
}
