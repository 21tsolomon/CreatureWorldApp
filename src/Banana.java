import processing.core.PApplet;
import processing.core.PImage;

public class Banana extends CreatureWorldThing {
    private boolean bananaImage;
    public Banana(int _id){
        super(_id,  CreatureWorldApp.getApp().width/2,  CreatureWorldApp.getApp().height/2+82, 1);
        bananaImage = false;
    }

    int delay;

    public void display(){
        //use class name to call a public static method, not this because it would refer to a specific instance of the class
        PApplet app = CreatureWorldApp.getApp();
        if (bananaImage == true){
            PImage img;
            img = app.loadImage("data/Banana.png");
            app.image(img, getX(), getY(), 50, 50);
            delay1();
        }
    }
    public void handleClick(int x, int y){
        bananaImage = true;
        delay = 10;

    }
    public void behave() {
        int oldX = getX();
        int direction = getDirection();
        int newX = oldX + direction;
        //getting the new x position
        setX(newX);
        if (newX > app.width/2+35 || newX < app.width/2-125){
            setDirection(-direction);
        }
    }

    public void interact(CreatureWorldThing[] things){
        for (int i = 0; i < things.length; i++){
            //comparing two different objects here

        }
    }

    private void delay1(){
        if(delay > 0){
            delay--;
        }
        if (delay == 0){
            bananaImage = false;
        }
    }
}
