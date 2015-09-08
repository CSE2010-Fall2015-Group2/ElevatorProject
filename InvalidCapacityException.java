/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorProject;

/**
 *
 * @author nicholas
 */
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
