package main;
// no change needs to be made 
record Coord(int x, int y){ //record class 
  public Point toPoint(){ //returns the point associated with 'this' coordinate 
    return new Point(x+0.5d, y+0.5d);
  }
}