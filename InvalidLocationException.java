/**
 * Group 2 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
 */
package ElevatorProject;

class InvalidLocationException extends Exception{

    public InvalidLocationException(){ 
        System.out.println("Location can only be positive, non-zero intgers "
                + "less than the floor count!");
    }
    
    public InvalidLocationException(String s){
        System.out.println("Location can only be positive, non-zero intgers "
                + "less than the floor count!");
        System.out.println(s);
    }
    
}
