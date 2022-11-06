package main;

import java.util.List;

public interface Model{ 
  Camera camera();
  List<Entity> entities();
  void remove(Entity e);
  Cells cells();
  void onGameOver();
  void onNextLevel();

  default void ping(){ 
    entities().forEach(e->e.ping(this)); // for all entities ping them 
    var end = entities().stream().noneMatch(e->e instanceof Monster); //find out if there exist entities that are monsters 
    if(end){ onNextLevel(); } //if not then we can increase level
    }
  }