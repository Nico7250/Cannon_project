package com.company;

import processing.core.*;

public class Cannon {
    PApplet parent;
    PImage cannon;

    Cannon(PApplet p){
        parent = p;
        cannon = parent.loadImage("/Users/Nicolai/IdeaProjects/Kanon_projekt/src/com/company/artillery-2024318_640.png");

    }

    void display(){
        cannon.resize(175,125);
        parent.pushMatrix();
        parent.translate(90,720);
        parent.rotate(aim());
        parent.image(cannon,0,0);
        parent.popMatrix();
    }

    public float aim(){
        PVector mouse = new PVector(parent.mouseX, parent.mouseY);
        PVector cannon = new PVector(90,720);
        PVector dir = PVector.sub(mouse, cannon);
        return parent.atan2(dir.y, dir.x);

    }
}
