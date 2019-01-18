import processing.core.PApplet;
import processing.core.PImage;

public class Toucan extends CreatureWorldThing {
    //identifiers for behave class
    private int x;
    private int y;
    private PImage toucanImg;
    private int direction;

    public Toucan(int _id){
        super(_id, CreatureWorldApp.getApp().width/2+140,CreatureWorldApp.getApp().height/2+40, 1);
        toucanImg = app.loadImage("data/Toucan.png");
    }

    public void display(){
        PApplet app = CreatureWorldApp.getApp();

        app.image(toucanImg, getX(), getY(), 80, 80);

    }

    public void behave() {
        if(app.getMouseCounter() > 16){
            int oldX = getX();
            direction = 5;
            int newX = oldX + direction;
            setX(newX);
        }
        int oldY = getY();
        int direction = getDirection();
        int newY = oldY + direction;
        setY(newY);
        if (newY > app.height/2+40+7 || newY < app.height/2+40-10){
            //getting the new y position
            setDirection(-direction);
        }

    }

}