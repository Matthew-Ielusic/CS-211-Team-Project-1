import java.io.*;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        File file = new File ("..\\SimplestTestCase.txt");
        FileParser fp = new FileParser(file);
        System.out.println(fp);
   }
}