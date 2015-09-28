
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
    private int destination;
    private int inTime;
    private int outTime;
    private int source;

    public void setInTime(int inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getInTime() {
        return inTime;
    }

    public int getOutTime() {
        return outTime;
    }

    public int getSource() {
        return source;
    }
    

    /**
     * Creates a Person 
     * @param floor the destination destination for the Person 
     * @param inTick 
     * @throws ElevatorProject.InvalidLocationException 
     */
    public Person(int floor, int inTick) throws InvalidLocationException{
        if(floor <=0)
            throw new InvalidLocationException();

        this.destination=floor;
        this.inTime = inTick; 
    }

    /**
     * Constructor for coping a person Tested and Proven.
     * @param o the Person to be copied
     */
    public Person(Person o){
        destination=o.getDestination();
    }

    /**
     * Retrieves the destination the person wants to get off on. Tested and Proven.
     * @return int
     */
    public int getDestination(){
        return destination;
    }

    /**
     * Sets the Floor number the person will travel to. Tested and proven.
     * @param destination the int for the destination the person would like to get off on
     */
    public void setDestination(int destination){
        this.destination=destination;
    }
    
    //Tested and Proven
    @Override
    public int compareTo(Object o) {
        if(((Person)o).destination < this.destination)
            return 1;
        if(((Person)o).destination > this.destination)
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
        return destination+", "+inTime +", " + outTime;
    }
}
