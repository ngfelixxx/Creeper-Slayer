package main;

import javax.swing.SwingUtilities;
// no change needs to be made 
public class Main {
  public static void main(String[]a){
    SwingUtilities.invokeLater(Compact::new); 
  }
}