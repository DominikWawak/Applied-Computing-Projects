public class Player {
  private float x, y;
  private PImage spriteSheet;
  private PImage [][] movements;
  private boolean inMotion;
  private int currentDirection;
  private float currentFrame;
  private int income =100000;
  private int energy = 100;




  //can't be changed once declared, Constant Values
  //set the direction the sptrite is facing on the sheet, ie row .
  private final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

  //constructor

  Player() {
    //checks if player is moving
    inMotion = false;
    //character starts of facing left
    currentDirection =2;
    currentFrame = 0;
    //starting location
    x=300;
    y=130;
    setupSprites();
  }

  public void setupSprites() {
    movements = new PImage [4][3];// array for 4 rows and 3 columns
    spriteSheet = loadImage("mysprite.png");
    // Cutting out each figure from the array
    for (int i = 0; i < 3; i++) {
      movements[0][i] = spriteSheet.get(6+32*i, 2, 18, 31);
      movements[1][i] = spriteSheet.get(6+32*i, 35, 18, 31);
      movements[2][i] = spriteSheet.get(6+32*i, 68, 18, 31);
      movements[3][i] = spriteSheet.get(6+32*i, 100, 18, 31);
    }
  }

  public void drawPlayer() {

    if (inMotion) {

      image(movements[currentDirection][1 + int(currentFrame)], x, y);
    } else {
      image(movements[currentDirection][0], x, y);
    }
  }
  public void updatePlayer(int xChange, int yChange) {

    //the current frame starts at 0 then 0.1 is added.
    //its turned into a int therefore rounded up or down.
    //thats how it switches between cut outs
    currentFrame=(currentFrame + 0.1)%2; 
    inMotion = true;
    if (xChange==0 && yChange ==0) {
      inMotion = false;
    } else if (xChange == -1) {
      currentDirection = LEFT;
    } else if (xChange == 1) {
      currentDirection = RIGHT;
    } else if (yChange == -1) {
      currentDirection = UP;
    } else if (yChange == 1) {
      currentDirection = DOWN;
    }
    //moving the sprite
    x = x + xChange ;
    y = y + yChange ;

    if ((playerBoundary(x, y)) ||(playerBoundaryShop(x, y)) ||(playerBoundaryOffice(x, y)) ||(playerBoundarySchool(x, y)) 
      || (playerBoundaryGate(x, y))) {
      x=x-xChange;
      y=y-yChange;
    }

    //boundary when house is bought
    //
    //
    if (getHome()==true && (x>227) && (y>14) && (x<362 ) && (y<120)) {
      x=x-xChange;
      y=y-yChange;
    }

    if (functionSchool(x, y)) {
      fill(0);
      text("Press 1 to buy a cert for $500", 200, 320);
      text("Press 2 to buy a Degree for $5000 ", 200, 340);
      text("Press 3 to buy a PHD for $50k ", 200, 360);
      text("Tip the bigger the degree the more you will earn! ", 200, 380);
    }


    if (functionOffice(x, y)) {

      fill(0);
      text("Press Enter To Earn Money", 200, 350);
    }

    if (functionShop(x, y)) {
      fill(0);
      text("Press 1 to buy Energy for $10", 200, 310);
      text("Press 2 to buy a house for $10k", 200, 325);
      text("Press 3 to invest in a real estate house for $300k", 200, 340);
    }
    if (functionHome(x, y)) {
      fill(0);
      text("Press ENTER to rest", 200, 350);
    }
  }


  //               //
  // bounrdaries  //
  //             //

  public boolean playerBoundary(float x, float y) {
    if (((x < 0) ||(x> width -18)) || ((y < 0)||(y>250))) {
      return true;
    } else {
      return false;
    }
  }
  public boolean playerBoundarySchool(float x, float y) {
    if (((x) < 168) &&(x> 19 -18) && ((y < 90)&&(y>-10))) {
      return true;
    } else {
      return false;
    }
  }

  public boolean playerBoundaryShop(float x, float y) {
    if (((x < 516) &&(x> 419 -18)) && ((y < 220)&&(y>131))) {
      return true;
    } else {
      return false;
    }
  } 
  public boolean playerBoundaryOffice(float x, float y) {
    if (((x <557  ) &&(x> 478-18)) && ((y < 75)&&(y>-17))) {
      return true;
    } else {
      return false;
    }
  }
  public boolean playerBoundaryGate(float x, float y) {
    if (((x <280  ) &&(x> 0)) && ((y < 280)&&(y>149))) {
      return true;
    } else {
      return false;
    }
  }

  public boolean functionOffice(float x, float y) {
    if (((x < 540  ) &&(x > 503-18)) && ((y < 111)&&(y > 52))) {
      return true;
    } else {
      return false;
    }
  }
  public boolean functionShop(float x, float y) {
    if (((x < 478) &&(x> 422)) && ((y < 273)&&(y>209))) {
      return true;
    } else {
      return false;
    }
  }

  public boolean functionHome(float x, float y) {
    if (getHome()==true && (x < 294) && ( x>267) && (y<142) && (y>99) ) {
      return true;
    } else {
      return false;
    }
  }
  public boolean functionSchool(float x, float y) {
    if (((x <60  ) &&(x> 37 -18)) && ((y < 118)&&(y>66))) {
      return true;
    } else {
      return false;
    }
  }


  //
  //
  //

  public boolean reduceIncome(int amount) {
    if ((income - amount) >= 0) {

      income -= amount;

      return true;
    } else return false;
  }
  public boolean reduceEnergy(int amount) { 
    if ((energy - amount) >= 0) {
      energy -= 10;
      if (energy<=0)
        energy=0;


      return true;
    } else return false;
  }
  public boolean increaseEnergy(int amount) {
    if ((energy + amount) >= 0 ) {


      energy += amount;
      return true;
    } else return false;
  }
  public boolean increaseIncome(int amount) {
    if ((income + amount) >= 0 && energy > 0) {

      income += amount;

      return true;
    } else return false;
  }  


  //                                             //
  // All mutators are programatically controlled//
  //                                           //

  public void setIncome(int income) {
    this.income=income;
  }
  public int getIncome() {
    return income;
  }
  public void setEnergy(int energy) {
    this.energy=energy;
  }
  public int getEnergy() {
    return energy;
  }
  public float getX() {
    return x;
  }
  public float getY() {
    return y;
  }
}
