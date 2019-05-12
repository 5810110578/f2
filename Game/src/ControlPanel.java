import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;


public class ControlPanel extends JPanel implements GameControlListener{
  private GameController gc;
  private JButton playButton;
  private JLabel playerLabel;

  public ControlPanel(){
    gc = GameController.getInstance();
    gc.addControlListener(this);

    JButton exitButton = new JButton("Exit");//Buttonexit
    exitButton.setForeground ( Color.RED );
    exitButton.setBorder ( BorderFactory.createLineBorder ( Color.ORANGE, 4 ) );
    try{
      Font myFont = Font.createFont ( Font.TRUETYPE_FONT, new FileInputStream ( "src/BoyzRGrossNF.ttf" ) );	
      myFont = myFont.deriveFont ( Font.BOLD, 36f );	
      exitButton.setFont ( myFont );
      }
    catch ( Exception error ){
      }
    exitButton.addActionListener(new ActionListener(){    
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(1);
      }
    });

    playButton = new JButton("Play");//buttonplay
    
    playButton.setForeground ( Color.BLUE );
    playButton.setBorder ( BorderFactory.createLineBorder ( Color.ORANGE, 4 ) );
    try{
      Font myFont = Font.createFont ( Font.TRUETYPE_FONT, new FileInputStream ( "src/BoyzRGrossNF.ttf" ) );	
      myFont = myFont.deriveFont ( Font.BOLD, 36f );	
      playButton.setFont ( myFont );
      }
    catch ( Exception error ){
      }
    playButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        gc.takeTurn();
      }
    });

    playerLabel = new JLabel("", SwingConstants.CENTER);//showplayer
    playerLabel.setForeground ( Color.GRAY );
    //playerLabel.setFont(playerLabel.getFont().deriveFont(24.0f));
    playerLabel.setBorder ( BorderFactory.createLineBorder ( Color.ORANGE, 5 ) );
    try{
      Font myFont = Font.createFont ( Font.TRUETYPE_FONT, new FileInputStream ( "src/BoyzRGrossNF.ttf" ) );	
      myFont = myFont.deriveFont ( Font.BOLD, 36f );	
      playerLabel.setFont ( myFont );
      }
    catch ( Exception error ){
      }
    updatePlayerLabel();
    setLayout(new GridLayout(0, 1));
    add(exitButton);
    add(playerLabel);
    add(playButton);    
  }

  public void changeGamePlayEnabled(boolean enabled){
    playButton.setEnabled(enabled);
    updatePlayerLabel();
  }

  private void updatePlayerLabel(){//nameplay
    playerLabel.setText(gc.getCurrentPlayer().toString());
  }
}