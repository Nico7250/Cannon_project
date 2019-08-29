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
        parent.stroke(0);
        parent.strokeWeight( 2);
        parent.fill(200,0,0);
        parent.ellipse(location.x, location.y,40,40);

    }

    void update(){

    }
}
