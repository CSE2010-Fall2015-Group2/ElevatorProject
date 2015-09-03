
package ElevatorProject;

/** 
 * A person object for use with elevator operation an simulation 
 */

/**
 * Group 1 - Nicholas Persing, Christopher Millsap, JulioVillazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 *
 * Created by: Nicholas Persing @ 8/31/2015 11:29
 *      -Basic structures, setters and getters
 * Edited by:
 */

/**
 * 
 * @author Group 1 - Nicholas Persing, Christopher Millsap, JulioVillazon
 */

//Can each of these report their own statistics to a file?

public class Person implements Comparable{
    private int floor;
    private int inTick;
    private int outTick;

    /**
     * Creates a Person 
     * @param floor the destination floor for the Person 
     * @param inTick 
     * @throws ElevatorProject.InvalidLocationException 
     */
    public Person(int floor, int inTick) throws InvalidLocationException{
        if(floor <=0)
            throw new InvalidLocationException();

        this.floor=floor;
        this.inTick = inTick; 
    }

    /**
     * Constructor for coping a person
     * @param o the Person to be copied
     */
    public Person(Person o){
        floor=o.getFloor();
    }

    /**
     * Retrieves the floor the person wants to get off on.
     * @return int
     */
    public int getFloor(){
        return floor;
    }

    /**
     * Sets the Floor number the person will travel to.
     * @param floor the int for the floor the person would like to get off on
     */
    public void setFloor(int floor){
        this.floor=floor;
    }
    
    @Override
    public int compareTo(Object o) {
        if(((Person)o).floor < this.floor)
            return 1;
        if(((Person)o).floor > this.floor)
            return -1;
        return 0;
    }
    
    public void report(){
        outTick = ElevatorControl.getTick();
    }
    
    public String toString(){
        return inTick +", " + outTick;
    }
}
