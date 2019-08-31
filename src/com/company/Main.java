package com.company;

import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Main extends PApplet {

    Ball ball;

    public static void main(String[] args) {
        PApplet.main("com.company.Main");
    }

    public void settings(){
        size(800,800);
    }

    public void setup(){
        ball = new Ball(width/2,height/2, this);

    }

    public void draw(){
        background(255);
        //ball.applyForce(force); Gonna be set as acceleration from cannon blast
        ball.applyForce(ball.drag());
        ball.update();
        ball.display();
        ball.acceleration.mult(0);
    }
}
