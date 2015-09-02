# ElevatorProject
Elevator control and simulation using java

I am using checks in just about every class that uses a value for added stability and modularity. 
cost a small amout in terms of runtime, but should allow us to change structure and opperation of the program relitively easily.

We might want to pass the responsibility of creating people instead of where I have it now in ElevatorControl, to FloorQueue. For now it should work, but moving responability later should allow us to create differnt passnger creation for differnt floors, ie. in the morning more people will start on floor 1 ect.
