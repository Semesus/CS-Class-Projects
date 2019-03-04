public class Ticket {
   // Class variable
   private static int seatNum = 1;
   
   // Fields
   private int seat;
   private int cost;
   private String owner;
   
   // Constructor (no param)
   public Ticket() {
      this.seat = seatNum++;
      this.cost = 50;
      this.owner = "eventGoer";
   }
   
   // Constructor (param)
   public Ticket(String owner) {
      this();
      this.owner = owner;
   }
   
   // Accessors
   public int getSeat() { return this.seat; }
   public int getCost() { return this.cost; }
   public String getOwner() { return this.owner; }
   
   // Mutator
   public void setOwner(String newOwner) { this.owner = newOwner; }
   
   // Other behaviors
   public String getType() {
      return "General Admission";
   }
   
   public String getDiscount() {
      return "No associated discounts";
   }
   
   public String toString() {
      if(seat < 10) {
         return "_______________________________\n"+ 
         "\\\t\t\t\t\t\t\t\t\t\t/\n"+
         "/\t\t" + getType() + "\t\t\t\\\n"+
         "\\\t\tSeat # " + getSeat() + "\t\t\t\t\t\t/\n"+
         "/\t\tPrice: $" + getCost() + "\t\t\t\t\t\\\n" +
         "\\\t\t" + getDiscount() + "\t/\n" +
         "/_____________________________\\";
      }
      else {
         return "_______________________________\n"+ 
         "\\\t\t\t\t\t\t\t\t\t\t/\n"+
         "/\t\t" + getType() + "\t\t\t\\\n"+
         "\\\t\tSeat # " + getSeat() + "\t\t\t\t\t/\n"+
         "/\t\tPrice: $" + getCost() + "\t\t\t\t\t\\\n" +
         "\\\t\t" + getDiscount() + "\t/\n" +
         "/_____________________________\\";
      }
   }
}

