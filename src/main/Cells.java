package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import imgs.Img;

class Cells{
  int maxX=16; //boundries of this object 
  int maxY=16;
  private final List<List<Cell>> inner=new ArrayList<>(); //List of List of Cell objects 
  public Cells(){
    for(int x=0;x<maxX;x++){ //populates the cells with cell
      var tmp=new ArrayList<Cell>();
      inner.add(tmp);
      for(int y=0;y<maxY;y++){
        tmp.add(new Cell(List.of(Img.Grass,Img.Tree),x,y));
      }
    }
    inner.get(3).set(3,new Cell(List.of(Img.Grass),3,3));//a patch of grass
    inner.get(4).set(4,new Cell(List.of(Img.Grass),4,4));
    inner.get(3).set(4,new Cell(List.of(Img.Grass),3,4));
  }
  public Cell get(int x,int y){
    var isOut = x<0 || y<0 || x>=maxX || y>=maxY;
    if(isOut){ return new Cell(List.of(Img.Rock),x,y); }
    var res = inner.get(x).get(y); //get the cell thats in this cells object 
    assert res!=null; //error check 
    return res;
  }
  public void forAll(Coord p,int range,Consumer<Cell>action){ //do something to all the cells in this cells object and all its coordinates 
    assert range>=0;
    for(int x=p.x()-range;x<=p.x()+range;x++){
      for(int y=p.y()-range;y<=p.y()+range;y++){
        action.accept(get(x,y));
      }
    }
  }
}