import java.io.*;
import java.util.*;

/*
@author Devin Clarke
@version 2
@since 12/5/2018
CS 143
Java JDK 8

This program encodes and decodes morse code by constructing a binary tree and mapping the letters
to the tree based on the position of the preceding '.' or '-' that makes up the morse code of the letter.
The decode uses a TreeMap to quickly find which letter value corresponds to the morse code key.

Known Issues
============
Each entered morse code letter "chunk" to be decoded must be seperated by a space for the program to properly 
interpret each character. For instance, to decode SOS, the user must enter '... --- ...' to properly decode. 
'...---...' would not work under current implementation. This distinction is currently accounted for in 
the user input prompt.

Similarly, decode can't currently detect proper space breaks in a sentence so will print as a single string,
ie, "thisisanexample".

getInput() code is messy and unoptimized, but works in current implementation. Could be cleaned up and reworked.

*/

public class MorseTree {

   BTNode root = new BTNode();  
   Map<Character, String> morseMap = new TreeMap<Character, String>();
   
   public static void main(String[] args) throws FileNotFoundException {
     	   	
      MorseTree morseTree = new MorseTree();
      morseTree.setUpTreeFromFile("morse.txt");
      testAll(morseTree);
      
      Scanner console = new Scanner(System.in);
      getInput(console, morseTree);
      
   } // main
	
   /**
      setUpTreeFromFile creates a binary tree using the contents of the given txt file
      and creates a TreeMap of key/value pairs from the same file
      @param a txt file to read contents from
      @exception FileNotFoundException if attempt to open file has failed
   */		
   private void setUpTreeFromFile(String fileName) throws FileNotFoundException {
   
      File file = new File(fileName);
      Scanner BTInput = new Scanner(file);
   
      while(BTInput.hasNext()) {
         String letter = BTInput.next();
         letter.trim();
         String morse = BTInput.next();
         morse.trim();
         add(letter, morse);
      }
      
      Scanner mapInput = new Scanner(file);
      while(mapInput.hasNext()) {
         char letter = mapInput.next().charAt(0);
         String morse = mapInput.next();
         morse.trim();
         morseMap.put(letter, morse);
      }
   } // setUpTree()
   
   /**
      decode() takes a string of morse code and translates it into English characters
      pre: each whole morse code letter must be seperated by spaces
      @param String of morse code characters
      @return String of English characters decoded from morse code
   */
   public String decode(String inputMorseCode) {
   
      String[] indivStrings = inputMorseCode.split(" ");
      String decoded = "";
      for(int indicant = 0; indicant < indivStrings.length; indicant++) {
         String codeWord = indivStrings[indicant];
         BTNode current = root;
         for(char currentMorseSymbol : codeWord.toLowerCase().toCharArray()) {
            if(current == null) {  
               return null;
            }
            else if(currentMorseSymbol == '.') {
               current = current.left;
            } else if(currentMorseSymbol == '-') {
               current = current.right;
            } else if(currentMorseSymbol == ' ') {
               decoded += " ";
            }
         }
         decoded += current.data;
      } 	
      return decoded;
   } // decode()
   
   /**
      encode() takes a string of English characters and translates them into 
      morse code using a TreeMap
      @param string of English characters
      @return string of morse code characters translated from English
   */
   public String encode(String englishMessage) {
      String morseEncode = "";
      
      for(char c : englishMessage.toLowerCase().toCharArray()) {
         if(c == ' ') {
            morseEncode += " ";
         } else {
            morseEncode += morseMap.get(c);
            morseEncode += " ";
         }
      }
      return morseEncode;
   } // encode()
   
   /**
      add creates a new node for the binary tree and places it into the 
      appropriate position within the tree
      @param String data an English letter; String morse that letter in morse code
   */
   public void add(String data, String morse)  {
      BTNode current = root;
   	
      for(char c : morse.toCharArray()) {
         if(c == '.') {
            if(current.left != null) {
               current = current.left;
            } else {
               current.left = new BTNode();
               current = current.left;
            }
         } else if (c == '-') {
            if(current.right != null) {
               current = current.right;
            } else {
               current.right = new BTNode();
               current = current.right;
            }
         }
      }	
      current.setData(data);
   } // add()
   
    /*
      printSideways prints the tree contents, one per line, following an 
      inorder traversal and using indentation to indicate node depth; prints 
      right to left
   */
   public void printSideways() {
      printSideways(root, 0);
   }
   
   /*
      helper method prints in reversed preorder the tree with given root, 
      indenting each line to the given level
   */
   private void printSideways(BTNode root, int level) {
      if(root != null) {
         printSideways(root.right, level + 1);
         for(int i = 0; i < level; i++) {
            System.out.print("    ");
         }
         System.out.println(root.data);
         printSideways(root.left, level + 1);
      }
   }
   
   /**
      getInput prompts user for input and calls appropriate method based on input
      @param Scanner console for user input; MorseTree morseTree to search through
   */
   public static void getInput(Scanner console, MorseTree morseTree) {
      System.out.println("Choose to decode or encode your morse code message.");
      String userInput = "";
      while(!(userInput.equalsIgnoreCase("q"))) {
         System.out.print("Enter 'e' to encode your message, 'd' to decode, or 'q' to quit: ");
         userInput = console.next();
         if(userInput.equalsIgnoreCase("e")) {
            if((userInput = console.nextLine()).isEmpty()) {
               System.out.println();
               userInput = "";
               System.out.print("Enter the text you want to encode: ");
               userInput = console.nextLine();
               System.out.println("Your message: " + userInput);
               System.out.println("Your message encoded: " + morseTree.encode(userInput));
               userInput = "";
            }
         } else if(userInput.equalsIgnoreCase("d")) {
            if((userInput = console.nextLine()).isEmpty()) {
               System.out.println();
               userInput = "";
               System.out.print("Enter morse code to be decoded, seperated by spaces: ");
               userInput = console.nextLine();
               System.out.println("Your message: " + userInput);
               System.out.println("Your message decoded: " + morseTree.decode(userInput));
               userInput = "";
            }
         }
      }
   } // getInput()
   
   /**
      testAll tests each function before user input
      @param MorseTree morseTree to search through
      @exception FileNotFoundException if attempt to open file has failed
   */
   public static void testAll(MorseTree morseTree) throws FileNotFoundException {
      //morseTree.setUpTreeFromFile("morse.txt");
      
      System.out.println("morseCodesLetNum.printSideways();");
      morseTree.printSideways();
      System.out.println("Decode the author's name: devin ");        
      System.out.print(morseTree.decode("-..") + morseTree.decode(".") + morseTree.decode("...-") + morseTree.decode("..") + morseTree.decode("-."));
      System.out.println();
      String alphabet = "abcdefghijklmnopqrstuvwxyz 0123456789";
      System.out.println("codeTree.encode(alpabet)= " + morseTree.encode(alphabet) ); 
      System.out.println("codeTree.decode(\")= " + morseTree.decode(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. ----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----." ) );
   
      System.out.println("codeTree.encode(To be or not to be, that is the question.)= " 
         + morseTree.encode("To be or not to be, that is the question.") );  
      System.out.println("codeTree.decode(\")= " 
         + morseTree.decode("- --- -... . --- .-. -. --- - - --- -... . - .... .- - .. ... - .... . --.- ..- . ... - .. --- -.") );
   
      System.out.println("codeTree.encode(whgw history)= " 
         + morseTree.encode("\"What hath God wrought\" is a phrase from the Book of Numbers (Numbers 23:23), and may refer to: \"What hath God wrought\", the official first Morse code message transmitted in the U.S. on May 24, 1844 to officially open the Baltimore-Washington telegraph line.") );
      System.out.println("codeTree.decode(whgw history)= " 
         + morseTree.decode(".-. .-. .-- .... .- -  .... .- - ....  --. --- -..  .-- .-. --- ..- --. .... - .-..-.  .. ...  .-  .--. .... .-. .- ... .  ..-. .-. --- --  - .... .  -... --- --- -.-  --- ..-.  -. ..- -- -... . .-. ...  -.--. -. ..- -- -... . .-. ...  ..--- ...-- ---... ..--- ...-- -.--.- --..--  .- -. -..  -- .- -.--  .-. . ..-. . .-.  - --- ---...  .-..-. .-- .... .- -  .... .- - ....  --. --- -..  .-- .-. --- ..- --. .... - .-..-. --..--  - .... .  --- ..-. ..-. .. -.-. .. .- .-..  ..-. .. .-. ... -  -- --- .-. ... .  -.-. --- -.. .  -- . ... ... .- --. .  - .-. .- -. ... -- .. - - . -..  .. -.  - .... .  ..- .-.-.- ... .-.-.-  --- -.  -- .- -.--  ..--- ....- --..--  .---- ---.. ....- ....-  - ---  --- ..-. ..-. .. -.-. .. .- .-.. .-.. -.--  --- .--. . -.  - .... .  -... .- .-.. - .. -- --- .-. . -....- .-- .- ... .... .. -. --. - --- -.  - . .-.. . --. .-. .- .--. ....  .-.. .. -. . .-. -.-") );
   
      System.out.println("codeTree.encode(whgw?)= " + morseTree.encode("What hath God wrought") ); 
      System.out.println("codeTree.decode(whgw?)= " 
         + morseTree.decode(".-- .... .- - .... .- - .... --. --- -.. .-- .-. --- ..- --. .... - ") );
   
      System.out.println();
      System.out.println("All tests completed.");
      System.out.println();
   
   } // testAll()
   
   /**
      BTNode inner class for a single binary node
   */
   private class BTNode {
      String data = null;
      BTNode  left = null;
      BTNode  right = null;
   	
      public BTNode(){}
   	
      public BTNode(String newData, BTNode newRight, BTNode newLeft) {
         this.data = newData;
         this.left = newLeft;
         this.right = newRight;
      }
   	
      public void setData(String newData) {
         this.data = newData;
      }		
   } // class BTNode   
	
} // public class MorseTree
