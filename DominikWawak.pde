/*
Name : Dominik Wawak
 Student Number: 20089042
 Programme Name: Rage Race
 
 Brief description of the animation achieved:
 This animation/game is a top down two player race game
 which is made especially to make you "Rage" at the game.
 I wanted to make sometheng that I would enjoy doing and have a challege at the same time.
 My inspiration would probably be a maze game and Mario Kart.
 
 Known bugs/problems:
 The round counter in the game will work both ways when you cross the finish line on either 
 making the game easy to cheated.
 The two players cannot move simultaneously making it a bug but also a more annoying feature
 of the game.
 
 Any sources referred to during the development of the assignment (no need to reference lecture/lab materials):
 I used the random function from the processing website https://processing.org/reference/random_.html 
 to make my obstacles and canvas change colour so I didn't have to look at the same colours every time.
 */
float circlePositionX = 950;
float circlePositionY = 200;
float circlePositionXx = 850;
float circlePositionYy = 200;
int speed = 7;
boolean player2 = true;
int roundCounter = 0;
int roundCounter2 = 0;
float rmColor = random(255);


void keyPressed() {      
  if (key=='2')
    player2=!player2;
}
void setup() {
  size(1000, 500);
}




void draw() {

  background(rmColor); //random colour
  fill(255);
  //finish line
  rect(800, 170, 200, 10);
  for (int i = 0; i <= 200; i = i+20) {
    for (int j = 10; j<=200; j= j + 20) {
      fill(255);
      rect(800+j, 190, 10, 10);
    }

    fill(255);
    rect(800+i, 180, 10, 10);
  }
  rect(800, 200, 200, 10);
  //Directional arrows
  for (int i=0; i<200; i=i+20) {
    for (float z = 0; z<170; z=z+20) {

      triangle(822.5+z, 273, 817.5+z, 260, 827.5+z, 260);
    }
    fill(0, 255, 255);
    rect(820+i, 220, 5, 40);
  }


  //player one
  fill(255, 0, 0);
  ellipse(circlePositionX, circlePositionY, 30, 30);

  //player 2
  if (!player2) {
    fill(0, 0, 255);
    ellipse(circlePositionXx, circlePositionYy, 30, 30);

    //movement for player 2
    if ((keyPressed)&&(key=='w')) {
      circlePositionYy = circlePositionYy - 1-speed;
    } else if  ((keyPressed)&&(key=='s')) {
      circlePositionYy = circlePositionYy + 1+speed;
    } else if ((keyPressed)&&(key=='a')) {
      circlePositionXx = circlePositionXx - 1-speed;
    } else if ((keyPressed)&&(key=='d')) {
      circlePositionXx = circlePositionXx + 1+speed;
    }
  }

  //movement Player 1
  if ((keyPressed)&&(keyCode==UP)) {
    circlePositionY = circlePositionY - 1-speed;
  } else if  ((keyPressed)&&(keyCode==DOWN)) {
    circlePositionY = circlePositionY + 1+speed;
  } else if ((keyPressed)&&(keyCode==LEFT)) {
    circlePositionX = circlePositionX - 1-speed;
  } else if ((keyPressed)&&(keyCode==RIGHT)) {
    circlePositionX = circlePositionX + 1+speed;
  }

  //collision with track player 1
  if (circlePositionX>=985)
    position(true);
  else if (circlePositionX<=15)
    position(true);
  else if (circlePositionY>=485)
    position(true);
  else if (circlePositionY<=15)
    position(true);

  //player 2
  if (circlePositionXx>=985)
    position(false);
  else if (circlePositionXx<=15)
    position(false);
  else if (circlePositionYy>=485)
    position(false);
  else if (circlePositionYy<=15)
    position(false);




  //collision with obstacles and big rectangle for player 1 and player 2
  checkCollision(circlePositionX, circlePositionY, true);
  //for palyer 2
  checkCollision(circlePositionXx, circlePositionYy, false);


  //obstacles
  fill(rmColor, 100, 50);
  //obstacle 1
  rect(340, 385, 10, 30);
  rect(275, 450, 10, 30);
  //obstacle 2
  rect(50, 450, 60, 10);
  rect(40, 375, 10, 85);
  //obstacle 3
  rect(65, 125, 10, 90);
  rect(140, 125, 10, 90);
  //obstacle1.1
  rect(940, 40, 10, 85);
  rect(880, 40, 60, 10);
  //obstacle 2.2
  rect(660, 85, 10, 30);
  rect(605, 20, 10, 30);
  //obstacle 3.3
  rect(860, 285, 10, 90);
  rect(935, 285, 10, 90);


  // big rectangle
  fill(0, 255, 0);
  rect(200, 150, 600, 200);


  //rectangle boundary graphical
  for (int x = 0; x<600; x=x+20) {
    for (int x1 = 10; x1<600; x1=x1+20) {
      fill(255);
      rect(200+x1, 150, 10, 10);
      rect(200+x1, 340, 10, 10);
    }
    fill(240, 0, 0);
    rect(200+x, 150, 10, 10);
    rect(200+x, 340, 10, 10);
  } 
  for (int y = 0; y<200; y=y+20) {
    for (int y1 = 10; y1<200; y1=y1+20) {
      fill(255);
      rect(200, 150+y1, 10, 10);
      rect(790, 150+y1, 10, 10);
    }
    fill(240, 0, 0);
    rect(200, 150+y, 10, 10);
    rect(790, 150+y, 10, 10);
  } 



  // finish line and round counter
  if ((circlePositionX > 800) && (circlePositionX < 1000) && (circlePositionY > 170) && (circlePositionY < 180)) {
    roundCounter = roundCounter + 1;
  }
  if ((circlePositionXx > 800) && (circlePositionXx < 1000) && (circlePositionYy > 170) && (circlePositionYy < 180)) {
    roundCounter2 = roundCounter2 + 1;
  }

  //round counter
  fill(255, 0, 0);
  rect(210, 290, 60, 50);
  fill(0, 0, 255);
  rect(730, 290, 60, 50);
  textAlign(RIGHT, TOP);
  textSize(24);
  fill(255);
  text(roundCounter+"/3", 260, 300);
  text(roundCounter2+"/3", 780, 300);

  if (roundCounter >=3) {
    fill(0);
    text("Game Over Player 1 wins", 650, 170);
    position(false);
    position(true);
  }
  if (roundCounter2 >=3) {
    fill(0);
    text("Game Over Player 2 wins", 650, 170);
    position(false);
    position(true);
  }



  //Menu
  textAlign(CENTER);
  textSize(22);
  fill(0);
  text("Welcome To Rage Race", width/2, height/2);
  text("Press 2 for two player mode", 500, 280);
  textSize(14);
  text("Player 1 controls = arrow keys | Player 2 controls = WASD keys", 500, 300);
  text("Be the first to compleate 3 rounds", 500, 320);
}//end of draw()
//position reset to the start line
void position(boolean player1) {
  if (player1 == true) {
    circlePositionX=950;
    circlePositionY=200;
  } else if (player1 == false) {
    circlePositionXx=850;
    circlePositionYy=200;
  }
}
//Collision Detection
void checkCollision(float x, float y, boolean player) {
  if ((x<=365) && (y <=430 ) && (x>=330) && (y>=375)) {
    position(player);
  }
  if ((x<=300) && (y <=495 ) && (x>=260) && (y>=435)) {
    position(player);
  }
  if ((x<=125) && (y <=475 ) && (x>=65) && (y>=435)) {
    position(player);
  }

  if ((x<=65) && (y<=475 ) && (x>=55) && (y>=360)) {
    position(player);
    ;
  }
  if ((x<=165) && (y <=230 ) && (x>=125) && (y>=110)) {
    position(player);
  }
  if ((x<=90) && (y <=230 ) && (x>=50) && (y>=110)) {
    position(player);
  }

  if ((x<=630) && (y<=65 ) && (x>=590) && (y>=5)) {
    position(player);
  }
  if ((x<=685) && (y<=130 ) && (x>=645) && (y>=70)) {
    position(player);
  }
  if ((x<=965) && (y <=140 ) && (x>=925) && (y>=25)) {
    position(player);
  }
  if ((x<=955) && (y<=65 ) && (x>=865) && (y>=25)) {
    position(player);
  }
  if ((x<=885) && (y<=390 ) && (x>=845) && (y>=270)) {
    position(player);
  }
  if ((x<=960) && (y<=390 ) && (x>=920) && (y>=270)) {
    position(player);
  }
  if ((x<=815) && (y <=365 ) && (x>=185) && (y>=135)) {
    position(player);
  }
}
