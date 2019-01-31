import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Monkey extends CreatureWorldThing {
    private int monkeyWidth = 100;
    private int monkeyHeight = 100;
    private PImage img;





    public Monkey(int _id){
        super(_id, CreatureWorldApp.getApp().width/2, CreatureWorldApp.getApp().height/2+82, 1);
        img = CreatureWorldApp.getApp().loadImage("data/Monkey.png");
    }


    //has to be public because it is coming from another tab
    public void display(){
        PApplet app = CreatureWorldApp.getApp();
        app.image(img, getX(), getY(), monkeyWidth, monkeyHeight);
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

    public void interact(ArrayList<CreatureWorldThing> things){
        if(things.size()-1 > 3) {
            if (monkeyHeight > 200) {
                app.kill(things.get(things.size() - 1));
            }
        }


    }
        /*for (int i = 0; i < things.size(); i++) {
            if (app.dist(things.get(i).getX(), things.get(i).getX(), getX(), getY()) < getMonkeyWidth() - 10){
                app.kill(things.get(i));
            }

        }

    }*/

    public int getMonkeyWidth(){
        return monkeyWidth;
    }


    public void handleClick(int x, int y){
        monkeyWidth = monkeyWidth + 2;
        monkeyHeight = monkeyHeight + 2;
    }

}