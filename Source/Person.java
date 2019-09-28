// Author: Matt Ielusic

import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Person {

   private Person mother;
   private Person father;
   private ArrayList<Person> children;
   
   public Person() {
      this(null, null);
   }
   
   public Person(Person mother, Person father) {
      this.mother = mother;
      this.father = father;
      this.children = new ArrayList<>();
   }
   
   public void addChild(Person newChild) {
      if (newChild == null) {
         throw new IllegalArgumentException();
      }
      this.children.add(newChild);
   }

   //Get-Sets
   public Person getMother() {
      return mother;
   }

   public Person getFather() {
      return father;
   }

   public ArrayList<Person> getChildren() {
      return children;
   }
}