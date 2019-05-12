public class Dice {
  private int face;

  public void roll() {//randomnumber
    face = (int) (Math.random() * 6) ;
  }

  public int getFace() {
    return face;
  }
}