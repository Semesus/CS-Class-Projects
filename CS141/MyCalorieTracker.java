/*

Devin Clarke
CS 141
HW Core Topics: if statements, user input, method parameters and return types, formatting

This program prompts the user for daily caloric intake and activity level and
calculates the net calories, then compares the results to the user-defined
daily calorie goals, letting the user know which day(s) were closer to their 
intial goal. 

**DISCLAIMER: Should not be used for real-world health guidance.

*/

import java.util.Scanner;

public class MyCalorieTracker
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      
      intro();
      int goal = getGoal(scan); 
      
      System.out.println("Information for Day #1:");
      int netCals1 = returnNetCals(scan);
      
      System.out.println("Information for Day #2:");
      int netCals2 = returnNetCals(scan);
      
      System.out.println("Day 1 Net Calories = " + netCals1);
      System.out.println("Day 2 Net Calories = " + netCals2);
      
      getGoalDist(netCals1, netCals2, goal);
      disclaimer();
   }
   
   // Print introduction
   public static void intro()
   {
      System.out.println("This program compares your daily caloric intake");
      System.out.println("for two days and determines which day was better");
      System.out.println("in regards to reaching your fitness goals.");
      System.out.println();
   }
   
   // Prompt user for caloric goal 
   public static int getGoal(Scanner scan)
   {  
      System.out.print("What is your calorie goal for the day? > "); 
      return scan.nextInt();
   }
   
   // Prompt user for calories consumed per meal and calculate total calories consumed
   public static int getCalories(Scanner scan)
   {      
      System.out.printf("%36s", "How many meals did you eat? ");                 
      int meals = scan.nextInt();
      int totalCals = 0;
      for (int i = 1; i <= meals; i++)
      {
         System.out.printf("%56s", "How many calories were consumed in meal " + i + "? ");
         totalCals += scan.nextInt();
      }
      
      System.out.println();
      System.out.printf("%40s\n", "-- Total caloric intake = " + totalCals + "--");
      return totalCals;
   }
   
   // Prompt user for activity level
   public static int getActivity(Scanner scan)
   {
      System.out.printf("%71s", "What was your activity level? 1) Not active 2) Lightly Active \n");
      System.out.printf("%67s", "3) Active or 4) Very Active? ");
      int activity = scan.nextInt();
      
      int burned;       
      if (activity == 1)
      {
          burned = 0;
      }
      else if (activity == 2)
      {
          burned = 250;
      }
      else if (activity == 3)
      {
          burned = 500;
      }
      else 
      {
          burned = 750;
      }
      System.out.printf("%49s\n", "-- Estimated active caloric burn = " + burned + "--\n");
      return burned;
   }
   
   // Calculate calories consumed minus calories burned through activity
   public static int returnNetCals(Scanner scan)
   {  
      int getCal = getCalories(scan);
      int getActiv = getActivity(scan);
      return getCal - getActiv;
   }
   
   // Calculate which day(s) were closest to calorie goal
   public static void getGoalDist(int netCal1, int netCal2, int goal) 
   {
      int goalDay1 = Math.abs(goal - netCal1);
      int goalDay2 = Math.abs(goal - netCal2);
      
      if (goalDay1 == goalDay2) 
      {
         System.out.println("Both Day 1 and Day 2 net calories were the same**");
      }
      else if (goalDay1 < goalDay2)
      {
         System.out.println("You were closer to your goal on Day 1**");
      }
      else
      {
         System.out.println("You were closer to your goal on Day 2**");
      }
      
      double average = (netCal1 + netCal2) / 2.0;
      System.out.println("Average Net Calories = " + average); 
      System.out.println();
   }
   
   // Print disclaimer warning of wildly inaccurate information contained in program
   public static void disclaimer()
   {
      System.out.println("** DISCLAIMER: Summary results are probably wrong. I \nwouldn't trust them if I were you.");
   }
}

/*
  Expected Output:
  ----jGRASP exec: java MyCalorieTracker
 
 This program compares your daily caloric intake
 for two days and determines which day was better
 in regards to reaching your fitness goals.
 
 What is your calorie goal for the day? > 1600
 Information for Day #1:
         How many meals did you eat? 3
              How many calories were consumed in meal 1? 350
              How many calories were consumed in meal 2? 500
              How many calories were consumed in meal 3? 750
 
         -- Total caloric intake = 1600--
         What was your activity level? 1) Not active 2) Lightly Active 
                                       3) Active or 4) Very Active? 2
         -- Estimated active caloric burn = 250--
 
 Information for Day #2:
         How many meals did you eat? 4
              How many calories were consumed in meal 1? 300
              How many calories were consumed in meal 2? 250
              How many calories were consumed in meal 3? 600
              How many calories were consumed in meal 4? 750
 
         -- Total caloric intake = 1900--
         What was your activity level? 1) Not active 2) Lightly Active 
                                       3) Active or 4) Very Active? 3
         -- Estimated active caloric burn = 500--
 
 Day 1 Net Calories = 1350
 Day 2 Net Calories = 1400
 You were closer to your goal on Day 2**
 Average Net Calories = 1375.0
 
 ** DISCLAIMER: Summary results are probably wrong. I 
 wouldn't trust them if I were you.
  ----jGRASP: operation complete.
*/
