package main;

import java.awt.Dimension;
import java.awt.Graphics;

import imgs.Img;

class Monster implements Entity{ //This class implements the interface of Entity 
  private Point location;
  public Point location(){ return location; } //Monster will need a location 
  public void location(Point p){ location=p; } 
  Monster(Point location){ this.location=location; } //constructor 
  public double speed(){ return 0.05d; } 

  public void ping(Model m){ //if the arrow hits the monster when size variable is small enough then the game is over since the monster is dead
    var arrow = m.camera().location().distance(location);
    double size = arrow.size();
    arrow = arrow.times(speed()/size);
    location = location.add(arrow); 
    if(size<0.6d){ m.onGameOver(); }
  }
 
  public double chaseTarget(Monster outer, Point target){ 
    var arrow = target.distance(outer.location()); //from target to the monsters location 
    double size = arrow.size();
    arrow = arrow.times(speed()/size);
    outer.location(outer.location().add(arrow));
    return size;
  }
  public void draw(Graphics g, Point center, Dimension size) { //draws the monster 
    drawImg(Img.AwakeMonster.image, g, center, size);
  }
}