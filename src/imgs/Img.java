package imgs;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public enum Img{ // no change needs to be made 
  AwakeMonster, //names of the files (options the class can be) 
  DeadMonster,
  SleepMonster,
  Grass,
  Hero,
  Tree,
  Sword,
  Rock;
  public final BufferedImage image; 
  Img(){image=loadImage(this.name());} //calls method defined below 
  static private BufferedImage loadImage(String name){
    URL imagePath = Img.class.getResource(name+".png"); //names of the files 
    try{return ImageIO.read(imagePath);} 
    catch(IOException e) { throw new Error(e); }
  }
}