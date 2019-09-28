import java.util.*;
import java.io.*;

public class FileParser {
    private File file;
    private ArrayList<Person> listOfPeople;
    private ArrayList<Person> familyTree;
    
    private ArrayList<Person> list1;
    private ArrayList<Person> list2;
    
    private static final String DELIMITER_BETWEEN_PARTS_OF_FILE = "END";
    
    public FileParser (File file) throws FileNotFoundException {
        // Initialize fields
        this.file = file;
        this.listOfPeople = new ArrayList<>();
        this.familyTree = new ArrayList<>();
        this.list1 = new ArrayList<>();
        this.list2 = new ArrayList<>();
        Scanner scanner = new Scanner(file);       
        
         
        //parse the file in the constructor,
        //since FileParser objects serve no purpose until parsed
        
        // MATT: tudor.dat has two parts.  The first part is an unordered list of people, and the second part
        // is the list of people, ordered [Person, their mother, their father] [Someone else, that person's mother, that person's father], etc.
        // So I think parsing the file should be done in two steps:
        // First, use the first half of the file to figure out who the people are
        // Second, use the second half of the file to figure out how the people we calculated in step 1 are related.
        
        calculateListOfPeople(scanner);
        // TODO: Not implemented
        // calculateFamilyTree(file)
    }
    
    private void calculateListOfPeople(Scanner fileScanner) {
      // Precondition: fileScanner is pointing to the start of the input file
      String line = fileScanner.nextLine();
      
      while (!line.equals(DELIMITER_BETWEEN_PARTS_OF_FILE)) {
         Person newPerson = new Person(line);
         this.listOfPeople.add(newPerson);
         
         line = fileScanner.nextLine();
      }
    }

    //parses file, builds list1 and list2
    //private method to avoid being called twice
    private void parse() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        list1 = new ArrayList<Person>();
        list2 = new ArrayList<Person>();

        //Bool declared here, since initializing in while loop
        //causes value to be reset every loop, preventing 
        //makeList1 from controlling which list is being built.
        boolean makeList1 = true;

        while (scan.hasNextLine()) {

            if (makeList1 == true) { //making list1
                String next = scan.nextLine();

                if (next.equals("END")) {
                    //when "END" is reached, move on to list2
                    makeList1  = false;
                } else {

                    ////
                    ////////
                    //Add correctly built Person object to list1
                    ////////
                    ////
                    
                    //Debugging line. Used to demonstrate that framework is working.
                    //Delete before final product ships
                    System.out.println("List 1");
                }
            } else { //making list2
                String next = scan.nextLine();
                
                ////
                ////////
                //Add correctly built Person object to list2
                ////////
                ////

                //Debugging line. Used to demonstrate that framework is working.
                //Delete before final product ships
                System.out.println("List 2");
            }
        } //end while loop. file has been parsed, lists have been built
    }//end parse method

    //Getters
    public ArrayList<Person> getList1() {
        return list1;
    }

    public ArrayList<Person> getList2() {
        return list2;
    }
    
    // toString for ease of testing
    // Feel free to change this as-needed
    @Override
    public String toString() {
      return this.listOfPeople.toString();
    }
}