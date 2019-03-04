/*
@author Devin Clarke
@version 1.3
@since 11/23/2018
CS 143
Java JDK 8

Class LinkedStringList can be used to store a list of strings.
This is a stripped down version of a fully featured LinkedStringList class
to be used specifically for the Affection Game
*/

public class LinkedStringList {
   private KissNode front;    // first value in the list
   private int size;          // number of elements in list
   
   /**
      post: constructs an empty list
      @param none
   */
   public LinkedStringList() {
      front = null;
      size = 0;
   }
   
   /**
      post: returns the current number of elements in the list
      @param none
   */
   public int size() {
      return size;
   }
   
   /**
      post: returns comma-seperated, bracketed version of the list
      @param none
      @return formatted String of the list
   */
   public String toString() {
      if(front == null) {
         return "[]";
      } else {
         String result = "[" + front.name;
         KissNode current = front.next;
         while(current != null) {
            result += ", " + current.name;
            current = current.next;
         }
         result += "]";
         return result;
      }
   }
   
   /**
      post: appends the given value to the end of the list
      @param value to add to list
   */
   public void add(String value) {
      if(front == null) {
         front = new KissNode(value);
      } else {
         KissNode current = front;
         while(current.next != null) {
            current = current.next;
         }
         current.next = new KissNode(value);
      }
      size++;
   }
   
   /**
      post: removes a given name from a LinkedStringList and
            adds the name to a seperate LinkedStringList
      @param name to remove, LinkedStringList to add name to
   */
   public void kiss(String name, LinkedStringList happy) {
      
      KissNode current = front;
      while(current.next != null) {
         if(current.name.equalsIgnoreCase(name)) {
            this.size--;
            happy.add(current.name);
            front = current.next;
            return;
         }
         if(current.next.name.equalsIgnoreCase(name)) {
            this.size--;
            happy.add(current.next.name);
            current.next = current.next.next;
            return;
         } else {
            current = current.next;
         }
      }  
   }
   
   /*
      constructs a KissNode for LinkedStringList
      @return a KissNode
   */
   public KissNode KissNode() {
      return new KissNode();
   }
}
