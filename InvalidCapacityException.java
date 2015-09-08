/**
 * Group 2 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
 */
package ElevatorProject;

class InvalidCapacityException extends Exception{

    public InvalidCapacityException() {
        System.out.println("Capacity of Elevator must be a positiove,"
                + "non zero Integer!");
    }
    
    public InvalidCapacityException(String s){
        System.out.println("Capacity of Elevator must be a positiove,"
                + "non zero Integer!");
        System.out.println(s);
    }
    
}
