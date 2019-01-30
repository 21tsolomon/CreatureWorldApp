//design things based on what the objects are and what the essense is

import java.util.ArrayList;

//looks like a method but NO PARENTHESIS, but we will put methods inside
public class CreatureWorldThing {
    //our programs are required to have only private instance variables
    //so outside code cannot access other instance variables
    private int id;
    //individual identifiers for each of your objects
    private int x;
    private int y;
    private int direction;
    protected final CreatureWorldApp app = CreatureWorldApp.getApp();

    public CreatureWorldThing(int _id, int _x, int _y, int _direction){
        //place where you set up the initial state of all of the characteristics of your objects
        //some of them may be passed in and some of them may be calculated internally
        id = _id;
        //underscore is distinguishing the two of them
        x = _x;
        y = _y;
        direction = _direction;
        //will allow the creater to pass in, but the creature world will decide the color
    }
    public int getID(){
        return id;
    }

    public int getX(){
        return x;
    }
    //getter
    public void setX(int _x){
        x = _x;
    }
    //setter

    public int getY(){
        return y;
    }
    //getter
    public void setY(int _y){
        y = _y;
    }
    //setter

    public int getDirection(){
        return direction;
    }

    public void setDirection(int _d){
        direction = _d;
    }

    //has to be public because it is coming from another tab
    public void display(){

    }

    public void behave() {

    }

    public void interact(ArrayList<CreatureWorldThing> things){

    }

    public void handleClick(int x, int y){
    }

}