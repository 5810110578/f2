public class ClockTest{
    public static void main(String args[]){
        Clock c = new Clock(12,35);
        c.pressCenter(true);
        c.presstip();
        c.pressCenter(false);
        c.presstip(); c.presstip();
        c.presstip(); c.presstip();
        c.presstip(); c.pressCenter(true);
    }
}