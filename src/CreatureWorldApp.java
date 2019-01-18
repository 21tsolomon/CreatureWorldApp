import processing.core.PApplet;

public class CreatureWorldApp extends PApplet {
    //static because you have a bunch of different instantiations and they share some common data
    //making this static as a redundancy to say that there is only one PApplet, but gives access to other tabs
    //when they need it
    private static CreatureWorldApp app;
    private int mouseCounter = 0;
    CreatureWorldThing[] things;

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
        things = new CreatureWorldThing[4];
        //stuffing the array
        things[1] = new Banana(1);
        things[0] = new Monkey(0);
        things[2] = new Tree(2);
        things[3] = new Toucan(3);
        //"1" represents the direction

    }

    public void draw(){
        background(0, 163, 19);
        for (int i = 0; i < things.length; i++){
            things[i].display();
            //getting the object at that position in the things array
            //and then you call a method on it
            //conveys the sense that these are abstractions of things that are real in the world
            things[i].behave();
            things[i].interact(things);

        }
    }

    public void mouseClicked(){
        for (int i = 0; i < things.length; i++){
            things[i].handleClick(mouseX, mouseY);
        }
        mouseCounter++;
    }

    public static CreatureWorldApp getApp() {
        return app;
    }

    public int getMouseCounter(){
        return mouseCounter;
    }

    public CreatureWorldThing getThing(int index){
        return things[index];
    }
}
