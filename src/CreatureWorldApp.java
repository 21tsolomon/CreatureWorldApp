import processing.core.PApplet;

import java.util.ArrayList;


public class CreatureWorldApp extends PApplet {
    //static because you have a bunch of different instantiations and they share some common data
    //making this static as a redundancy to say that there is only one PApplet, but gives access to other tabs
    //when they need it
    private static CreatureWorldApp app;
    private int mouseCounter = 0;
    private ArrayList<CreatureWorldThing> things;

    public static void main(String[] args) {

        PApplet.main("CreatureWorldApp");
    }

    public CreatureWorldApp(){
        //helps the program starts up
        app = this; //using this in this program will refer to the object app
    }

    public void settings() {
        size(500, 500);
    }

    public void setup(){

        //allocating array
        things = new ArrayList<CreatureWorldThing>();
        //stuffing the array
        things.add(new Banana(0));
        things.add(new Monkey(1));
        things.add(new Tree(2));
        things.add(new Toucan(3));
        //"1" represents the direction

    }

    public void draw(){
        background(0, 163, 19);
        for (int i = 0; i < things.size(); i++){
            things.get(i).display();
            things.get(i).behave();
            things.get(i).interact(things);
            //getting the object at that position in the things array
            //and then you call a method on it
            //conveys the sense that these are abstractions of things that are real in the world



        }
    }

    public void mouseClicked(){
        for (int i = 0; i < things.size(); i++){
            things.get(i).handleClick(mouseX, mouseY);
        }

        things.add(new Banana(0));
        mouseCounter++;

        //things.add(new Monkey(1));
    }

    public void keyPressed(){
        things.add(new Banana(0));
    }

    public void kill(CreatureWorldThing thing){

            things.remove(thing);



    }


    public static CreatureWorldApp getApp() {
        return app;
    }

    public int getMouseCounter(){
        return mouseCounter;
    }

    public CreatureWorldThing getThing(int index){
        return things.get(index);
    }
}
