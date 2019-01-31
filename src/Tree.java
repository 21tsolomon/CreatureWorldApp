import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class Tree extends CreatureWorldThing {
    private int rectY = CreatureWorldApp.getApp().height/2+125;
    private int rect2Y = CreatureWorldApp.getApp().height/2+60;
    private PImage treeImg;

    //the constructor which should have the same name as the class
    public Tree(int _id){
        //how you get to the constructor for the parent class = super
        //first thing in the constructor if their is a parent class
        super(_id, CreatureWorldApp.getApp().width*3/4, CreatureWorldApp.getApp().height/2, 1);
        treeImg = CreatureWorldApp.getApp().loadImage("data/Tree.png");
    }

    public void display(){
        PApplet app = CreatureWorldApp.getApp();
        app.imageMode(CreatureWorldApp.getApp().CENTER);

        //TREE 1
        app.image(treeImg, getX(), getY(), 200, 400);

        //branch 1
        app.noStroke();
        app.fill(126,61,22);
        app.rect(app.width/2+25,app.height/2+125, 70, 10);

        //branch 2
        app.rect(app.width/2+95,rect2Y, 70, 10);

        //TREE 2
        app.image(treeImg, getX()/3, getY(), 200, 400);

        //branch 1
        app.noStroke();
        app.fill(126,61,22);
        app.rect(app.width/2-150,rectY, 70, 10);

    }

    public void behave() {
        if(app.getMouseCounter() > 8 && app.getMouseCounter() < 14 && app.getThing(0).getX() > CreatureWorldApp.getApp().width/2-150 && app.getThing(0).getX() < CreatureWorldApp.getApp().width/2-150+70){
            rectY = rectY + 10;
        }
        else if(app.getMouseCounter() > 16){
            rect2Y = rect2Y + 10;
        }

    }


    public void interact(ArrayList<CreatureWorldThing> things){
    }

}