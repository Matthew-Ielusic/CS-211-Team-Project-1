/*
 * Jarrel Khoo & Qineng Li
 * CS 211
 * 10/4/2019
 * Team Project #1
 * Main method allows the user to search names of members of the Tudor family
 * Shows information of person's Maternal Line, Paternal Line, and Children if there is any
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
	
   public static void main (String[] args) throws FileNotFoundException {
       	
      File file = new File ("tudor.dat");
      FileParser fp = new FileParser(file);
   
      ArrayList<Person> familyTree = fp.getPeople();
       
   	// While Loop repeats Search menu
   	// Prompts user to enter name to search, or "quit" to exit
      boolean flag = false;
   	
      while(!flag) {
         Scanner console = new Scanner(System.in);
         System.out.println("Type person's name to search, or \"quit\" to exit");
         String choice = console.nextLine();
           
         if(!choice.toLowerCase().equals("quit")) {
            if(familyTree.toString().contains(choice)) {
               for (int i = 0; i < familyTree.size(); i++) {
                  if(familyTree.get(i).toString().equals(choice)) {
                     System.out.println("Maternal Line:");
                     System.out.println("    " + familyTree.get(i));
                     System.out.println("\t" + familyTree.get(i).getMother());
                     System.out.println("Paternal Line:");
                     System.out.println("    " + familyTree.get(i));
                     System.out.println("\t" + familyTree.get(i).getFather());
                     System.out.println("Children:");
                     System.out.println(familyTree.get(i).getChildren().toString().replace("[","").replace("]", ""));
                     System.out.println("-------------------------------");
                  }	
               } 
               
            //If no correct matches
            }else {
               System.out.println("No records found, please try again.");	
            }
         	
         // "quit" exits search
         } else if(choice.toLowerCase().equals("quit")) {
            System.out.println("Search ended.");
            flag = true;
         }
      }
   }
}


