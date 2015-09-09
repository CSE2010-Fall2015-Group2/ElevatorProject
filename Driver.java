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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Person test1, test2;
        FloorQueue floor1, floor2;
        try{
            //Testing Person.java
            test1 = new Person(3, 1);
            test2 = new Person(8, 2);
            
            System.out.println(test1);
            System.out.println(test2);
            System.out.println(test1.getFloor());
            System.out.println(test2.getFloor());
            System.out.println(test1.compareTo(test2));
            System.out.println(test2.compareTo(test1));
            
            test2.setFloor(3);
            System.out.println(test1.compareTo(test2));
            
            System.out.println("***********");
            /**********/
            //Testing FloorQueue.java
            
            floor1 = new FloorQueue(1);
            floor2 = new FloorQueue(2);
            
            System.out.println(floor1.isEmpty(Direction.UP));
            System.out.println(floor1.isEmpty(Direction.DOWN));
            
            System.out.println(floor2.isEmpty(Direction.UP));
            System.out.println(floor2.isEmpty(Direction.DOWN)+"\n");
            
            System.out.println(floor1.isUpPressed());
            System.out.println(floor1.isDownPressed());
            
            System.out.println(floor2.isUpPressed());
            System.out.println(floor2.isDownPressed());
            
            floor1.addPerson(test2, 1);
            System.out.println("person added to floor 1 up");
            
            System.out.println(floor1.isEmpty(Direction.UP));
            System.out.println(floor1.isEmpty(Direction.DOWN));
            
            System.out.println(floor2.isEmpty(Direction.UP));
            System.out.println(floor2.isEmpty(Direction.DOWN)+"\n");
            
            System.out.println(floor1.isUpPressed());
            System.out.println(floor1.isDownPressed());
            
            System.out.println(floor2.isUpPressed());
            System.out.println(floor2.isDownPressed());
            
            floor2.addPerson(test1, 1);
            System.out.println("person added to floor 2 up");
            
            System.out.println(floor1.isEmpty(Direction.UP));
            System.out.println(floor1.isEmpty(Direction.DOWN));
            
            System.out.println(floor2.isEmpty(Direction.UP));
            System.out.println(floor2.isEmpty(Direction.DOWN)+"\n");
            
            System.out.println(floor1.isUpPressed());
            System.out.println(floor1.isDownPressed());
            
            System.out.println(floor2.isUpPressed());
            System.out.println(floor2.isDownPressed());
            
            System.out.println("removing from floor 1");
            
            floor1.removePerson(Direction.UP);
                    
            System.out.println(floor1.isEmpty(Direction.UP));
            System.out.println(floor1.isEmpty(Direction.DOWN));
            
            System.out.println(floor2.isEmpty(Direction.UP));
            System.out.println(floor2.isEmpty(Direction.DOWN)+"\n");
            
            System.out.println(floor1.isUpPressed());
            System.out.println(floor1.isDownPressed());
            
            System.out.println(floor2.isUpPressed());
            System.out.println(floor2.isDownPressed());
            
            System.out.println("removing from floor 2");
            
            floor2.removePerson(Direction.UP);
                    
            System.out.println(floor1.isEmpty(Direction.UP));
            System.out.println(floor1.isEmpty(Direction.DOWN));
            
            System.out.println(floor2.isEmpty(Direction.UP));
            System.out.println(floor2.isEmpty(Direction.DOWN)+"\n");
            
            System.out.println(floor1.isUpPressed());
            System.out.println(floor1.isDownPressed());
            
            System.out.println(floor2.isUpPressed());
            System.out.println(floor2.isDownPressed());
            
            System.out.println("**************");
            
            ElevatorControl control = new ElevatorControl(10,10);
        }catch(Exception e){
            System.out.println("Woah Something went wrong!!!");
        }

        
    }
    
}
