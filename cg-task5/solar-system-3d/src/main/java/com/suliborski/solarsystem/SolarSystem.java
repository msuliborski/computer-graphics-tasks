package com.suliborski.solarsystem;

import com.suliborski.solarsystem.model.Moon;
import com.suliborski.solarsystem.model.Planet;
import com.suliborski.solarsystem.model.Star;
import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SolarSystem extends PApplet{

    private Star sun;
    private Planet earth, sedna;

    public void settings(){
        size(1200, 800, P3D);

        sun = new Star(this, 25, 0, 0);
        sun.setColor(new PVector(245, 236, 111));

        Planet mercury = new Planet(this, sun, 4, 0, 60);
        mercury.setColor(new PVector(144, 143, 127));
        sun.addPlanet(mercury);

        Planet venus = new Planet(this, sun, 7, 0, 80);
        venus.setColor(new PVector(237, 199, 131));
        sun.addPlanet(venus);

        earth = new Planet(this, sun, 8, 0, 110);
        earth.setColor(new PVector(139, 158, 127));
        Moon moon = new Moon(this, earth, 1, 0, 12);
        earth.addMoon(moon);
        sun.addPlanet(earth);

        Planet mars = new Planet(this, sun, 5.5f, 0, 140);
        mars.setColor(new PVector(138, 73, 52));
        Moon phobos = new Moon(this, mars, 1, 0, 9);
        Moon deimos = new Moon(this, mars, 1, 0, 12);
        mars.addMoon(phobos);
        mars.addMoon(deimos);
        sun.addPlanet(mars);

        Planet jupiter = new Planet(this, sun, 20, 0, 190);
        jupiter.setColor(new PVector(201, 188, 163));
        Moon io = new Moon(this, jupiter, 1, 0, 28);
        Moon europa = new Moon(this, jupiter, 1, 0, 31);
        Moon ganymede = new Moon(this, jupiter, 1.5f, 0, 34);
        Moon callisto = new Moon(this, jupiter, 1, 0, 37);
        jupiter.addMoon(io);
        jupiter.addMoon(europa);
        jupiter.addMoon(ganymede);
        jupiter.addMoon(callisto);
        sun.addPlanet(jupiter);

        Planet saturn = new Planet(this, sun, 18, 0, 270);
        saturn.setColor(new PVector(250, 204, 158));
        Moon mimas = new Moon(this, saturn, 1, 0, 22);
        Moon enceladus = new Moon(this, saturn, 1, 0, 24);
        Moon tethys = new Moon(this, saturn, 1, 0, 26);
        Moon dione = new Moon(this, saturn, 1, 0, 28);
        Moon rhea = new Moon(this, saturn, 1, 0, 30);
        Moon titan = new Moon(this, saturn, 1.5f, 0, 32);
        Moon hyperion = new Moon(this, saturn, 1, 0, 34);
        Moon iapetus = new Moon(this, saturn, 1, 0, 36);
        saturn.addMoon(mimas);
        saturn.addMoon(enceladus);
        saturn.addMoon(tethys);
        saturn.addMoon(dione);
        saturn.addMoon(rhea);
        saturn.addMoon(titan);
        saturn.addMoon(hyperion);
        saturn.addMoon(iapetus);
        saturn.setSpecular(true);
        sun.addPlanet(saturn);

        Planet uranus = new Planet(this, sun, 13, 0, 330);
        uranus.setColor(new PVector(127, 173, 169));
        Moon miranda = new Moon(this, uranus, 1, 0, 18);
        Moon ariel = new Moon(this, uranus, 1, 0, 20);
        Moon umbrel = new Moon(this, uranus, 1, 0, 22);
        Moon titana = new Moon(this, uranus, 1, 0, 24);
        Moon oberon = new Moon(this, uranus, 1, 0, 26);
        uranus.addMoon(miranda);
        uranus.addMoon(ariel);
        uranus.addMoon(umbrel);
        uranus.addMoon(titana);
        uranus.addMoon(oberon);
        sun.addPlanet(uranus);


        Planet neptune = new Planet(this, sun, 13, 0, 380);
        neptune.setColor(new PVector(65, 117, 169));
        Moon triton = new Moon(this, neptune, 1, 0, 18);
        neptune.addMoon(triton);
        sun.addPlanet(neptune);

        sedna = new Planet(this, sun, 8, 0, 420);
        sedna.setColor(new PVector(238, 34, 12));
        sedna.setOrbitSlope(PI/3);
        sedna.setOrbitSpeed(0.1f);
        sun.addPlanet(sedna);
    }

    public void draw(){
        background(0);
        earth.setImage(loadImage("src/main/resources/earth.jpeg"));
        sedna.setShape(loadShape("src/main/resources/asteroid.obj"));
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
