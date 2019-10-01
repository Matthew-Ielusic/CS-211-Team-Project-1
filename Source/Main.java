import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        File file = new File ("..\\BigFamily.txt");
        FileParser fp = new FileParser(file);

        ArrayList<Person> familyTree = fp.getPeople();

        printTest(familyTree);

   }
   
   //NICK: debugging method. feel free to delete
   static void printTest(ArrayList<Person> list) {
       for(Person p : list) {
           System.out.println("Name: " + p + " --- Mother: " + p.getMother() + " --- Father: " + p.getFather() + "--- Kids:");
           if (p.getChildren().isEmpty()) {
               System.out.println("\t<None>");
           } else {
               for (Person kid : p.getChildren()) {
                  System.out.println("\t" + kid.getName());
               }
           }
       }
   }

}