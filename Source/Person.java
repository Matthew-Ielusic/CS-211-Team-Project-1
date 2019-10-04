/* 
 * Matt Ielusic * CS 211
 * 10/4/2019
 * Team Project #1
 * Simple class representing a person
 */
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Person {

    private String name;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;
   
    // The way the input file is structured, when we first instantiate a person,
    // All we know is their name.
    // The mother, father, and children must be set later. -Matt
    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
   
    // No-arg constructor as required by the Requirements for Class (Data Structure) Submission page on Canvas - Matt
    public Person() {
        this("");
    }
    
    public String toString() {
       return name;
    }
   
    // Getters

    public Person getMother() {
       return mother;
    }

    public Person getFather() {
       return father;
    }

    public ArrayList<Person> getChildren() {
       return children;
    }
   
    public String getName() {
       return name;
    }
   
    // Mutators
   
    public void setMother(Person newMom) {
       this.mother = newMom;
    }

    public void setFather(Person newDad) {
       this.father = newDad;
    }
   
    public void addChild(Person newChild) {
       if (newChild == null) {
          throw new IllegalArgumentException();
       }
       this.children.add(newChild);
    }
}