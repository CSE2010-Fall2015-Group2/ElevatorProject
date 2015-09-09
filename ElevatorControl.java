/**
 * Group 2 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
 */
package ElevatorProject;

import java.util.Random;


public class ElevatorControl {
    private FloorQueue[] floorArray;
    private Elevator elevator;
    private static int tick;
    private final int floorCount;
    private boolean[][] buttonsPressed;//don't have a use yet, but I think we might need this for future control designs.
    Random rand = new Random();
    
    /**
     * Constructor 
     * @param cap int the capacity of the elevator 
     * @param floorCount the number of floors in the building 
     */
    public ElevatorControl(int cap,int floorCount){
        try{
            elevator = new Elevator(cap, floorCount);
            floorArray = new FloorQueue[floorCount];
            
            for(int i = 0; i<cap; i++)
                floorArray[i] = new FloorQueue(i);
            
        }catch(InvalidCapacityException | InvalidLocationException e){
            System.out.println("Could not create elevator! Please see "
                    + "system output for more details about the error");
        }
        this.floorCount = floorCount;
        buttonsPressed = new boolean[floorCount][2];
    }
    
    /**
     * Returns the current system tick.
     * @return int - current system tick
     */
    public static int getTick(){
        return tick;
    }
    
    /**
     * fills the is buttonsPressed array with all the floors that are occupied
     */
    private void getButtonsPressed(){
        for(int i = 0; i<floorCount; i++){
            buttonsPressed[i][0] = floorArray[i].isUpPressed();
            buttonsPressed[i][1] = floorArray[i].isDownPressed();
        }
    }

    /**
     * Populates floors based on user or system input, the algorithm attempts to create a person for each floor
     * maxPerFloor number of times, with passengerRate percent chance of success at creating a passenger.
     * @param passengerRate - an integer between 1 and 100, the percent chance that a passenger will be created.
     * @param maxPerFloor - an integer for the max people that can be created in one tick.
     */
        public void populateFloors(int passengerRate, int maxPerFloor){
        int temp;
        for(int i = 0; i< floorCount; i++) 
                for(int j=0; j<maxPerFloor; j++){
                    if(rand.nextInt(100) < passengerRate){
                        temp = rand.nextInt(floorCount);
                        temp++;
                        try {
                            floorArray[i].addPerson(new Person(temp, tick), temp);
                            //need to make a check in the future to be sure a passergner does not
                            //want to get off on their current floor
                        } catch (InvalidLocationException ex) {
                            System.out.println("Invalid Location Exception caught");
                        }
                    }    
                }//This ends populating the floors with new passengers
    }
    
    /**
     * TODO: IMPLEMENT
     * 
     * Runs a simple elevator control program that simply starts at the bottom 
     * and stops at each floor on the way up and switches direction at the top
     * floor and the bottom floor.
     * @param passengerRate - an integer between 1 and 100, the percent chance that a passenger will be created.
     * @param maxPerFloor - an integer for the max people that can be created in one tick.
     * @param duration - how many many ticks the program will run for. 
     */
    public void RunSimple(int passengerRate, int maxPerFloor, int duration){
        int currentFloor;
        
        for(;tick<duration;tick++){
            populateFloors(passengerRate, maxPerFloor);
            
            getButtonsPressed();  
            currentFloor = elevator.getCurrentFloor();
            
            //if the elevator is at the top or the boptom of the shaft then change directiontion
            if(currentFloor == 1)
                elevator.setDirection(Direction.UP);
            else if(currentFloor == floorCount)
                elevator.setDirection(Direction.DOWN);
            
            //let out passenger looking to travel to current floor
            elevator.letOut(currentFloor);
            
            elevator.letIn(floorArray[currentFloor].retrieve());
            
            
            
        }//This is where the tick loop ends
    }
    
    
}
