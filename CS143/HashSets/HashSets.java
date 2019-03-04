/*
@author Devin Clarke
@version 1.2
@since 10/12/2018
CS 143
Java JDK 8

This program stores the contents of two text files into a pair of HashSets
and computes the common words between them.
*/

import java.util.*;
import java.io.*;
import java.lang.System;

public class HashSets {

   public static double NANOSECONDS_IN_SECOND = 1000000000.0;
   public static int REPEAT_COUNT = 10000; // use a value of 10 to 1000000000 to smooth out fluctuations
   
   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner scan = new Scanner(System.in);
   
      Scanner file1 = getInput(scan);
      Scanner file2 = getInput(scan);
      HashSet<String> doc1 = loadInput(file1);
      HashSet<String> doc2 = loadInput(file2);
      
      double timeInSeconds = doManyTimes(REPEAT_COUNT, doc1, doc2);
      HashSet<String> overlap = computeOverlap(doc1, doc2);
      reportResults(doc1, doc2, overlap);
      System.out.println();
      System.out.println("Number of tests performed: " + REPEAT_COUNT);
      System.out.println("Elapsed seconds = " + timeInSeconds);
      System.out.println("Average elapsed seconds = " + timeInSeconds / REPEAT_COUNT);     
   }
  
   /*
      getInput prompts user for a filename until a match is found.
      @param Scanner for console input
      @return text file
      @exception FileNotfoundException if attempt to open file has failed
   */
   public static Scanner getInput(Scanner scan) throws FileNotFoundException {
     
      System.out.print("Enter file name: ");                                 
      File file = new File(scan.nextLine());                                 
      while(!file.canRead()) {                                               
         System.out.println("File not found. Please try again..");           
         System.out.print("Enter file name: ");
         file = new File(scan.nextLine());
      }
      System.out.println();
      return new Scanner(file);                                              
   }
   
   /*
      loadInput loads the words from the scanner into a HashSet
      @param Scanner to consume the text file
      @return HashSet<String> filled with file contents
   */
   public static HashSet<String> loadInput(Scanner in) {
     
      HashSet<String> words = new HashSet<>();
      while(in.hasNext()) {
         String token = in.next();
         token = token.toLowerCase();
         words.add(token);
      }
      return words;
   }
   
   /*
      computeOverlap finds the common words between the two files
      @param Two HashSet<String> to compare to
      @return HashSet<String> containing all words shared by the two files
   */
   public static HashSet<String> computeOverlap(HashSet<String> doc1,
                                                HashSet<String> doc2) {
      HashSet<String> overlap = new HashSet<>(doc1);
      overlap.retainAll(doc2);
      return overlap;
   }
   
   /*
      reportResults prints statistics about file contents and overlap
      @param Three HashSet<String> to analyze
   */   
   public static void reportResults(HashSet<String> list1,
                                  HashSet<String> list2,
                                  HashSet<String> overlap) {
      System.out.println("File #1 words = " + list1.size());
      System.out.println("File #2 words = " + list2.size());
      System.out.println("Common words  = " + overlap.size());
   
      double percent1 = 100.0 * overlap.size() / list1.size();
      double percent2 = 100.0 * overlap.size() / list2.size();
      System.out.println("% of file 1 in overlap = " + percent1); 
      System.out.println("% of file 2 in overlap =  " + percent2);
   }
    
   public static void testAll(HashSet<String> doc1, HashSet<String> doc2) {
       
      computeOverlap(doc1, doc2);
   }
   
   /*
      doManyTimes repeats a chunk of code and counts the elapsed execution in seconds
      @param number of repetitions, two HashSet<String> objects
      @return double the elapsed time of execution in seconds
   */
   public static double doManyTimes(int repetitions, HashSet<String> doc1, HashSet<String> doc2) { 
      
      long startTime = System.nanoTime();
      for (int currentRep = 0; currentRep < repetitions; currentRep++) {    
         testAll(doc1, doc2); // the code being measured
      }     
      long elapsedTime = Math.abs(System.nanoTime() - startTime);
      return (double)elapsedTime / NANOSECONDS_IN_SECOND;   
   }     
}
