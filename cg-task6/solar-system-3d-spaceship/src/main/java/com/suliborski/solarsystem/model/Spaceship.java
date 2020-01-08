package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

import static java.lang.Math.PI;

@Data
public class Spaceship {

    private PApplet context;

    private float x;
    private float y;
    private float z;

    private float size;

    public Spaceship(PApplet c, float x, float y, float z, int s) {
        this.context = c;
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = s;
    }

    public void render() {

        getContext().pushMatrix();

        getContext().fill(255, 255, 255);

        getContext().translate(x, y, z);
        getContext().rotate(0);


        getContext().box(getSize());

        getContext().popMatrix();
    }
}