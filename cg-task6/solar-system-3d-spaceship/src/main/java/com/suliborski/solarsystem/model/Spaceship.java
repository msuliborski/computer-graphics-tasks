package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;
import processing.core.PVector;


@Data
public class Spaceship {

    private PApplet context;

    private float x;
    private float y;
    private float z;

    private int size;
    private int velocity;
    private int rotationSpeed;

    private PVector direction;
    private int movingForward;
    private int movingUp;
    private int rotatingZ;
    private int currentAngleZ;

    public Spaceship(PApplet c, int x, int y, int z, int s) {
        this.context = c;
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = s;

        this.velocity = 8;
        this.rotationSpeed = 8;

        this.direction = new PVector(1, 0);
    }

    public void render() {
        getContext().pushMatrix();

        float previousZRotation = currentAngleZ;
        currentAngleZ += rotatingZ * rotationSpeed;
        float deltaRotation = getContext().radians(currentAngleZ) - getContext().radians(previousZRotation);
        x += movingForward * direction.x * velocity;
        y += movingForward * direction.y * velocity;
        z += movingUp * velocity;
        getContext().translate(x, y, z);
        direction.rotate(deltaRotation);
        getContext().rotateZ(getContext().radians(currentAngleZ));

        getContext().fill(255, 100, 100);
        getContext().box(size);

        getContext().popMatrix();
    }
}
