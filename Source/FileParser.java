import java.util.*;
import java.io.*;

public class FileParser {
    private File file;
    private ArrayList<Person> list1;
    private ArrayList<Person> list2;

    public FileParser (File file) throws FileNotFoundException {
        this.file = file;
        
        //parse is called in constructor,
        //since FileParser objects serve no purpose until parsed
        parse();
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

        while (scan.hasNext()) {

            if (makeList1 == true) { //making list1
                String next = scan.next();

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
                String next = scan.next();
                
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

    //Get-Sets
    public ArrayList<Person> getList1() {
        return list1;
    }

    public ArrayList<Person> getList2() {
        return list2;
    }
}