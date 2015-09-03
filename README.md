# ElevatorProject
Elevator control and simulation using java

I am using checks in just about every class that uses a value for added stability and modularity. 
cost a small amout in terms of runtime, but should allow us to change structure and opperation of the program relitively easily.

We might want to pass the responsibility of creating people instead of where I have it now in ElevatorControl, to FloorQueue. For now it should work, but moving responability later should allow us to create differnt passnger creation for differnt floors, ie. in the morning more people will start on floor 1 ect.


Most of the back bone for the elevator should be there now! If we want to implement an express elevator at any point we will probably have to change how we handle passengers, but thats for down the line. I need to go back through everything and put comments in I didn't add them as I went. If there is something that you don't know what it does for now let me know we can see whats needed and whats not..
