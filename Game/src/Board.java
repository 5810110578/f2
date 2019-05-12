import java.awt.Point;
import java.util.HashMap;

public class Board {  
  private int finishPos;
  private HashMap<Integer, Integer> tunnels = new HashMap<>();

  public Board(int finishPos) {
    this.finishPos = finishPos;
    prepareTunnels();
  }

  public int getFinishPos() {
    return finishPos;
  }
  
  public Integer getTunnelOutPos(int pos){
    return tunnels.get(pos);
  }

  public Point getRefLocationForPos(int pos){
    //800*500
    int row = ((pos - 1) / 10);
    int x;    
    if(row % 2 == 1){
      x = 82 * ((pos - 1) % 10);
    }else{
      x = 820 - ((pos - (row * 10)) * 82);
    }
    return new Point(x,  448 - (row * 64));
  }

  private void prepareTunnels(){
    
    tunnels.put(25, 5);
    tunnels.put(5, 25);
    tunnels.put(48, 66);
    tunnels.put(66, 48);
    tunnels.put(9, 32);
    tunnels.put(79, 39);
    tunnels.put(36, 7);
    tunnels.put(38, 23);
    tunnels.put(53, 73);
    tunnels.put(34, 45);
    tunnels.put(49, 30);
    tunnels.put(37, 64);
    tunnels.put(21, 3);
    tunnels.put(74, 46);
    tunnels.put(16, 28);
    //snack
    tunnels.put(4, 1);
    tunnels.put(77, 63);
    //Ghost
    tunnels.put(41, 42);
    tunnels.put(51, 52);
    //Fire
    tunnels.put(10, 6);
    tunnels.put(40, 35);
    tunnels.put(55, 50);
    tunnels.put(71, 68);
    //gold
    tunnels.put(2, 3);
    tunnels.put(31, 33);
    tunnels.put(43, 46);
    tunnels.put(76, 76);
    
  }

}