package com.suliborski.solarsystem;

import java.util.ArrayList;

import com.suliborski.solarsystem.model.Moon;
import com.suliborski.solarsystem.model.Planet;
import com.suliborski.solarsystem.model.Star;
import processing.core.PApplet;

public class SolarSystem extends PApplet{

    private Star sun;

    private Planet mercury, venus, earth, mars;
    private Moon moon;

    public void settings(){
        size(800, 640);

        sun = new Star(this, 30, 0, 0);

        mercury = new Planet(this, sun, 5, 0, 80);
        sun.addPlanet(mercury);

        venus = new Planet(this, sun, 15, 0, 150);
        sun.addPlanet(venus);

        earth = new Planet(this, sun, 20, 0, 180);
        moon = new Moon(this, earth, 2, 0, 25);
        earth.addMoon(moon);
        sun.addPlanet(earth);

        mars = new Planet(this, sun, 10, 0, 200);
        sun.addPlanet(mars);

    }

    public void draw(){
        background(0);
        sun.render();
    }

    public static void main(String[] args){
        String[] processingArgs = {"SolarSystem"};
        SolarSystem solarSystem = new SolarSystem();
        PApplet.runSketch(processingArgs, solarSystem);
    }
}
