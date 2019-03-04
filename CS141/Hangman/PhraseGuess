/*

Devin Clarke
CS 141
HW Core Topics: arrays, file input, Strings

This program is a variation of the game hangman where a user has a set number of
chances to guess a secret phrase. For each correct guess, the correectly guessed character
is revealed to the player. The game ends when either the phrase is correctly guessed
or the set number of guesses decrements to zero. 

The program reads the phrases from a text file that indicates the number of phrases in the file, 
and an array is created with that many elements. Each element in the array is filled with a phrase.
A phrase is then randomly chosen, and a boolean array is created with each element representing a
character in the phrase. For each correct guess from the user, the corresponding element in the 
array is changed from false to true. When all elements in the array are true, the game ends

*/

import java.util.*;
import java.io.*;

public class phraseGuess {
   
   public static final int MAX_GUESSES = 5;
   
   public static void main(String[] args) throws FileNotFoundException {
   
      System.out.println("Let's play a game of word guess.\nYou can guess wrong up to " + MAX_GUESSES + " times.");
      System.out.println();
      String[] phrases = loadInput();                          // Create an array filled with list of phrases
      String phrase = pickPuzzle(phrases);                     // Store a single phrase from list
      Boolean[] puzzle = new Boolean[phrase.length()];         // Create Boolean array to store solved true/false values
      Arrays.fill(puzzle, false);                              // Fill boolean array with false values as default (not needed?)
      int guessesLeft = MAX_GUESSES;
      
      do {                                                
          guessesLeft = playGame(puzzle, phrase, guessesLeft); // Play the game
      }while(!checkIfSolved(puzzle) && guessesLeft > 0);                    
       
      if(checkIfSolved(puzzle)) {                              // Display message based on win or loss
         System.out.println("You solved the puzzle! Good job!");
      } 
      else {
         System.out.println("You have reached the maximum number of guesses.");
         System.out.println("The puzzle was " + phrase);
      }   
   }

   // Load input method
   public static String[] loadInput() throws FileNotFoundException {
   
      Scanner inputPhrases = new Scanner(new File("hangman.txt"));
      int phraseNum = inputPhrases.nextInt();            // Consume number of phrases in file
      String[] phrases = new String[phraseNum];          // Create an array whose size is based on first number in file
      String line = inputPhrases.nextLine();             // This line accounts for the off by one error when assigning to the array

      int count = 0;                                     // count corresponds with array index to store phrase
      while(inputPhrases.hasNextLine()) {
         line = inputPhrases.nextLine();                 // Consume next line from file
         phrases[count] = line;                          // Add that line to appropriate index in array
         count++;                                        // Increment count
      }
      return phrases;
   }
   
   // Pick puzzle method
   public static String pickPuzzle(String[] phrases) {
   
      Random randGen = new Random();
      int count = 0;
      for(String s : phrases) {
         count++;
      }
      int rand = randGen.nextInt(count);  
      String phrasePick = phrases[rand];
      return phrasePick;
      
   }
   
   // Play one round of game
   public static int playGame(Boolean[] puzzle, String phrase, int guessRemain) {
                                                
      printPuzzle(puzzle, phrase);                          // Print puzzle to screen
      System.out.println();
      System.out.print("Guess a letter > ");                // Prompt for user input
      Scanner scan = new Scanner(System.in);                // Scan console for input
      String guess = scan.next();                           // Store user-entered letter
      
      int guessesLeft = checkGuess(puzzle, phrase, guess, guessRemain);  // Check if letter is in phrase
      return guessesLeft;
      
   }
   
   // Print puzzle to screen
   public static void printPuzzle(Boolean[] puzzle, String phrase) {
   
      for(int i = 0; i < phrase.length(); i++) {
         if(!(Character.isAlphabetic(phrase.charAt(i)))) { // Check if char at index is alhabetic or not
            puzzle[i] = true;
         }
      }
      for(int i = 0; i < puzzle.length; i++) {
         if(!puzzle[i]) {
            System.out.print(" _ ");                     // If array element at index is false, print underscore
         }
         else {
            System.out.print(phrase.charAt(i));          // Else print the character at the array index
         }
      }
   }
   
   // Check if puzzle solved
   public static boolean checkIfSolved(Boolean[] puzzle) {
   
      for(boolean b : puzzle) {
         if(!b) {
            return false;
         }
      }
      return true;
   }
   
   // Check if users' guess is in puzzle
   public static int checkGuess(Boolean[] puzzle, String phrase, String guess, int guessRemain) {
   
      int guessesLeft = guessRemain;

      char c = guess.charAt(0);
      int count = 0;
      for(int i = 0; i < phrase.length(); i++) {
         if(Character.toLowerCase(phrase.charAt(i)) == Character.toLowerCase(c)) {
            puzzle[i] = true;
            count++;
         }
      }
      if(count > 0) {
         System.out.println(c + " was found in the puzzle " + count + " times.");
         System.out.println();
      }
      else {
         System.out.println(guess + " was not in the puzzle.");
         guessesLeft--;
         System.out.println("You have " + guessesLeft + " more incorrect tries.");
         System.out.println();
      }
      return guessesLeft;
   }
}

/*
   Expected Output:
  ----jGRASP exec: java phraseGuess_v2
  ----   at: May 28, 2018 5:03:22 PM
 
  ----jGRASP: CLASSPATH is ":.:::/home/dude/jgrasp/extensions/classes".
  ----jGRASP: PATH is "".
  ----jGRASP: working directory is [/home/dude/Documents/CS141-Java I].
  ----jGRASP: actual command sent ["/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java" "phraseGuess_v2"].
 
 Let's play a game of word guess.
 You can guess wrong up to 5 times.
 
  _  _  _  _   _  _  _  _  _  _   _  _  _   _  _  _ 
 Guess a letter > s
 s was found in the puzzle 1 times.
 
 s _  _  _   _  _  _  _  _  _   _  _  _   _  _  _ 
 Guess a letter > o
 o was found in the puzzle 4 times.
 
 s _ o _   _ o _  _ o _   _ o _   _  _  _ 
 Guess a letter > m
 m was found in the puzzle 1 times.
 
 s _ o _  mo _  _ o _   _ o _   _  _  _ 
 Guess a letter > n
 n was found in the puzzle 1 times.
 
 s _ o _  mo _  _ on  _ o _   _  _  _ 
 Guess a letter > e
 e was not in the puzzle.
 You have 4 more incorrect tries.
 
 s _ o _  mo _  _ on  _ o _   _  _  _ 
 Guess a letter > i
 i was found in the puzzle 1 times.
 
 s _ o _  mo _ ion  _ o _   _  _  _ 
 Guess a letter > l
 l was found in the puzzle 3 times.
 
 slo _  mo _ ion  _ o _   _ ll
 Guess a letter > q
 q was not in the puzzle.
 You have 3 more incorrect tries.
 
 slo _  mo _ ion  _ o _   _ ll
 Guess a letter > c
 c was not in the puzzle.
 You have 2 more incorrect tries.
 
 slo _  mo _ ion  _ o _   _ ll
 Guess a letter > w
 w was found in the puzzle 1 times.
 
 slow mo _ ion  _ o _   _ ll
 Guess a letter > t
 t was found in the puzzle 1 times.
 
 slow motion  _ o _   _ ll
 Guess a letter > a
 a was found in the puzzle 1 times.
 
 slow motion  _ o _  all
 Guess a letter > f
 f was found in the puzzle 1 times.
 
 slow motion fo _  all
 Guess a letter > r
 r was found in the puzzle 1 times.
 
 You solved the puzzle! Good job!
  ----jGRASP: operation complete.
*/
