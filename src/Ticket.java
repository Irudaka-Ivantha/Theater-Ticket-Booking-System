public class Ticket {
     private final int Row;
     private final int Seat;
     private final double Price;
     private final Person Person;
     //Constructor
    public Ticket(int row_number, int seat_number, double ticket_price, Person person_details){
        this.Row=row_number;
        this.Seat=seat_number;
        this.Price=ticket_price;
        this.Person=person_details;
        print();
    }
    //Getters
    public int getTicketRow() {

        return Row;
    }

    public int getTicketSeat() {

        return Seat;
    }

    public double getTicketPrice() {

        return Price;
    }
    public Person
    getPerson(){

        return Person;
    }
    public void print(){
        System.out.println("Person's name: "+Person.getPersonName());
        System.out.println("Person's Surname: "+Person.getPersonSurname());
        System.out.println("Person's email: "+Person.getPersonEmail());
        System.out.println("Row of the ticket he bought: Row "+getTicketRow());
        System.out.println("Seat of the ticket he bought: Seat number "+getTicketSeat());
        System.out.println("Price of the Ticket "+Person.getPersonName()+" bought: Rs."+getTicketPrice());
    }
}
