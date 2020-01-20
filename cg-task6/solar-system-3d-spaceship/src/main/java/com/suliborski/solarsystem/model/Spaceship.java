package com.suliborski.solarsystem.model;

import com.jogamp.common.util.ArrayHashSet;
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
    private PVector normalizedDirectionVector;
    private PVector directionVector;
    private PVector replacementVector;
    private ArrayHashSet<PVector> position;
    private PVector interpolatedVector;

    public Spaceship(PApplet c, int x, int y, int z, int s) {
        this.context = c;
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = s;

        this.velocity = 3;


        this.position = createVector(horizontalMiddle, verticalMiddle, this.initialZOffset);

        // z 1?
        this.directionVector = this.cameraPosition.copy().sub(this.position);
    }

    public void forward() {
        // make a unit vector out of direction
    normalizedDirectionVector = this.directionVector.copy().normalize();

        // ensure the ship is going forward initially
        normalizedDirectionVector.z =
                normalizedDirectionVector.z >= 0 ? -normalizedDirectionVector.z : normalizedDirectionVector.z;
    replacementVector = normalizedDirectionVector.mult(this.velocity);

        this.position.add(replacementVector);
    }

    public void back() {
        // make a unit vector out of direction
    normalizedDirectionVector = this.directionVector.copy().normalize();

        // ensure the ship is going forward initially
        normalizedDirectionVector.z =
                normalizedDirectionVector.z >= 0 ? -normalizedDirectionVector.z : normalizedDirectionVector.z;
    replacementVector = normalizedDirectionVector.mult(this.velocity);

        // subtract the replacement vector to move backwards
        this.position.remove(replacementVector);
    }

    public void right() {
        // make a unit vector out of direction
    normalizedDirectionVector = this.directionVector.copy().normalize();

        // interpolate the unit vector with the right vector to ensure the ship is going right
    interpolatedVector = normalizedDirectionVector.lerp(getContext().createVector(1, 0, 0), 0.5);
    replacementVector = interpolatedVector.mult(this.velocity);

        this.position.add(replacementVector);
    }

    public void left() {
        // make a unit vector out of direction
    normalizedDirectionVector = this.directionVector.copy().normalize();

        // interpolate the unit vector with the right vector to ensure the ship is going right
    interpolatedVector = normalizedDirectionVector.lerp(createVector(1, 0, 0), 0.5);
    replacementVector = interpolatedVector.mult(this.velocity);

        this.position.remove(replacementVector);
    }

    public void render() {

        getContext().pushMatrix();

        getContext().fill(255, 100, 100);
        getContext().translate(x, y, z);
        getContext().box(size);

        getContext().popMatrix();
    }
}
