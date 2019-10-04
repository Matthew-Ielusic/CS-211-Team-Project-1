/* 
 * Matt Ielusic & Nick Schleiff
 * CS 211
 * 10/4/2019
 * Team Project #1
 * FileParser is responsible for taking a file, as described in the problem description,
 * and figuring out what the family tree is.
 */

import java.util.*;
import java.io.*;

/* The data files have two parts.  The first part is an unordered list of people, and the second part
 * is the list of people, ordered [Person, their mother, their father] [Someone else, that person's mother, that person's father], etc.
 * So I think parsing the file should be done in two steps:
 * First, use the first half of the file to figure out who the people are
 * Second, use the second half of the file to figure out how the people we calculated in step 1 are related.
 * -Matt
 */        

public class FileParser {
    private ArrayList<Person> people;

    private static final String DELIMITER_BETWEEN_PARTS_OF_FILE = "END";
    
    public FileParser (File file) throws FileNotFoundException {
        // Initialize fields - Matt
        this.people = new ArrayList<>();

        Scanner scanner = new Scanner(file);               
        
        calculateListOfPeople(scanner);  // Parses first part of file -Nick
        calculateFamilyTree(scanner); //Parses second part -Nick
    }
    
    // No-arg constructor as required by the Requirements for Class (Data Structure) Submission page on Canvas - Matt
    public FileParser() {
        this.people = new ArrayList<>();
    }
    
    public ArrayList<Person> getPeople() {
        return people;
    }
    
    private void calculateListOfPeople(Scanner fileScanner) {
        // Precondition: fileScanner is pointing to the start of the input file - Matt
        // Postcondition: fileScanner is pointing to the line after the first occurence of DELIMITER_BETWEEN_PARTS_OF_FILE - Matt
        String line = fileScanner.nextLine();
      
        while (!line.equals(DELIMITER_BETWEEN_PARTS_OF_FILE)) {
            Person newPerson = new Person(line);
            this.people.add(newPerson);
         
            line = fileScanner.nextLine();
        }
    }

    //private method to avoid being called twice - Nick
    private void calculateFamilyTree(Scanner scan) {
        // Precondition: scan is pointing to the line after the first occurence of DELIMITER_BETWEEN_PARTS_OF_FILE - Matt
        // Postcondition: scan.hasNextLine() returns false - Matt
        while (scan.hasNextLine()) {
            String next = scan.nextLine();

            if(!next.equals(DELIMITER_BETWEEN_PARTS_OF_FILE)) {
                Person p = getPersonFromString(next);

                if(scan.hasNextLine()) {
                    Person mother = getPersonFromString(scan.nextLine());
                    if (mother != null) {
                        p.setMother(mother);       
                        mother.addChild(p);   
                    }
                    if(scan.hasNextLine()) {
                        Person father = getPersonFromString(scan.nextLine());
                        if (father != null) {
                            p.setFather(father);
                            father.addChild(p);
                        }
                    }
                } 
            }
        }
    }

    //If person of given name is not found, null is returned - Nick
    private Person getPersonFromString(String name) {
        for (int i=0; i < people.size(); i++) {
            if(people.get(i).toString().equals(name)) {
                return people.get(i);
            }
        }
     return null;
   }
}