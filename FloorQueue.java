package ElevatorProject;

import java.util.ArrayDeque;

/** 
 * Group 1 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
 * Created by: Nicholas Persing @ 8/31/2015 11:52
 *      -basic structure, setters and getters
 * Edited by: 
 */
public class FloorQueue {
    ArrayDeque<Person> upQueue, downQueue;
    int floor;
    
    public FloorQueue(int floor) throws InvalidLocationException{
        upQueue = new ArrayDeque<Person>() {};
        downQueue = new ArrayDeque<Person>() {};
        
        if(floor <=0)
            throw new InvalidLocationException(
                    "Creating FloorQueue: can't create a floor below zero.");
        
        this.floor = floor;
    }
    
    public boolean isUpPressed(){
        return !upQueue.isEmpty();
    }
    
    public  boolean isDownPressed(){
        return !downQueue.isEmpty();
    }
    
    
    
//    public int EmptyInto(Elevator e, Direction d){
//        int count = 0;
//        switch(d){
//            case UP:
//                while(!upQueue.isEmpty() && !e.isFull()){
//                    //TODO: add to Elevator
//                    upQueue.removeFirst();
//                }
//            case DOWN: 
//                while(!downQueue.isEmpty() && !e.isFull()){
//                    //TODO: add to Elevator
//                    downQueue.removeFirst();
//                }
//        }
//        return count;
//    }
    
    
    /* TODO implement
    * @param d the diffrence between the floor created on and the destination floor (-)down (+)up can't be 0
    */
    public void addPerson(Person p, int d) throws InvalidLocationException{
        if (d==0){
            throw new InvalidLocationException("The destination for a person "
                    + "can't be the same as the origin floor");
        }else if(d>0){
            
        }else{
            
        }
        
               
    }
            
    
}
