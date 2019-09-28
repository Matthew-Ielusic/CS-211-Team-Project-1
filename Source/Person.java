// Author: Matt Ielusic

import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Person {

   private String name;
   private Person mother;
   private Person father;
   private ArrayList<Person> children;
   
   // MATT: I now think my original set-of-constructors is wrong.
   // The way the input file is structured, when we first instantiate a person,
   // All we know is their name.
   // The mother, father, and children must be set later.
   public Person(String name) {
      this.name = name;
      this.children = new ArrayList<>();
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
   
   // Setters
   
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