package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

@Data
public class Moon extends AstronomicalObject {

    Planet planet;

    public Moon(PApplet c, Planet p, float r, float a, float d) {
        super(c, r, a, d);
        this.planet = p;

        setAngularVelocity((float) (0.5f / Math.sqrt(getDistance())));
        setAngle(getContext().random(0, (float) (2 * Math.PI)));
    }

    void render() {
        setAngle(getAngle() + getAngularVelocity());
        setX(getContext().cos(getAngle()) * getDistance());
        setY(getContext().sin(getAngle()) * getDistance());

        getContext().pushMatrix();
        getContext().translate(getX(), getY());
        getContext().fill(190, 189, 179);
        getContext().sphere(getRadius());
        getContext().popMatrix();
    }
}
