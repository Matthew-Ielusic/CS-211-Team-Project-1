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
    private ArrayList<Person> people;

    private static final String DELIMITER_BETWEEN_PARTS_OF_FILE = "END";
    
    public FileParser (File file) throws FileNotFoundException {
        // Initialize fields
        this.file = file;
        this.people = new ArrayList<>();

        Scanner scanner = new Scanner(file);               
        
        calculateListOfPeople(scanner);  //NICK: Parses first part of file
        calculateFamilyTree(scanner); //NICK: Parses second part
    }
    
    private void calculateListOfPeople(Scanner fileScanner) {
      // Precondition: fileScanner is pointing to the start of the input file
      String line = fileScanner.nextLine();
      
      while (!line.equals(DELIMITER_BETWEEN_PARTS_OF_FILE)) {
         Person newPerson = new Person(line);
         this.people.add(newPerson);
         
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
    
    private void calculateChildren() {
      for (Person child : people) {
         Person mother = child.getMother();
         if (mother != null) {
            mother.addChild(child);
         }
         Person father = child.getFather();
         if (father != null) {
            father.addChild(child);
         }
      }
   }
        

   public ArrayList<Person> getPeople() {
      return people;
   }

    //If person of given name is not found, null is returned
    private Person getPersonFromString(String name) {
      for (int i=0; i < people.size(); i++) {
        if(people.get(i).toString().equals(name)) {
          return people.get(i);
        }
      }
      return null;
    }
}