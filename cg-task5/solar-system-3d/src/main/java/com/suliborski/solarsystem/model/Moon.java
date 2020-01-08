package com.suliborski.solarsystem.model;

import lombok.Data;
import processing.core.PApplet;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

@Data
public class Moon extends AstronomicalObject {

    Planet planet;

    public Moon(PApplet c, Planet p, float r, float a, float d) {
        super(c, r, a, d);
        this.planet = p;

        setOrbitSpeed((float) (0.5f / sqrt(getOrbitDistance())));
        setOrbitSlope(getContext().random(0, (float) (2 * PI)));
        setOrbitInstantAngle(getContext().random(0, (float) (2 * Math.PI)));
    }

    void render() {
        setOrbitInstantAngle(getOrbitInstantAngle() + getOrbitSpeed());
        setX(getContext().cos(getOrbitInstantAngle()) * getOrbitDistance());
        setY(getContext().sin(getOrbitInstantAngle()) * getOrbitDistance());

        getContext().pushMatrix();
        getContext().rotateY(getOrbitSlope());

        if (getOrbitDistance() == 12) getContext().spotLight(255, 0, 0, 0, 0, 0, -1, 0 , 0, (float) (PI/4), 2);
        getContext().translate(getX(), getY());
        setColor();
        getContext().box(getRadius());
        getContext().popMatrix();
    }
}
