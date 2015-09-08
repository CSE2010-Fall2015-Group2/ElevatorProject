/**
 * Group 2 - Nicholas Persing, Christopher Millsap, Julio Villazon
 *Elevator Project CSE 2010 - Fall 2015 - Section 1
 * 
 */
package ElevatorProject;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
import java.util.ArrayDeque;

public class Report {
    private static final ArrayDeque<Person> bufferQueue = new ArrayDeque<>();
    
    /**
     * Default Constructor
     */
    public Report(){

    }
    
    /**
     * adds a person to a buffer queue 
     * @param p Person to be added to report file
     */
    public static void addToReport(Person p){
        bufferQueue.add(p);
    }
    
    /**
     * empties the bufferQueue to a file on disk in the same directory as the 
     * jar with the TODO title as system time+"Report" upon initialization
     */
    public static void emptyToFile(){
        //String s = "";
        //byte data[] = s.getBytes();
        Path p = Paths.get("./logfile.txt");

        try (OutputStream out = new BufferedOutputStream(
            Files.newOutputStream(p, CREATE, APPEND))) {
            String s;
            while(!bufferQueue.isEmpty()){
                s = bufferQueue.getFirst().toString();
                byte data[] = s.getBytes();
                out.write(data, 0, data.length);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    
}
