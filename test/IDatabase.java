import sun.*; 
import java.*;
import java.util.Scanner;
import javax.*;

public class IDatabase {
   static AudioStream as;
   IDatabase() {
      try {
         InputStream in = new FileInputStream("test/justified.wav"); 
         as = new AudioStream(in);
         AudioPlayer.player.start(as); 
      } catch (IOException e) {

      }

   }

   public static void main(String args[]) {
      new IDatabase();
      Scanner a = new Scanner(System.in);
                
      if(a.nextInt()==1){ 
         stopMusic();
      }
   }
   
   public static void stopMusic(){
      AudioPlayer.player.stop(as);
   }

};