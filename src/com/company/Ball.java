package com.company;

import processing.core.*;

public class Ball {
    PApplet parent;
    PVector location;
    PVector velocity;
    PVector acceleration;
    PVector force;

    Ball(float x, float y, PApplet p){
        parent = p;
        location = new PVector(x, y);
        velocity = new PVector(0,0);
        acceleration = new PVector(0,0);
        force = new PVector(0,0);
    }

    void display(){

    }

    void update(){

    }
}
