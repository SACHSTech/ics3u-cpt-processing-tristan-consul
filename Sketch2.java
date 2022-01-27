import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Sketch2 extends PApplet {
	
	public boolean keyUp, keyDown, keyRight, keyLeft;
  World world;
  int gameState;
  int tileSize;
  Button resetButton;






  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  
  
  public void setup() {
    background(210, 255, 173);
    tileSize = 40;
    gameState = 0;
    world = new World(20, 20, worldField);
    resetButton = new Button(loadImage("Images/Restart.png"), width/2 - 80, height/2 + 50);
    frameRate(60);

  
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
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
   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 4, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 1}, 
   {1, 7, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 7, 0, 0, 0, 0, 1}, 
   {1, 0, 2, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
   {1, 0, 0, 2, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 0, 1}, 
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
  
  

  public void keyPressed() {
    if (key == CODED) {
       if (keyCode == UP) {
       keyUp = true;
     }
     if (keyCode == DOWN) {
       keyDown = true;
     }
     if (keyCode == LEFT) {
       keyLeft = true;
     }
     if (keyCode == RIGHT) {
       keyRight = true;
     }
   }
  }

  public void keyReleased() {
    if (key == CODED) {
     if (keyCode == UP) {
      keyUp = false;
    }
    if (keyCode == DOWN) {
      keyDown = false;
    }
    if (keyCode == LEFT) {
      keyLeft = false;
    }
    if (keyCode == RIGHT) {
      keyRight = false;
    }
   }
   }
  
  

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
    /*
    
   PImage mirrorX(PImage src) {
     PImage dst = createImage(src.width, src.height, ARGB);
     src.loadPixels();
     dst.loadPixels();
    for(int y = 0; y < src.height; y++ ) {
      for(int x = 0; x < src.width; x++ ) {
      dst.pixels[y*src.width+x] = src.pixels[y*src.width+src.width-x-1];      
       }
     }  
     dst.updatePixels();
     return(dst);
   } 
   
    

    class player {
      PImage[] imgs_right;
      PImage[] imgs_left;

      PImage image;
      Rect r;
      float vel_y = 0;
      boolean jumped = false;
      int counter = 0;
      int index = 0;
      int direction = 1;
      boolean dead = false;
      boolean rising = false;

      player(float x, float y) {
        imgs_left = new PImage[7];
        imgs_right = new PImage[7];
        for(int i = 1; i < 4; i++) {
          imgs_right[n-1] = loadImage("Images/Mr_Fabroa.png");
          imgs_left[i-1] = mirrorX(imgs_right[i-1]);
        }
        image = imgs_right[index];
        r = new Rect(x, y, 30, 60);

      }

      public void update() {
        float dx = 0;
        float dy = 0;
        float step = 6;
        boolean flip = false;
        int walk_cooldown = 5;

        if(gameState != 1) {
          if(keyUp && !jumped) {
            vel_y = -15;
            jumped = true;            


          }
          if(keyLeft) {
            if(direction == 1) {
              flip = true;
            }
            direction = -1;
            counter += 1;
            dx += step;

          }
          if(!(keyRight ^ keyLeft) || flip) {
            counter = 0;
            index = 0;


          }
          if(counter > walk_cooldown) {
            counter = 0;
            index += 1;

            if(index >= imgs_right.length) {
              index = 0;
            }
          }
          image = ((direction == 1)?imgs_right:imgs_left)[index];
          vel_y = 1;
          vel_y = (vel_y > 10)?10:vel_y;
          dy += vel_y;

          jumped = true;
          for(Platforms platforms: world.platforms) {
            Rect tempr;
            tempr = new Rect(r.x+dx, r.y, r.width, r.length);
            if(platforms.r.isCollide(tempr)) {
              dx = 0;
            }
            tempr = new Rect(r.x, r.y+dy, r.width, r.height);
            if(platforms.r.isCollide(tempr)) {
              if(abs((r.y+r.height+dy) - (platforms.r.y + platforms.r.height)) < 20 ) {
                dy = (platforms.r.y + platforms.r.height) - r.y;
                vel_y = 0;
              }
              if (abs((r.y+r.height+dy)-platforms.r.y) < 20) {
               dy = 0;
               r.y = platforms.r.y-r.height; 
               jumped = false;
              }
           
            }

          }
          */
          
    
        





        

      }
      



    

    


    

    

    






  

    

    
   
   


 
 

 // define other methods down here.

