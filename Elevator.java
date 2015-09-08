package ElevatorProject;

/**
 * Group 2 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
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
     * @param floor the floor to be set as current.
     * @throws ElevatorProject.InvalidLocationException in the case of non-positive
     * or zero entry
     */
    public void setCurrentFloor(int floor) throws InvalidLocationException{
        if(floor <=0)
            throw new InvalidLocationException();
        currentFloor = floor;
    }
    
    /**
     * Moves the elevator up to the next floor, increments currentFloor.
     * @throws InvalidLocationException in the case of trying to move above top floor
     */
    public void moveUp() throws InvalidLocationException{
        if(currentFloor == maxFloor)
            throw new InvalidLocationException("Trying to move above top floor.");
        currentFloor++;
    }
    
    /**
     * Moves the elevator down to the previous floor, decrements CurrentFloor.
     * @throws InvalidLocationException in the case of trying to move below bottom floor.
     */
    public void moveDown() throws InvalidLocationException{
        if(currentFloor == 1)
            throw new InvalidLocationException("Trying to move down "
                    + "while on first floor.");
        currentFloor--;
    }
    
    /**
     * Returns the number of current occupants.
     * @return occupancy
     */
    public int getCurrentOccupancy(){
        return occupancy;
    }

    /**
     * TODO:Please take a look at this. What do you think its supposed to be 
     * an insertion sort style. I think it should work fine but 
     * would like to see what some one else thinks.
     * 
     * @param p Person to be added to the elevator.
     */
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
    /**
     * Removes the person specified from the elevator 
     * @param index the index of the person to be removed
     */
    private void removePerson(int index){
        //the list is as compacted to as short as possible and this is why 
        //I made the occupants array 1 longer than the capacity so when the 
        //list is full we get the null back at the end of the list instead
        //of a copy of the last person.
        for(int i = index; i < capacity; i++){
            occupants[i]=occupants[i+1];
        }
    }
    
    //lets out all people that are looking to get off at Floor - floor

    /**
     * Lets people out of the elevator removing those who are now at their destination floor
     * @param floor the floor being emptied onto.
     * @return int - the number of people removed from the elevator.
     */
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
    
            
    /**
     * Removes people from the floor queue and adds them to occupants until the queue 
     * is empty or elevator is full.
     * @param queue the queue being added to elevator occupants.
     * @return int - the number of people added to elevator
     */
        public int letIn(FloorQueue queue){            
        int count = 0;
        try{
            while(!isFull()&&!queue.isEmpty(direction)){
                addPerson(queue.removePerson(direction));
                occupancy++;
                count++;
            }
        }catch(EmptyQueueException | InvalidLocationException e){
            System.out.println("this should nopt happen!");
        }
        return count;
    }
    
    /**
     * Indicates whether the elevator is full or not.
     * @return boolean - true if full false otherwise.
     */
    public boolean isFull(){
        return capacity == occupancy;
//        for(int i = 0; i < capacity; i++)
//            if(occupants[i] == null)
//                return false;
//        
//        return true;
    }
    
    /**
     * Indicates whether the elevator is full or not.
     * @return boolean - true if empty, flase otherwise
     */
    public boolean isEmpty(){
        return occupancy == 0; 
        //return occupants[1] == null;
    }
    
    /**
     * returns an array of all the occupants 
     * @return Person[] - a copy of occupants[]
     */
    public Person[] getOccupants(){
        Person[] temp = new Person[capacity]; 
        System.arraycopy(occupants, 0, temp, 0, capacity);
        return temp;
    }
    
    /**
     * sets the direction to desired direction
     * @param d - the direction to set to
     */
    public void setDirection(Direction d){
        direction = d;
    }
    
    /**
     * Returns the current direction 
     * @return Direction - the current direction of the elevator
     */
    public Direction getDirection(){
        return direction;
    }
    
}
