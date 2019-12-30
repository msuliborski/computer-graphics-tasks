package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

@Data
public class Moon extends AstronomicalObject {

    Planet planet;

    public Moon(PApplet c, Planet p, float r, float a, float d) {
        super(c, r, a, d);
        this.planet = p;

        setAngularVelocity((float) (1f / Math.sqrt(getDistance())));
        setAngle(getContext().random(0, (float) (2 * Math.PI)));
    }

    void render() {
        getContext().fill(190, 189, 179);

        setAngle(getAngle() + getAngularVelocity());
        setX(getContext().cos(getAngle()) * getMinDistance());
        setY(getContext().sin(getAngle()) * getMaxDistance());

        getContext().pushMatrix();
        getContext().translate(planet.getX(), planet.getY());
        getContext().ellipse(getX(), getY(), getRadius()*2, getRadius()*2);
        getContext().popMatrix();
    }
}
