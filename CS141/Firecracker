/*

Devin Clarke
CS 141
HW Core Topics: nested for loops, static methods, class constants, println statements
                
This program prints an ASCII image of a firecracker to the console window. The image is
able to be resized by changing the constant variable SCALE to any whole number value >= 0.

*/

public class Firecracker
{
   // Change this value to resize image
   public static final int SIZE = 7;
   
   public static void main(String[] args)
   {
      payload();
      coupling();
      stageTwo();
      coupling();
      stageOne();
      coupling();
      thrust();
   }
   
   // Construct the top of the firecracker 
   public static void payload()
   {
      for (int line = 1; line <= SIZE + 1; line++) 
      {
         for (int space = 1; space <= -1 * line + (SIZE + 2); space++) 
         {
            System.out.print(" ");
         }
         System.out.print("/");
         for (int x = 1; x <= (2 * line - 1); x++)
         {
            System.out.print("X");
         }
         System.out.print("\\");
         System.out.println();
      }  
   }
   
   // Construct couplings
   public static void coupling()
   {
      for (int line = 1; line <= 1; line++)
      {
         System.out.print(" ");
         System.out.print("[=");
         for (int i = 1; i <= SIZE; i++) 
         {
            System.out.print("I=");
         }
         System.out.print("]");
         System.out.println();
         
         System.out.print(" ");
         for (int j = 1; j <= 2 * SIZE + 3; j++) 
         {
            System.out.print("=");
         }
         System.out.println();   
      }
   }
   
   // Construct the second stage of the firecracker
   public static void stageTwo()
   {
      for (int line = 1; line <= SIZE - 2; line++) 
      {
         System.out.print("   ");
         System.out.print("|");
         for (int i = 1; i <= SIZE - 1; i++)
         {
            System.out.print("-|");
         }
         System.out.println();
      }
   }
   
   // Construct the first stage of the firecracker
   public static void stageOne()
   {     
      for (int line = 1; line <= SIZE; line++)  
      {
         System.out.print("  ");
         System.out.print("|");
         for (int dot = 1; dot <= line - 1; dot++) 
         {
            System.out.print(".");
         }
         for (int til = 1; til <= -2 * line + (2 * SIZE + 1); til++) 
         {
            System.out.print("~");
         }
         for (int dot = 1; dot <= line - 1; dot++) 
         {
            System.out.print(".");
         }
         System.out.print("|");
         System.out.println();
      }
   }
   
   // Construct the thrust of the firecracker
   public static void thrust()
   {
      for (int line = 1; line <= SIZE - 1; line++) 
      {
         System.out.print(" ");
         for (int space = 1; space <= -1 * line + (SIZE + 2); space++) 
         {
            System.out.print(" ");
         }
         for (int i = 1; i <= line - 1; i++) 
         {
            System.out.print("/");
         }
         System.out.print("|"); 
         for (int j = 1; j <= line - 1; j++) 
         {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
}

/*

Expected output: SIZE = 7

  ----jGRASP exec: java Firecracker
 
         /X\
        /XXX\
       /XXXXX\
      /XXXXXXX\
     /XXXXXXXXX\
    /XXXXXXXXXXX\
   /XXXXXXXXXXXXX\
  /XXXXXXXXXXXXXXX\
  [=I=I=I=I=I=I=I=]
  =================
    |-|-|-|-|-|-|
    |-|-|-|-|-|-|
    |-|-|-|-|-|-|
    |-|-|-|-|-|-|
    |-|-|-|-|-|-|
  [=I=I=I=I=I=I=I=]
  =================
   |~~~~~~~~~~~~~|
   |.~~~~~~~~~~~.|
   |..~~~~~~~~~..|
   |...~~~~~~~...|
   |....~~~~~....|
   |.....~~~.....|
   |......~......|
  [=I=I=I=I=I=I=I=]
  =================
          |
         /|\
        //|\\
       ///|\\\
      ////|\\\\
     /////|\\\\\
  ----jGRASP: operation complete.

 */
