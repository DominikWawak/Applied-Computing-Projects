public class  Menu {
  private String playerNick;





 public void outline() {
    fill(255);
    rect(0, 280, 600, 10);
    rect(0, 390, 600, 10);
    //aqua blue hud background
    fill(143,252,255);
    rect(0,293,600,100);
  }
  
  
   public String playerNick(String playerNick){
     if(playerNick.length()<=6){
     return this.playerNick = playerNick;}
     else{
       return this.playerNick = playerNick.trim().substring(0,6);
     }
    
  }

  public void info(String playerNick, int income, int energy, int textSize) {
    fill(0);
    textSize(textSize);
    text("Name = " + playerNick, 8, 310);
    text("Income = $" + income, 8, 330);
    text("Energy = " + energy, 8, 350);
    counter();
  }
 
  
  public void info(String playerNick, int income, int energy) {
    fill(0);
    text("Name = " + playerNick, 8, 310);
    text("Income = $" + income, 8, 330);
    text("Energy = " + energy, 8, 350);
    counter();
  }

  public float counter() {
    return  millis();
  }


  public String getNick() {
    return playerNick;
  }

  
  public float getCounter() {
    //converting milis into minutes
    return counter()/60000;
  }
}
