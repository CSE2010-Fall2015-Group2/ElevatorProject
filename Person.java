
package ElevatorProject;

/** 
 * A person object for use with elevator operation an simulation 
 */

/**
 * Group 2 - Nicholas Persing, Christopher Millsap, JulioVillazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 */

/**
 * 
 * @author Group 2 - Nicholas Persing, Christopher Millsap, JulioVillazon
 */

//Can each of these report their own statistics to a file?

public class Person implements Comparable{
    private int destinationFloor;
    private int inTime;
    private int outTime;
    private int sourceFloor;

    public void setInTime(int inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getInTime() {
        return inTime;
    }

    public int getOutTime() {
        return outTime;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }
    

    /**
     * Creates a Person 
     * @param floor the destinationFloor destinationFloor for the Person 
     * @param inTick 
     * @throws ElevatorProject.InvalidLocationException 
     */
    public Person(int floor, int inTick) throws InvalidLocationException{
        if(floor <=0)
            throw new InvalidLocationException();

        this.destinationFloor=floor;
        this.inTime = inTick; 
    }

    /**
     * Constructor for coping a person Tested and Proven.
     * @param o the Person to be copied
     */
    public Person(Person o){
        destinationFloor=o.getDestinationFloor();
    }

    /**
     * Retrieves the destinationFloor the person wants to get off on. Tested and Proven.
     * @return int
     */
    public int getDestinationFloor(){
        return destinationFloor;
    }

    /**
     * Sets the Floor number the person will travel to. Tested and proven.
     * @param destinationFloor the int for the destinationFloor the person would like to get off on
     */
    public void setDestinationFloor(int destinationFloor){
        this.destinationFloor=destinationFloor;
    }
    
    //Tested and Proven
    @Override
    public int compareTo(Object o) {
        if(((Person)o).destinationFloor < this.destinationFloor)
            return 1;
        if(((Person)o).destinationFloor > this.destinationFloor)
            return -1;
        return 0;
    }
    
    /**TODO: Implement and test
     * Sends a "this" person to Report.java to be added to bufferQueue 
     * and eventually added to the output file.
     */
    public void report(){
        outTime = ElevatorControl.getTick();
        Report.addToReport(this);
    }
    
    //Tested and proven
    @Override
    public String toString(){
        return destinationFloor+", "+inTime +", " + outTime;
    }
}
