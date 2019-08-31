package com.company;

import processing.core.*;

public class Ball {
    PApplet parent;
    PVector location;
    PVector velocity;
    PVector acceleration;
    PVector force;
    PVector drag;

    float mass; //size scales with mass
    float c; // Drag coefficient

    Ball(float x, float y, PApplet p){
        parent = p;
        location = new PVector(x, y);
        velocity = new PVector(0,0);
        acceleration = new PVector(0,0);
        force = new PVector(0,0);
        drag = new PVector(0,0);
        mass = (float) 1;
        c = (float) 0;
    }
    // Graphics for ball.
    void display(){
        parent.stroke(47, 79, 79);
        parent.strokeWeight( 2);
        parent.fill(47,79,79);
        parent.ellipse(location.x, location.y,mass*40,mass*40);

    }
    // Newtons 2nd law. Accumulated forces.
    void applyForce(PVector force){
        //f is a copy of the applied force, so that the force object itself isn't changed.
        PVector f = PVector.div(force, mass);
        acceleration.add(f);
    }

    PVector drag(){
        float speed = velocity.mag();
        float dragMagnitude = c * speed * speed;

        PVector dragForce = velocity.get();
        dragForce.mult(-1);

        dragForce.normalize();
        dragForce.mult(dragMagnitude);

        return dragForce;
    }
    //The base physics formulas for the ball.
    void update(){
        velocity.add(acceleration);
        location.add(velocity);
    }

}
