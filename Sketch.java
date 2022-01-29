import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Sketch extends PApplet {
	
  public void settings() {
	// put your size call here
    size(800, 800);
  }

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
    tileSize = 40;
    gameState = 0;
    world = new World(20, 20, worldField);
    resetButton = new Button(loadImage("Images/Restart.png"), width/2 - 80, height/2 + 50);
    frameRate(60);

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

    if (gameState == 2) {
      background(230);
      fill(0,102,144);
      textSize(60);
      text("You Win!", 250, 350);
      resetButton.update();
      if (resetButton.clicked) {
       setup();
     }
     resetButton.display();
    }

    else if((gameState == 1)) {
      background (230);
      fill(0,102,144);
      textSize(60);
      text("You Lost :)", 250, 350);
      if (resetButton.clicked) {
        setup();
      }
     resetButton.display();

    }  
    else {
    background(230);
    world.update();
    world.display();
 
    }



}

int[][] worldField = {
   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1}, 
   {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 1}, 
   {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 3, 0, 1}, 
   {1, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 2, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 4, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 6, 0, 5, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 1}, 
   {1, 1, 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 7, 0, 0, 0, 0, 1}, 
   {1, 0, 1, 1, 0, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 2, 1, 1, 4, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 0, 0, 0, 0, 2, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 2, 2, 2, 2, 1}, 
   {1, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, 
   {1, 0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
   {1, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
   {1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
  }; 
  class Rect {
    float x,y,width,height;

    Rect(float xr, float yr, float widthr, float heightr) {
      x = xr;
      y = yr;
      width = widthr;
      height = heightr;
    }

    public boolean collide(Rect r) {

      return r.x < (x + width) && (r.x+r.width) > x && r.y < (y + height) && (r.y+r.height) > y;


    }

      
  }
   class Button {
    Rect r;
    PImage img;
    boolean clicked;
    boolean hover;

    Button(PImage timg, float tx, float ty) {
      img = timg;
      r = new Rect(tx, ty, img.width, img.height);
      clicked = false;
      hover = false;
    }
    public void display() {
      image(img, r.x, r.y);
    }
    public void update() {
      hover = mouseX >= r.x && mouseX < r.x + r.width && mouseY >= r.y && mouseY < r.y + r.width;
      clicked = hover && mousePressed && (mouseButton == LEFT);
    }

  }
  
  

 class Enemy1 {
   Rect r;
   PImage img;
   float counter = 0;
   float direction = 1; 
   float limit = 40;
   float step = 1;

   Enemy1(float x, float y) {
     img = loadImage("Images/Phone_Walking_1.png");

     r = new Rect(x, y, img.width, img.height);
    }

    public void update() {
      if(abs(counter) >= limit) {
        direction *= -1;
      }
      r.x += step * direction;
      counter += direction;

      }

    public void display() {
      image(img, r.x, r.y);
    }


    
  }

class Tile {
  
    Rect r;
    PImage img;
  
    Tile(PImage timg, float tx, float ty, float twidth, float theight) {
     img = timg;
     r = new Rect(tx, ty, twidth, theight);
   }
  
   void display() {
     image(img, r.x, r.y, r.width, r.height);
   }
 }



class World {
  ArrayList<Enemy1> enemy1;
  ArrayList<Platforms> platforms;
  ArrayList<Tile> tile;
  ArrayList<Exit> exits;
  World(int columns, int rows, int[][] data) {
    tile = new ArrayList<Tile>();
    platforms = new ArrayList<Platforms>();
    enemy1 = new ArrayList<Enemy1>();
    exits = new ArrayList<Exit>();

    PImage[] imgs = new PImage[1];
    imgs[0] = loadImage("Images/download.png");
      for(int i = 0; i < columns; i++) {
        for(int j = 0; i < rows; i++) {
          int val = data[j][i];

            if(val == 1|| val == 2) {
              Tile tempTile = new Tile(imgs[val-1],i*tileSize, j*tileSize, tileSize, tileSize);
             tile.add(tempTile);
            }
            if(val == 3) {
              Enemy1 tempEnemy1 = new Enemy1 (i*tileSize, j*tileSize + 5);
              enemy1.add(tempEnemy1);
            }
            if(val == 4) {
              Platforms tempPlatforms = new Platforms (i*tileSize, j*tileSize, 1, 0);
              platforms.add(tempPlatforms); 
            }
            if(val == 5) {
              Platforms tempPlatforms = new Platforms (i*tileSize, j*tileSize, 0, 1);
              platforms.add(tempPlatforms);

            }
            if(val == 6) {
              Exit tempExit = new Exit (i*tileSize, j*tileSize - tileSize/2);
              exits.add(tempExit);

            }


          }
        }

      }
      
      public void update() {
        
        for(Enemy1 enemy1: enemy1) {
          enemy1.update();

        }
        for(Platforms platforms: platforms) {
          platforms.update();
        }
        
      }
      
      public void display() {
        for(Tile tile: tile) {
          tile.display();
        }
        for(Enemy1 enemy1: enemy1) {
          enemy1.display();
        }
        
        platforms.forEach(platform -> platform.display());
          
        
       exits.forEach((exit) -> exit.display());

      }




    }

  class Platforms {
    float counter = 0;
    float direction = 1;
    float move_x;//platform x
    float move_y; //platform y
    PImage img;
    Rect r;

    Platforms(float px, float py, float pmove_x, float pmove_y) {
      img = loadImage("Images/download.png");
       r = new Rect(px, py, tileSize, tileSize/2);
 
      move_x = pmove_x;
      move_y = pmove_y;
    }



      public void update() {
        r.x += direction * move_x;
        r.y += direction * move_y;

        counter += 1;

        if(abs(counter) > 40) {
          direction *= -1;
          counter *= -1;
        }
      }

      public void display() {
        image (img, r.x, r.y, r.width, r.height);

      }

    }
     class Exit {
       Rect r;
       PImage img;

       Exit(float x, float y) {
         img = loadImage("Images/sas.png");

         r = new Rect (x, y, tileSize, tileSize*2);
       }
       public void display() {
         image(img, r.x, r.y, r.width, r.height);
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

}
  
  // define other methods down here.