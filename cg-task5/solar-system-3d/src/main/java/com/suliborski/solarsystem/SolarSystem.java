package com.suliborski.solarsystem;

import com.suliborski.solarsystem.model.Moon;
import com.suliborski.solarsystem.model.Planet;
import com.suliborski.solarsystem.model.Star;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SolarSystem extends PApplet{

    private Star sun;
    private Planet mercury, venus, earth, mars, jupiter, saturn, uranus, neptune, sedna;

    PImage background;

    public void settings(){
        size(1200, 800, P3D);

        sun = new Star(this, 25, 0, 0);
        sun.setColor(new PVector(245, 236, 111));

        mercury = new Planet(this, sun, 4, 0, 60);
        mercury.setColor(new PVector(144, 143, 127));
        sun.addPlanet(mercury);

        venus = new Planet(this, sun, 7, 0, 80);
        venus.setColor(new PVector(237, 199, 131));
        sun.addPlanet(venus);

        earth = new Planet(this, sun, 8, 0, 110);
        earth.setColor(new PVector(139, 158, 127));
        earth.addMoon(new Moon(this, earth, 1, 0, 12));
        sun.addPlanet(earth);

        mars = new Planet(this, sun, 5.5f, 0, 140);
        mars.setColor(new PVector(138, 73, 52));
        mars.addMoon(new Moon(this, mars, 1, 0, 9));
        mars.addMoon(new Moon(this, mars, 1, 0, 12));
        sun.addPlanet(mars);

        jupiter = new Planet(this, sun, 20, 0, 190);
        jupiter.setColor(new PVector(201, 188, 163));
        jupiter.addMoon(new Moon(this, jupiter, 1, 0, 28));
        jupiter.addMoon(new Moon(this, jupiter, 1, 0, 31));
        jupiter.addMoon(new Moon(this, jupiter, 1.5f, 0, 34));
        jupiter.addMoon(new Moon(this, jupiter, 1, 0, 37));
        sun.addPlanet(jupiter);

        saturn = new Planet(this, sun, 18, 0, 270);
        saturn.setColor(new PVector(250, 204, 158));
        saturn.addMoon(new Moon(this, saturn, 1, 0, 22));
        saturn.addMoon(new Moon(this, saturn, 1, 0, 24));
        saturn.addMoon(new Moon(this, saturn, 1, 0, 26));
        saturn.addMoon(new Moon(this, saturn, 1, 0, 28));
        saturn.addMoon(new Moon(this, saturn, 1, 0, 30));
        saturn.addMoon(new Moon(this, saturn, 1.5f, 0, 32));
        saturn.addMoon(new Moon(this, saturn, 1, 0, 34));
        saturn.addMoon(new Moon(this, saturn, 1, 0, 36));
        saturn.setSpecular(true);
        sun.addPlanet(saturn);

        uranus = new Planet(this, sun, 13, 0, 330);
        uranus.setColor(new PVector(127, 173, 169));
        uranus.addMoon(new Moon(this, uranus, 1, 0, 18));
        uranus.addMoon(new Moon(this, uranus, 1, 0, 20));
        uranus.addMoon(new Moon(this, uranus, 1, 0, 22));
        uranus.addMoon(new Moon(this, uranus, 1, 0, 24));
        uranus.addMoon(new Moon(this, uranus, 1, 0, 26));
        sun.addPlanet(uranus);

        neptune = new Planet(this, sun, 13, 0, 380);
        neptune.setColor(new PVector(65, 117, 169));
        neptune.addMoon(new Moon(this, neptune, 1, 0, 18));
        sun.addPlanet(neptune);

        sedna = new Planet(this, sun, 8, 0, 420);
        sedna.setColor(new PVector(238, 34, 12));
        sedna.setOrbitSlope(PI/3);
        sedna.setOrbitSpeed(0.1f);
        sun.addPlanet(sedna);
    }

    public void setup(){
        background = loadImage("src/main/resources/milky_way.png");
        sun.setImage(loadImage("src/main/resources/sun.png"));
        mercury.setImage(loadImage("src/main/resources/mercury.png"));
        venus.setImage(loadImage("src/main/resources/venus.png"));
        earth.setImage(loadImage("src/main/resources/earth.png"));
        mars.setImage(loadImage("src/main/resources/mars.png"));
        jupiter.setImage(loadImage("src/main/resources/jupiter.png"));
        saturn.setImage(loadImage("src/main/resources/saturn.png"));
        uranus.setImage(loadImage("src/main/resources/uranus.png"));
        neptune.setImage(loadImage("src/main/resources/neptune.png"));
        PShape asteroid = loadShape("src/main/resources/asteroid.obj");
        asteroid.scale(0.005f);
        sedna.setShape(asteroid);
        sedna.setImage(loadImage("src/main/resources/asteroid.png"));

        sun.setup();
        mercury.setup();
        venus.setup();
        earth.setup();
        mars.setup();
        jupiter.setup();
        saturn.setup();
        uranus.setup();
        neptune.setup();
        sedna.setup();
    }

    public void draw(){
        background(background);
        camera(30, mouseY, mouseX, // eyeX, eyeY, eyeZ
                0, 0, 0, // centerX, centerY, centerZ
                0, 1, 0); // upX, upY, upZ
        sun.render();
    }

    public static void main(String[] args){
        String[] processingArgs = {"SolarSystem"};
        SolarSystem solarSystem = new SolarSystem();
        PApplet.runSketch(processingArgs, solarSystem);
    }
}
