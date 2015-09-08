package ElevatorProject;

import java.util.ArrayDeque;

/** 
 * Group 2 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
 */
public class FloorQueue {
    ArrayDeque<Person> upQueue, downQueue;
    int floor;
    
    /**
     * constructor for the FloorQueue
     * @param floor int the floor number this floor queue represents
     * @throws InvalidLocationException in the case that supplied int is an invalid floor number.
     */
    public FloorQueue(int floor) throws InvalidLocationException{
        upQueue = new ArrayDeque<Person>() {};
        downQueue = new ArrayDeque<Person>() {};
        
        if(floor <=0)
            throw new InvalidLocationException(
                    "Creating FloorQueue "+floor+": can't create a floor below zero.");
        
        this.floor = floor;
    }
    
    /**
     * Returns true if the sub queue for direction d is empty false other wise.
     * @param d Direction 
     * @return boolean true if sub queue is empty false otherwise.
     */
    public boolean isEmpty(Direction d){
        switch(d){
            case UP:
                return upQueue.isEmpty();
                
            case DOWN:
                return downQueue.isEmpty();
        }
        return true;
    }
    
    /**
     * Returns the entire FloorQueue
     * @return FloorQueue this
     */
    public FloorQueue retrieve(){
        return this;
    }
    
    /**
     * If there are any passengers in upQueue return true, false otherwise.
     * @return true if upQueue is not empty, false otherwise
     */
    public boolean isUpPressed(){
        return !upQueue.isEmpty();
    }
    
    /**
     * If there are any passengers in upQueue return true, false otherwise.
     * @return true if downQueue is not empty, false otherwise
     */
    public  boolean isDownPressed(){
        return !downQueue.isEmpty();
    }
   
    
    /**
     * TODO: Implement !!!!
     * adds a person to this floorQueue and sorts them into appropriate 
     * @param p the person to be added to this floor
     * @param d the difference between the floor created on and the destination floor (-)down (+)up can't be 0
     * @throws InvalidLocationException in the case that destination floor is the current floor.
     */
    
    public void addPerson(Person p, int d) throws InvalidLocationException{
        if (d==0){
            throw new InvalidLocationException("The destination for a person "
                    + "can't be the same as the origin floor");
        }else if(d>0){
            
        }else{
            
        }        
    }
    
    /**
     * returns and removes a person on this floor looking to travel in Direction d
     * @param d - the direction that the elevator is traveling 
     * @return Person
     * @throws EmptyQueueException thrown when trying to remove a person from an empty queue
     * @throws ElevatorProject.InvalidLocationException should never happen
     */
    public Person removePerson(Direction d) throws EmptyQueueException, InvalidLocationException{
        
        switch(d){
            case UP:
                if(!upQueue.isEmpty())
                    return upQueue.pollFirst();
                throw new EmptyQueueException();
            case DOWN:
                if(downQueue.isEmpty())
                    return downQueue.pollFirst();
                throw new EmptyQueueException();
        }
        return new Person(1,ElevatorControl.getTick());
    }
            
    
}
