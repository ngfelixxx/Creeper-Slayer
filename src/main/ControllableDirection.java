package main;

import java.util.function.Function;
// no change needs to be made 
abstract class ControllableDirection{
  private Direction direction=Direction.None; //feild 
  public Direction direction(){ return direction; } //getter 
  public void direction(Direction d){ direction=d; } //setter 
  public Runnable set(Function<Direction,Direction> f){ 
    return ()->direction=f.apply(direction); //apply direction 
  }
}