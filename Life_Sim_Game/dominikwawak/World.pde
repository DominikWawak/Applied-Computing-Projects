public class World {

  private PImage background;
  private PImage home;
  private PImage house [] = new PImage[3];





  //
  //Main world map 
  //
  public void worldMap() {
    background = loadImage("pixi.png");
    image(background, 0, 0);
  }
  //
  // The house Image
  //
  public void home() {
    home= loadImage("home.png");
    image(home, 0, 0);
  }
  //
  //An array for drawing the houses
  //
  public void houses() {
    PImage houseImg = loadImage("house.png");
    for (int i = 0; i<3; i++) {
      house[i]= houseImg;
      image(house[i], -40+(i*60), 0);
    }
  }
} 
