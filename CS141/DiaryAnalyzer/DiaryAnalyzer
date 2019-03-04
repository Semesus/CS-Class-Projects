/*

Devin Clarke
CS 141
HW Core Topics: line and token based processing, String methods, writing to file

This program analyzes the daily entries of a diary and makes a determination about
the author's mood based on keywords found. A summary report is created based on the
information obtained that features each day's entry of a given month with an emoticon
representing the author's mood. A tally of all entries analyzed is included at the end.

*/

import java.util.*;
import java.io.*;

public class DiaryAnalyzer
{
   public static void main(String[] args) throws FileNotFoundException
   {     
      Scanner inputMonth = new Scanner(new File("diary.txt")); 

      String prevMonth = "";
      int count = 0;

      while(inputMonth.hasNextLine())
      {
         String month = getMonth(inputMonth);
         String day = getDay();
         String mood = getMood();
         
         printAnalysis(prevMonth, month, day, mood, count);
         
      }
      
   }
   
   // Obtains the current entries' month
   public static String getMonth(Scanner in)
   {
      
      String line = in.nextLine();  // Consume entire line
      Scanner lineScan = new Scanner(line); // Store line in scanner
      String date = lineScan.next();
      String month = date.substring(0,3); 
      return month;
   }
   
   // Obtains the current entries' day
   public static String getDay() throws FileNotFoundException
   {
      Scanner inputDay = new Scanner(new File("diary.txt"));
      String line = inputDay.nextLine();  
      Scanner lineScan = new Scanner(line); 
      String date = lineScan.next(); 
      String day = date.substring(3);   
      return day;
   }
   
   // Analyzes current entry and determines mood for that day
   public static String getMood() throws FileNotFoundException
   {
      Scanner inputMood = new Scanner(new File("diary.txt"));
      int goodCount = 0;
      int badCount = 0;
      String mood = "";
      
      String token = inputMood.nextLine();
      Scanner lineScan = new Scanner(token);
      
      while(lineScan.hasNext())
      {
         String next = lineScan.next();
         next = next.toLowerCase();
         if(next.contains("good") || next.contains("great") || next.contains("yay"))
         {
            goodCount++;
         }
         else if(next.contains("terrible") || next.contains("horrible") || next.contains("awful"))
         {
            badCount++;
         }
      }
      if (goodCount > badCount)
      {
         return mood = ":)";
      }
      else if (goodCount < badCount)
      {
         return mood = ":(";
      }
      else
      {
         return mood = ":|";
      }
   }
   
   public static void printAnalysis(String prevMonth, String month, String day, String mood, int count) throws FileNotFoundException
   {
      PrintStream outFile = new PrintStream(new File("summary.txt"));

      if(prevMonth.equals(month))
         {
            outFile.print(" - " + day + " " + mood);
            outFile.println();
         }
         else
         {
            outFile.println();
            outFile.println(month); 
            outFile.print(" - " + day + " " + mood);
            outFile.println(); 
         }
         prevMonth = month;
         count++;
         outFile.println();
         outFile.println(count + " total days analyzed");
   }

   
   
}

/*
Expected Output:

Jan
 - 01 :)
 - 14 :)

Feb
 - 10 :|
 - 21 :(
 - 23 :)

May
 - 02 :(
 - 15 :)

Jun
 - 01 :)
 - 11 :)

9 total days analyzed


*/
