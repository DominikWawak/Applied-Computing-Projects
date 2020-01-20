import javax.swing.*;
private boolean keys, cert, degree, phd, home, houses, realEstate;

Player pl;
Menu mn;
World wo;
Office of;
School sc;
Shop sh;
Cloud clouds[];
void setup() {
  size(600, 400);
  noCursor();
  pl = new Player();
  mn = new Menu();
  wo = new World();
  of = new Office();
  sc = new School();
  sh = new Shop();
  clouds = new Cloud[3];
  for (int i = 0; i<clouds.length; i++) {
    clouds[i]= new Cloud();
  }
  // Instructions and player name
  mn.playerNick(JOptionPane.showInputDialog("Welcome \n In this game you have to become a millionare"
    +"\nyou start with $0 and you make your way up \n you can work , get education and invest. "
    +"\n move with w a s d keys on your keyboard. \n good luck have fun. Enter your player nick "));
}


void draw() {
  background(  80, 137, 20);
  wo.worldMap();
  if (home==true)
    wo.home();
  if (houses==true)
    wo.houses();
  mn.outline();
  move();
  pl.drawPlayer();
  mn.info(mn.getNick(), pl.getIncome(), pl.getEnergy(), 16);
  gameOver();

  // Array for drawing clouds
  for (int i = 0; i<clouds.length; i++) {
    clouds[i].updateCloud();
    clouds[i].drawCloud();
  }
}





public void move() {
  int xChange = 0; //Change in x and change in y amount that player moves
  int yChange= 0;
  if (keys == true) {
    if (key=='w') {  
      yChange--;
    }
    if (key=='s') {
      yChange++;
    }
    if (key=='a') {
      xChange--;
    }
    if (key=='d') {
      xChange++;
    }
  }

  //Player needs to know the direction
  pl.updatePlayer(xChange, yChange);
}


public void keyPressed() {
  //listening for player movement
  keys=true;
  //listening for player location
  functions(pl.getX(), pl.getY());
}

public void keyReleased() {
  keys=false;
}



public void advance() {
  if (cert == true)
    of.setWage(100);
  else if (degree == true)
    of.setWage(500);
  else if (phd == true)
    of.setWage(1000);
  if (realEstate == true)
    of.setWage(10000);
}


//                                      //
//Functions of buildings with validation//
//                                     //


private void functions(float x, float y) {

  //          //
  //The school//
  //          //

  if (pl.functionSchool(x, y) && key=='1'&& (pl.getIncome()>= sc.getQualif(0))) {
    cert=true;
    if (pl.reduceIncome(sc.getQualif(0)))
      if (pl.reduceEnergy(pl.getEnergy()));
  }
  if (pl.functionSchool(x, y) && key=='2'&& (pl.getIncome()>= sc.getQualif(1))) {
    degree=true;
    if (pl.reduceIncome(sc.getQualif(1)))
      if (pl.reduceEnergy(pl.getEnergy()));
  }
  if (pl.functionSchool(x, y) && key=='3' && (pl.getIncome()>= sc.getQualif(2))) {
    phd=true;
    if (pl.reduceIncome(sc.getQualif(2)))
      if (pl.reduceEnergy(pl.getEnergy()));
  }

  //          //
  //The office//
  //          //

  if (pl.functionOffice(x, y)  && keyCode==ENTER) {
    advance();
    if (pl.increaseIncome(of.getWage()))

      if (pl.reduceEnergy(pl.getEnergy()));
  }

  //           //
  // The shop  //
  //           //

  if (pl.functionShop(x, y)  && key=='1' ) {

    if (pl.reduceIncome(sh.getCostOfEnergy()))
      if (pl.increaseEnergy(sh.getEnergyIncrease()));
  }
  if (pl.functionShop(x, y)  && key=='2' && pl.getIncome()>=sh.getCostOfHouse()) {
    home=true;
    if (pl.reduceIncome(sh.getCostOfHouse()))
      if (pl.reduceEnergy(pl.getEnergy())); ////why the semi colon////////////////////////////////
  }
  if (pl.functionShop(x, y)  && key=='3' && pl.getIncome()>=sh.getCostOfHouses()) {
    houses = true;
    realEstate = true;
    if (pl.reduceIncome(sh.getCostOfHouse()))
      if (pl.reduceEnergy(pl.getEnergy())); ////why the semi colon
  }

  //           //
  //    Home   //
  //           //

  if (pl.functionHome(x, y) && keyCode== ENTER) {
    if (pl.increaseEnergy(10));
  }
}
//
// End of game
//
public void gameOver() {
  if (pl.getIncome()>=1000000) {
    JOptionPane.showMessageDialog(null, "Congratulations ! "+ mn.getNick()+" you became a millionare in " +
      mn.getCounter()+" minutes \n this is your new high score \n try beat it!"
      );
    exit();
  }
}
public boolean getHome() {
  return home;
}
