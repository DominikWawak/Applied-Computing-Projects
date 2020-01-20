public class Cloud {
  private float x1=-55;
  private float x2=-45;
  private float x3=-34;
  private float yCoord =150;

  private float speedX=random(5);



  Cloud() {
  }



  //
  //
  //

  public void drawCloud() {

    noStroke();
    fill(196, 175, 180, 160);
    ellipse(x1, yCoord, 30, 30);
    ellipse(x2, yCoord-10, 30, 30);
    ellipse(x3, yCoord-5, 30, 30);
  }
  public void updateCloud() {
    // making the clouds move

    x1+=speedX;
    x2+=speedX;
    x3+=speedX;
    if (x1>=675) {
      x1=-55;
      x2=-45;
      x3=-34;

      yCoord=random(height);
      if (yCoord>280)
        yCoord=260;
    }
  }

  private float getYCoord() {
    return yCoord;
  }
  private float getSpeedX() {
    return speedX;
  }
}
