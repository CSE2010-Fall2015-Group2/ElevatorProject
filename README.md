# ElevatorProject
Elevator control and simulation using java

I am using checks in just about every class that uses a value for added stability and modularity. 
cost a small amout in terms of runtime, but should allow us to change structure and opperation of the program relitively easily.

We might want to pass the responsibility of creating people instead of where I have it now in ElevatorControl, to FloorQueue. For now it should work, but moving responability later should allow us to create differnt passnger creation for differnt floors, ie. in the morning more people will start on floor 1 ect.


Most of the back bone for the elevator should be there now! If we want to implement an express elevator at any point we will probably have to change how we handle passengers, but thats for down the line. I need to go back through everything and put comments in I didn't add them as I went. If there is something that you don't know what it does for now let me know we can see whats needed and whats not..

I'm just starting to look through my code to comment it up and after seeing assert statement used in a program Dr. Stansifer demonstrated for the competive programong club I looked into its use, as I have never used it before but, it seems like it would be nice for us to use to streamline our code a bit here is what I found: 

-use exceptions when checking parameters passed to public or protected methods and constructors
-use exceptions when interacting with the user or when you expect the client code to recover from an exceptional situation
-use exceptions to address problems that might occur
-use assertions when checking pre-conditions, post-conditions and invariants of private/internal code
-use assertions to provide feedback to yourself or your developer team
-use assertions when checking for things that are very unlikely to happen otherwise it means that there is a serious ﬂaw in your application
-use assertions to state things that you (supposedly) know to be true

In other words, exceptions address the robustness of your application while assertions address its correctness.

Assertions are designed to be cheap to write, you can use them almost everywhere and I'm using this rule of thumb: the more an assertion statement looks stupid, the more valuable it is and the more information it embeds. When debugging a program that does not behave the right way, you will surely check the more obvious failure possibilities based on your experience. Then you will check for problems that just cannot happen: this is exactly when assertions help a lot and save time.
