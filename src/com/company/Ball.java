package com.company;

import processing.core.*;

public class Ball {
    PApplet parent;
    PVector location;
    PVector velocity;
    PVector acceleration;
    PVector force;
    PVector drag;
    float t;
    float gravity;
    float angle;
    boolean fired;
    float vx;
    float vy;
    float mass; //size scales with mass
    float c; // Drag coefficient

    Ball(/*float x, float y,*/ PApplet p){
        parent = p;
        fired = false;
        location = new PVector(90, 720);
        velocity = new PVector(1,1);
        acceleration = new PVector((float)0.4,(float)-0.25);

        force = new PVector(0,0);
        drag = new PVector(0,0);
        mass = (float) 1;
        c = (float) 0.5;
        t = 0;
        gravity = (float)9.82;
    }

    // Graphics for ball.
    void display(){
        parent.stroke(47, 79, 79);
        parent.strokeWeight( 2);
        parent.fill(47,79,79);
        parent.ellipse(location.x, location.y,mass*25,mass*25);

    }
    // Newtons 2nd law. Accumulated forces.
    void applyForce(PVector force){
        //f is a copy of the applied force, so that the force object itself isn't changed.
        // Acceleration = force/mass
            PVector f = PVector.div(force, mass);
            acceleration.add(f);
    }

    PVector drag(){
        float speed = velocity.mag();
        float dragMagnitude = c * speed * speed;

        PVector dragForce = velocity.copy();
        dragForce.mult(-1);

        dragForce.normalize();
        dragForce.mult(dragMagnitude);

        return dragForce;
    }

    public float dir() {
        PVector mouse = new PVector(parent.mouseX, parent.mouseY);
        PVector cannon = new PVector(90, 720);
        PVector dir = PVector.sub(mouse, cannon);
        return parent.atan2(dir.y+720, dir.x);
    }

    public void shoot(){
        if(parent.mousePressed){
            fired=true;
            parent.pushMatrix();
            parent.translate(90,720);
            angle = dir();
            //float rot = angle + parent.PI/2;
            velocity = new PVector(80,80);
            vx = (float) (velocity.x * parent.cos(angle));
            vy = (float) (velocity.y * parent.sin(angle));
            t = 0;
            location.x = 90+vx * t;
            location.y = 720-(vy * t - (gravity / 2) * t * t);
            //applyForce(drag());
            parent.popMatrix();

        }
    }


    //The base physics formulas for the ball.
    void update(){
        if(fired) {
            t += 0.02;
            vx = (velocity.x * parent.cos(angle));
            vy = (float) (velocity.y * parent.sin(angle));

            location.x = 90+vx * t;
            location.y = 720-(vy * t - (gravity / 2) * t * t);

            velocity.add(acceleration);
           //location.add(velocity);
        }
    }

}
