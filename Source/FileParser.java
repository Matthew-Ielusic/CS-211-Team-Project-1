import java.util.*;
import java.io.*;

// MATT: tudor.dat has two parts.  The first part is an unordered list of people, and the second part
// is the list of people, ordered [Person, their mother, their father] [Someone else, that person's mother, that person's father], etc.
// So I think parsing the file should be done in two steps:
// First, use the first half of the file to figure out who the people are
// Second, use the second half of the file to figure out how the people we calculated in step 1 are related.

//NICK: The method "calulateFamilyTree" does so by adding mothers and fathers to the instances found in out listOfPeople.
//it also adds them to familyTree. In that way, both arrayLists reflect the same data
        

public class FileParser {
    private File file;
    private ArrayList<Person> listOfPeople;
    private ArrayList<Person> familyTree;

    private static final String DELIMITER_BETWEEN_PARTS_OF_FILE = "END";
    
    public FileParser (File file) throws FileNotFoundException {
        // Initialize fields
        this.file = file;
        this.listOfPeople = new ArrayList<>();
        this.familyTree = new ArrayList<>();

        Scanner scanner = new Scanner(file);               
        
        calculateListOfPeople(scanner);  //NICK: Parses first part of file
        calculateFamilyTree(scanner); //NICK: Parses second part
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

    
    //private method to avoid being called twice
    private void calculateFamilyTree(Scanner scan) {
      while (scan.hasNextLine()) {
        String next = scan.nextLine();

        if(!next.equals("END")) {
          Person p = getPersonFromString(next);

          if(scan.hasNextLine()) {
            p.setMother(getPersonFromString(scan.nextLine()));          
          }
          if(scan.hasNextLine()) {
            p.setFather(getPersonFromString(scan.nextLine()));
          }
          
          familyTree.add(p);
        } 
      }
    }

    //If person of given name is not found, null is returned
    private Person getPersonFromString(String name) {
      for (int i=0; i < listOfPeople.size(); i++) {
        if(listOfPeople.get(i).toString().equals(name)) {
          return listOfPeople.get(i);
        }
      }
      return null;
    }

    
    //Getters
    public ArrayList<Person> getPeople() {
        return listOfPeople;
    }

    public ArrayList<Person> getFamilyTree() {
        return familyTree;
    }
    
    // toString for ease of testing
    // Feel free to change this as-needed
    @Override
    public String toString() {
      return this.listOfPeople.toString();
    }
}