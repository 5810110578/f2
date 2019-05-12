import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel implements GameSpriteListener{
  private GameController gc;
  private Graphics2D g2d;
  private BufferedImage bufferedImage;
  private Image backgrounImage;

  public BoardPanel(int w, int h){
    gc = GameController.getInstance();
    gc.addSpriteListener(this);
    
    
    bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    g2d = (Graphics2D) bufferedImage.getGraphics();
    
    try{
    
      backgrounImage = ImageIO.read(new File("src/boad.png"));    //colorbackground
      g2d.setBackground(Color.BLACK);
      g2d.drawImage(backgrounImage, 0, 0, null);
      

    }catch(Exception e){
      System.out.println("Background image not found.");
    }
   
    
  }

  public void spriteUpdated(){    
    redraw();
  }

  public void changeGamePlayEnabled(boolean enabled){
    //do nothing
  }

  public void redraw(){
    g2d.clearRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    g2d.drawImage(backgrounImage, 0, 0, null);
    g2d.setPaint(Color.red);
    g2d.drawLine(260,20,350,235);
    g2d.drawLine(330,230,350,235);
    g2d.drawLine(360,220,350,235);
    g2d.setPaint(Color.CYAN);
    g2d.drawLine(450,430,350,350);
    g2d.drawLine(200,330,350,350);
    g2d.drawLine(200,330,220,350);
    g2d.drawLine(200,330,220,320);
    
    for(Sprite sprite: gc.getSprites()){
      sprite.draw(g2d);
     
    }
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(bufferedImage, 0, 0, null);
  }
}