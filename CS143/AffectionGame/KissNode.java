/*
@author Devin Clarke
@version 1
@since 11/23/2018
CS 143
Java JDK 8

KissNode is a class for storing a single node of a linked
list. This node class is for a list of string values containg names.
*/
public class KissNode {
   
   public String name;     // name stored in this node
   public KissNode next;   // link to next node in list
   
   /**
      post: constructs a node with empty string field and null link
      @param none
   */
   public KissNode() {
      this("", null);
   }
   
    /**
      post: constructs a node with given string value and null link
      @param name String value
   */
   public KissNode(String name) {
      this(name, null);
   }
   
   /**
      post: constructs a node with given data and given link
      @param name String value and link to next node
   */
   public KissNode(String name, KissNode next) {
      this.name = name;
      this.next = next;
   }
   
   /**
      post: returns the node in a formatted String
      @return String of node content
   */
   public String toString() {
      return "[" + this.name + ", " + this.next + "]";
   }
}
