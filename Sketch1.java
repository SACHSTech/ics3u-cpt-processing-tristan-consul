import processing.core.PApplet;
import processing.core.PImage;
import TileMap.TileMap;
import java.util.ArrayList;

public class Sketch1 extends PApplet {

  public void settings() {
    size(800, 800);
  }

  //Placement Setup
  float x = 200;
  float y = 200;
  float puffer = x+45;
  float fish = y-15;
  float gravity = 400;

  //Control Setup
  boolean WTap = false;
  boolean STap = false;
  boolean DTap = false;
  boolean ATap = false;

  //Additional Variables
  int i = 2;

  PImage[] Fabroa = new PImage[10];
  PImage Aeugh;

  private ArrayList<Boss> Bosses;
  
  public void setup() {
    // Loads Character Files
    Fabroa[0] = loadImage("Images/Mr._Fabroa.png");
    Fabroa[1] = loadImage("Images/Mr._Fabroa3.png");
    Fabroa[2] = loadImage("Images/Mr._Fabroa4.png");
    Fabroa[3] = loadImage("Images/Mr._Fabroa_Jumping.png");
    Fabroa[4] = loadImage("Images/Mr._Fabroa_Death.png");
    Fabroa[5] = loadImage("Images/Mr._Fabroa1.png");
    Fabroa[6] = loadImage("Images/Mr._Fabroa2.png");

    Aeugh = loadImage("Images/Aeugh.png");

  }

    public void draw() {
    //background colour
    background(135,206,235);

    //Moves Mr. Fabroa and Aeugh when controls are pressed
    //jump
    //Infinite jump is now a feature
    if (y <= gravity - 1 && WTap != true) {
      y++;
      fish++;
    }

    if (WTap) {
      if (ATap) {
        x = x--;
      }
      else if (DTap) {
        x = x++;
      }
      counter2 += 0.1;
      y = y + (int) ((Math.sin(counter2) + Math.cos(counter2)) * 5);
      fish = fish + (int) ((Math.sin(counter2) + Math.cos(counter2)) * 5);
      if (counter2 >= 7) {
        counter2 = 4;
      }
      image(Fabroa[3],x,y-10);
      image(Aeugh,puffer,fish-10,40,40);
    }
    //walk right
    else if (DTap) {
      if (spriteNum == 1) {
      image(Fabroa[1],x++,y);
      image(Aeugh,puffer++,fish,40,40);
      }
      if (spriteNum == 2) {
      image(Fabroa[2],x++,y);
      image(Aeugh,puffer++,fish,40,40);
      }
    }
    //walk left
    else if (ATap) {
      if (spriteNum == 1) {
      image(Fabroa[5],x--,y);
      image(Aeugh,puffer--,fish,40,40);
      }
      if (spriteNum == 2) {
      image(Fabroa[6],x--,y);
      image(Aeugh,puffer--,fish,40,40);
      }
    }
    else {
    image(Fabroa[0],x,y);
    image(Aeugh,puffer,fish,40,40);
    }

    //Helps with Walking Animation
    spriteCounter++;
      if (spriteCounter == 12) {
        spriteCounter = 0;
        if (spriteNum == 1) {
          spriteNum = 2;
        }
        else if (spriteNum == 2) {
          spriteNum = 1;
        }
      }

}
    
  //Other Method Types

    public void keyPressed() {
      //WASD + Arrow Key Controls
      if (key == 'w') {
        WTap = true;

      }
      else if (key == 'd') {
        DTap = true;

      }
      else if (key == 'a') {
        ATap = true;
        
      }
      if (keyCode == UP) {
        WTap = true;

      }
      else if (keyCode == DOWN) {
        STap = true;

      }
      else if (keyCode == RIGHT) {
        DTap = true;

      }
      else if (keyCode == LEFT) {
        ATap = true;
        
      }
    }

    public void keyReleased() {
      if (key == 'w') {
        WTap = false;
        counter2 = 4;

      }
      else if (key == 's') {
        STap = false;

      }

      else if (key == 'd') {
        DTap = false;

      }
      else if (key == 'a') {
        ATap = false;
        
      }
      if (keyCode == UP) {
        WTap = false;
        counter2 = 4;

      }
      else if (keyCode == RIGHT) {
        DTap = false;

      }
      else if (keyCode == LEFT) {
        ATap = false;
        
      }
    }
  
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public int counter;
    public double counter2 = 4;

    public class Boss() {
      
      protected int health;
      protected int Maxhealth;
      protected boolean dead;
      protected int damage;

      protected boolean flinching;
      protected long flinchTimer;

      public Boss(TileMap tm) {
        super(tm);

      }

      public boolean Boss() { 
        return dead; 
        } 

      public int getDamage() { 
        return damage; 
        }

      public void hit (int damage) {
        if (dead || flinching) {
          return;
          health -= damage;

        }

        if (health < 0) {
          health = 0;

        }

        if (health == 0) {
          dead = true;
          flinching = true;
          flinchTimer = System.nanoTime();

        }

      }
  

      public class Eric extends Boss {
        
        public Eric(TileMap tm) {
          super(tm);

          int moveSpeed = 10;
          int maxSpeed = 10;
          int fallspeed = 10;

          health = maxHealth = -10;

        }

      }

    }

}