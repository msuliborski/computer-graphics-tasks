package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;


@Data
public class Spaceship {

    private PApplet context;

    private float x;
    private float y;
    private float z;

    private int movingX;
    private int movingY;
    private int movingZ;

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

        x += movingX * speed;
        y += movingY * speed;
        z += movingZ * speed;

        getContext().pushMatrix();

        getContext().fill(255, 100, 100);
        getContext().translate(x, y, z);
        getContext().box(size);

        getContext().popMatrix();
    }
}
