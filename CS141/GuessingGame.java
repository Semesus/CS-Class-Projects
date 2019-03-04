/*

Devin Clarke
CS 141
HW Core Topics: while loops, random object, logical assertions

This program is a guessing game that will pseudorandomly choose a number,
where the highest number is determined by the class constant, and prompts
the player to guess what the number is. If an incorrect guess is entered, 
the program tells the player if they are lower or higher than the number.
When the player is finished playing, a summary of their games are displayed. 

*/

import java.util.*;

public class GuessingGame
{
   // Change value to determine number range to be guessed
   public static final int MAX_NUM = 20;
   
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      String playAgain = "";
      // parameters for results() method
      int totalGames = 0; 
      int totalGuesses = 0;
      int bestGame = Integer.MAX_VALUE;
      
      intro();
      do
     {
        int guesses = guessingGame();
        if (guesses < bestGame)
        {
           bestGame = guesses;
        }
        totalGames++;
        totalGuesses += guesses;
        System.out.print("Do you want to play again? ");
        playAgain = scan.next();
      }while(playAgain.startsWith("y") || playAgain.startsWith("Y")); 
      results(totalGames, totalGuesses, bestGame); 
   }

   // Print introduction text 
   public static void intro()
   {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(MAX_NUM + " and will allow you to guess until"); 
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess."); 
   }
   
   // Play one round of guessing game
   public static int guessingGame()
   {
      Random rand = new Random();
      int number = rand.nextInt(MAX_NUM) + 1;
      int guess = 0;
      int guessCount = 0;

      System.out.println("\nI'm thinking of a number between 1 and " + MAX_NUM + " ..."); 
      while(guess != number)
      {
         Scanner scan = new Scanner(System.in);

         System.out.print("Your guess? ");
         guess = scan.nextInt();
         if (guess > number)
         {
            System.out.println("It's lower.");
         }
         else if (guess < number)
         {
            System.out.println("It's higher.");
         }
         guessCount++;
      }
      if (guessCount == 1)
      {
         System.out.println("You got it right on the first guess!");
      }
      else
      {
         System.out.println("You got it right in " + guessCount + " guesses."); 
      } 
      return guessCount; // param into results() method  
   }
   
   // Display results of games played
   public static void results(int totalGames, int totalGuesses, int bestGame)
   {  
      System.out.println("\nOverall results:");
      System.out.printf("\tTotal games" + "%7s %n", "= " + totalGames);
      System.out.println("\tTotal guesses\t= " + totalGuesses);
      double average = (totalGuesses + totalGames) / 2.0;
      System.out.printf("\tGuesses/game   = %3.1f %n", average); 
      System.out.println("\tBest game\t\t= " + bestGame);
   }
}
/*
 Expected Output:
 This program allows you to play a guessing game.
 I will think of a number between 1 and
 20 and will allow you to guess until
 you get it. For each guess, I will tell you
 whether the right answer is higher or lower
 than your guess.
 
 I'm thinking of a number between 1 and 20 ...
 Your guess? 10
 It's lower.
 Your guess? 5
 It's lower.
 Your guess? 2
 It's higher.
 Your guess? 3
 You got it right in 4 guesses.
 Do you want to play again? yes
 
 I'm thinking of a number between 1 and 20 ...
 Your guess? 10
 It's lower.
 Your guess? 5
 It's higher.
 Your guess? 7
 It's higher.
 Your guess? 8
 It's higher.
 Your guess? 9
 You got it right in 5 guesses.
 Do you want to play again? y
 
 I'm thinking of a number between 1 and 20 ...
 Your guess? 10
 It's lower.
 Your guess? 5
 It's higher.
 Your guess? 7
 It's higher.
 Your guess? 8
 You got it right in 4 guesses.
 Do you want to play again? yellow
 
 I'm thinking of a number between 1 and 20 ...
 Your guess? 10
 It's higher.
 Your guess? 15
 It's higher.
 Your guess? 18
 It's lower.
 Your guess? 17
 You got it right in 4 guesses.
 Do you want to play again? nah
 
 Overall results:
 	Total games    = 4 
 	Total guesses	= 17
 	Guesses/game   = 10.5 
 	Best game		= 4
  ----jGRASP: operation complete.
*/
