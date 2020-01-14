package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;


@Data
public class Spaceship {

    private PApplet context;

    private float x;
    private float y;
    private float z;

    private int directionX;
    private int directionY;
    private int directionZ;

    private int size;
    private int speed;

    public Spaceship(PApplet c, int x, int y, int z, int s) {
        this.context = c;
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = s;

        this.speed = 3;
    }

    public void render() {

        x += directionX * speed;
        y += directionY * speed;
        z += directionZ * speed;

        getContext().pushMatrix();

        getContext().fill(255, 100, 100);
        getContext().translate(x, y, z);
        getContext().box(size);

        getContext().popMatrix();
    }
}
