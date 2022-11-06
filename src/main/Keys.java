package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingUtilities;
// no change needs to be made 
class Keys implements KeyListener { //Keylistener is a built in interace from java 
  private Map<Integer,Runnable> actionsPressed = new HashMap<>(); //List of actions to keep track 
  private Map<Integer,Runnable> actionsReleased = new HashMap<>(); 
  public void setAction(int keyCode,Runnable onPressed,Runnable onReleased){ //apply the action 
    actionsPressed.put(keyCode,onPressed);
    actionsReleased.put(keyCode,onReleased);
    }
  public void keyTyped(KeyEvent e){} 
  public void keyPressed(KeyEvent e){  
    assert SwingUtilities.isEventDispatchThread();
    actionsPressed.getOrDefault(e.getKeyCode(),()->{}).run(); 
  }
  public void keyReleased(KeyEvent e){
    assert SwingUtilities.isEventDispatchThread();
    actionsReleased.getOrDefault(e.getKeyCode(),()->{}).run();
  } //no constructor so we have a auto no args constructor 
}