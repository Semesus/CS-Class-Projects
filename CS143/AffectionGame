import java.util.*;
import java.io.*;

/*
@author Devin Clarke
@version 3
@since 11/23/2018
CS 143
Java JDK 8

This program simulates the game of Affection, where a list of consenting adults are placed 
into a LinkedList called the Kiss ring. The user is prompted to name someone in the list to
kiss and that person is removed from the KissRing and placed into a seperate LinkedList called
the HappyList. The last person left in the KissRing is declared the winner. 
*/

public class AffectionGame {

   final static int DEBUG = 0;
   
   public static void main(String[] args) throws FileNotFoundException {
      
      long seed = System.nanoTime();
      Random randGen = new Random(seed);
      testAll();
   
      File fileName = getInput();                                 // prompt user for name of file containing names
      
      ArrayList<String> nameList = getNames(fileName);            // add names in file to an ArrayList
   
      LinkedStringList kissRing = getKissRing(nameList, randGen); // add names to LinkedList in random order
      LinkedStringList happyList = new LinkedStringList();        // LinkedList to add 'kissed' names to
      
      playGame(kissRing, happyList);                              // play game until 1 name left in kissRing
   
   } // main()
   
   /**
      getInput prompts user for a filename until a match is found.
      @return text file
      @exception FileNotFoundException if attempt to open file has failed
   */
   public static File getInput() throws FileNotFoundException {
      
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");                                 
      File file = new File(scan.nextLine());                                 
      while(!file.canRead()) {                                               
         System.out.println("File not found. Please try again..");           
         System.out.print("Enter file name: ");
         file = new File(scan.nextLine());
      }
      System.out.println();
      return file;                                              
   } // getInput()
   
   /**
      getNames retrieves names from a txt file and adds them to an ArrayList
      @param nameList File containing list of names
      @return ArrayList<String> ArrayList containing the names
      @exception FileNotFoundException if attempt to open file has failed
   */
   public static ArrayList<String> getNames(File nameList) throws FileNotFoundException { 
   
      ArrayList<String> names = new ArrayList<>();
      Scanner input = new Scanner(nameList);
      while(input.hasNext()) {
         String token = input.next();
         names.add(token);
      }
      return names;
   } // getNames()
   
   /**
      getKissRing randomly adds contents of an ArrayList to a LinkedList
      @param ArrayList containg names as Strings, RNG to randomly add to LinkedList
      @return LinkedList containing names
   */
   public static LinkedStringList getKissRing(ArrayList<String> names, Random randGen) {
      
      LinkedStringList kissRing = new LinkedStringList();
      while(names.size() > 0) {
         int index = randGen.nextInt(names.size());
         kissRing.add(names.get((index)));
         names.remove(index);
      }
      return kissRing;
   } // getKissRing()
   
   public static void playGame(LinkedStringList kissRing, LinkedStringList happyList) {
   
      while(gameOver(kissRing) != true) {            // play game until KissRing contains one person
         Scanner consoleIn = new Scanner(System.in);
         System.out.print("Current Kiss Ring: ");
         printList(kissRing);                         // display contents of kissRing list
         System.out.print("Current Happy List: ");
         printList(happyList);                        // display contents of happyList list
         
         System.out.print("Enter the name of the next person to kiss: ");  // prompt user for next person to kiss
         String name = consoleIn.next();
         System.out.println();
         kissRing.kiss(name, happyList);              // remove that person from kissRing and put them in happyList
      }
      
      System.out.println("The winner is " + kissRing + "!"); // declare winner
   } // playGame()
   
   /**
      printList prints contents of a given LinkedList
      @param LinkedList to print contents of
   */
   public static void printList(LinkedStringList list) {
      System.out.println(list);
   } // printList()
   
   /**
      printStats prints contents of given LinkedList and number of elements it contains
      @param LinkedList to print stats of
   */
   public static void printStats(LinkedStringList list) {
      System.out.println("List contents: " + list);
      System.out.println("List size: " + list.size());
   } // printStats()
   
   /**
      gameOver tests whether the conditions have been met to end the game
      @param LinkedList containing elements to test against
      @return true if List contains 1 element or less, false if 1 or less
   */
   public static boolean gameOver(LinkedStringList kissRing) {
      if(kissRing.size() <= 1) {
         return true;
      } else {
         return false;
      }
   } // gameOver()
   
   public static void testAll() throws FileNotFoundException {

      if(DEBUG > 4) {
         Random randGen = new Random();
         Scanner console = new Scanner(System.in);   
         File fileName = getInput();                      // filename "names.txt" used for this test
         assert("names.txt".equals(fileName.toString()));         
         ArrayList<String> nameList = getNames(fileName); // add names in file to an ArrayList
         assert(7 == nameList.size());
      
         LinkedStringList kissRing = getKissRing(nameList, randGen); // add names to LinkedList in random order
         assert(7 == kissRing.size());
         printList(kissRing);
         
      }
      
      LinkedStringList kissTest = new LinkedStringList();
      LinkedStringList happyTest = new LinkedStringList();
      String[] name = {"tony", "pepper", "peter", "maryjane"};
      
      for(String str : name) {
         kissTest.add(str);
      }
      
      assert("[tony, pepper, peter, maryjane]".equals(kissTest.toString()));
      if(DEBUG > 0) {
         System.out.println("Kiss List: " + kissTest);
         System.out.println("Happy List: " + happyTest);
      }
      assert(0 == happyTest.size());
      assert(4 == kissTest.size());
      kissTest.add("jEAn");
      kissTest.add("scoTt");
      assert(6 == kissTest.size());
      if(DEBUG > 0) {
         System.out.println("Game Over?: " + gameOver(kissTest));
      }
      kissTest.kiss("pepper", happyTest);
      assert(5 == kissTest.size());
      assert(1 == happyTest.size());
      if(DEBUG > 0) {
         printStats(kissTest);
         printStats(happyTest);
         System.out.println("Game Over?: " + gameOver(kissTest));
      }
      kissTest.kiss("TONY", happyTest);
      kissTest.kiss("maryJane", happyTest);
      kissTest.kiss("jean", happyTest);
      kissTest.kiss("pETer", happyTest);
      kissTest.kiss("scoTT", happyTest);
      assert(1 == kissTest.size());
      assert(5 == happyTest.size());
      if(DEBUG > 0) {
         printList(kissTest);
         printList(happyTest);
         System.out.println("Game Over?: " + gameOver(kissTest));
      }
       
      System.out.println("All tests successful!");
      System.out.println();
   }
}
