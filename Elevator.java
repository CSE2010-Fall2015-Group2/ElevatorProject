package ElevatorProject;

/**
 * Group 1 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
 * Created by: Nicholas Persing @ 8/31/2015 11:35
 *      -basic structure, setters and getters
 * Edited by: 
 */
public class Elevator {
    private Direction direction;
    private int currentFloor;
    private final int capacity;
    private final int maxFloor; 
    private Person[] occupants; 
    private int occupancy; //the current number of people in the elevator
    
    //private FloorQueue[] floorArray;
            //This might be better to give this responsibility to a 
            //controling class to make the whole system more modular
            
    
    /**
     * Creates new Elevator with specified capacity starting at floor 0
     * @param cap the capacity for the elevator
     * @param floorCount
     * @throws ElevatorProject.InvalidCapacityException in the case of non-positive
     * or zero entry
     * @throws ElevatorProject.InvalidLocationException
     */
    public Elevator(int cap,int floorCount) 
            throws InvalidCapacityException, InvalidLocationException{
        
        if(cap <= 0)
            throw new InvalidCapacityException("Can't Create an Elevator with a "
                    + "zero or negative capacity!");
        if(floorCount <=1)
            throw new InvalidLocationException("Can't create an Elevator with"
                    + "less than 2 floors!");
        capacity = cap;
        currentFloor = 1;
        maxFloor = floorCount;
        direction = Direction.UP;
        
        //the +1 is used to provide a null "well" so there will always be a null
        //value just outside the list 
        occupants = new Person[capacity+1];
        //floorArray = new FloorQueue[maxFloor];
    }
    
    /**
     * Returns the capacity of the elevator.
     * @return int
     */
    public int getCapacity(){
        return capacity;
    }
    
    /**
     * Returns the current location of the elevator 
     * @return int
     */
    public int getCurrentFloor(){
        return currentFloor;
    }
    
    /**
     * sets the current location
     * @param floor
     * @throws ElevatorProject.InvalidLocationException in the case of non-positive
     * or zero entry
     */
    public void setCurrentFloor(int floor) throws InvalidLocationException{
        if(floor <=0)
            throw new InvalidLocationException();
        currentFloor = floor;
    }
    
    /**
     * Move up to the next floor
     * @throws InvalidLocationException in the case of trying to move above top floor
     */
    public void moveUp() throws InvalidLocationException{
        if(currentFloor == maxFloor)
            throw new InvalidLocationException("Trying to move above top floor.");
        currentFloor++;
    }
    
    /**
     * move3 down to the previous floor
     * @throws InvalidLocationException in the case of trying to move below bottom floor
     */
    public void moveDown() throws InvalidLocationException{
        if(currentFloor == 1)
            throw new InvalidLocationException("Trying to move down "
                    + "while on first floor.");
        currentFloor--;
    }
    
    public int getCurrentOccupancy(){
        int count = 0, i = 0;
        while(occupants[i]!=null){
            count++;
        }
        return count;
    }
    
    //Please take a look at this. What do you think its supposed to be an insertion sort style 
    // I think it should work fine but would like to see what some one else thinks.
    private void addPerson(Person p){
        if(isFull()){
            //throw error
        }
            
        for(int i = 0; i< capacity; i++){
            if(p.compareTo(occupants[i]) >=0 ){
                for(int j = capacity; j>i; j--){
                    occupants[j] = occupants[j-1];
                }
                occupants[i] = p;
            }
        }
    }
    
    //Removes a person from the list of occupants of the elevator
    private void removePerson(int index){
        for(int i = index; i < capacity; i++){
            occupants[i]=occupants[i+1];
        }
    }
    
    //lets out all people that are looking to get off at Floor - floor
    public int letOut(int floor){
        int count = 0;
        for(int i = 0; i<capacity; i++)
            if(occupants[i].getFloor() == floor){
                occupants[i].report();
                removePerson(i);
                occupancy--;
                count++;
            }
        
        return count;
    }
    
    //TODO Implement
    public int letIn(FloorQueue queue){            
        int count = 0;
        while(!isFull()&&!queue.isEmpty(direction)){
            addPerson(queue.retrieve(direction));
            occupancy++;
            count++;
        }
        return count;
    }
    

    public boolean isFull(){
        return capacity == occupancy;
//        for(int i = 0; i < capacity; i++)
//            if(occupants[i] == null)
//                return false;
//        
//        return true;
    }
    

    public boolean isEmpty(){
        return occupancy == 0; 
        //return occupants[1] == null;
    }
    
    public Person[] getOccupants(){
        Person[] temp = new Person[capacity]; 
        System.arraycopy(occupants, 0, temp, 0, capacity);
        return temp;
    }
    
    public void setDirection(Direction d){
        direction = d;
    }
    
    public Direction getDirection(){
        return direction;
    }
    
}
