package main;

import java.util.List;

record Phase(Model model, Controller controller){ //record class 
  static Phase level1(Runnable next, Runnable first) { //method
    Camera c = new Camera(new Point(5,5));
    Sword s = new Sword(c);
    Cells cells = new Cells();
    var m = new Model(){ //implementation of all methods from the Model interface
      List<Entity> entities = List.of(c,s,new Monster(new Point(0,0)));
      public Camera camera(){ return c; }
      public List<Entity> entities(){ return entities; }
      public void remove(Entity e){ //uses lambdas to find a remove entities 
        entities = entities.stream()
          .filter(ei->!ei.equals(e))
          .toList();
      }
      public Cells cells(){ return cells; }
      public void onGameOver(){ first.run(); } //calls run on runnable objects to change levels 
      public void onNextLevel(){ next.run(); }
    };
    return new Phase(m,new Controller(c,s)); //using the constructor from record 
  }
}