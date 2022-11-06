package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

class Viewport extends JPanel{ //Jpanel is from java 
  private static final long serialVersionUID = 1L;
  
  public Viewport(Model model){ this.model=model; } //constructor 
  public Point center(){
    return model.camera().location(); //center == camera location 
  }
  
  public void paintComponent(Graphics g) { //graphical display 
    super.paintComponent(g);//Cell.renderX,Cell.renderY
    Dimension s = getSize();
    var centerP = new Point(
      -s.width/(double)(2*Cell.renderX),
      -s.height/(double)(2*Cell.renderY)); //middle of viewport 
    var c = center().add(centerP);
    //Note: may need more then 10 if you have very high screen resolution
    model.cells().forAll(center().toCoord(), 10, cell->cell.draw(g,c,s)); //drawing each cell for cells 
    model.entities().forEach(e->e.draw(g, c, s)); //drawing each cell for entities 
  }
  Model model;
  Keys keys = new Keys();
}