import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
	
	public static void main (String[] args) throws FileNotFoundException {
	    	
		File file = new File ("tudor.dat");
		FileParser fp = new FileParser(file);

		ArrayList<Person> familyTree = fp.getFamilyTree();
	        
		
		
		//need to set up While loop
			
		
		System.out.println("Person's name?");
		Scanner console = new Scanner(System.in);
		String choice = console.nextLine();
	        

		for (int i = 0; i < familyTree.size(); i++) {
			if(familyTree.get(i).toString().equals(choice)) {
				System.out.println("Person: " + familyTree.get(i));
				System.out.println("Mother: " + familyTree.get(i).getMother());
				System.out.println("Father: " + familyTree.get(i).getFather());
				System.out.println("----");
				
			}		
		}
	
}
}
