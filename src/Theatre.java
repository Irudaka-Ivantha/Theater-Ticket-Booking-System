import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.util.*;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
public class Theatre{
    static Scanner input = new Scanner(System.in); // input scanner to get all the user inputs needed
    static ArrayList<Ticket>ticket_List= new ArrayList<>(); //This array list has all the Person details in the Person class and the Ticket details in the Ticket class
    static double Row1_Price=1500; //Ticket price of row 1 seats
    static double Row2_Price=1800; //Ticket price of row2 seats
    static double Row3_Price=2100; //Ticket price of row3 seats


    static int[] row_1 = new int[12]; // An array size of 12 which contains row 1 seats
    static int[] row_2 = new int[16]; //Array size of 16 which contains row 2 seats
    static int[] row_3 = new int[20]; //Array size of 20 which contains row 3 seats

    /***
     * This buy_Ticket method let the user buy tickets, and finally it prints out the details of the user and the tickets which user bought
     * @param array_1 passing the row_1 array
     * @param array_2 passing the row_2 array
     * @param array_3 passing the row_3 array
     */
    public static void buy_ticket(int[] array_1, int[] array_2, int[] array_3) {
        System.out.println("********You successfully accessed the option 1********\n");
        int Row_Number;
        int Seat_Number;
        while (true) {
            System.out.println("Enter the row number: ");
            Row_Number = input.nextInt();
            if (Row_Number >= 1 && Row_Number <= 3) {  //Validating the row number whether its between 1 and 3
                System.out.println("Enter the seat number: ");
                Seat_Number = input.nextInt();
                if (Row_Number == 1) { //Checking the row number is 2
                    if (Seat_Number >= 1 && Seat_Number <= 12 && row_1[Seat_Number-1]==0) { //Validating the seat number whether its between 1 and 12. Also, whether the user entered seat is empty
                        array_1[Seat_Number - 1] = 1;
                        row_1[Seat_Number-1]=1; //Making that seat unavailable
                        System.out.print("Row 1: ");
                        for (int j : array_1) {
                            System.out.print(j + " ");  //Prints out the row1 seats
                        }
                        break;
                    } else {
                        System.out.println("Enter a valid input!" + "\n");
                    }
                }
                else if (Row_Number == 2) { //Checking the row number is 2
                    if (Seat_Number >= 1 && Seat_Number <= 16 && row_2[Seat_Number-1]==0) { //Validating the seat number whether its between 1 and 16. Also, whether the user entered seat is empty
                        array_2[Seat_Number - 1] = 1;
                        row_2[Seat_Number-1]=1; //Making that seat unavailable
                        System.out.print("Row 2: ");
                        for (int j : array_2) {
                            System.out.print(j + " "); //Prints out the row1 seats
                        }
                        break;
                    } else {
                        System.out.println("Enter a valid input!" + "\n");
                    }
                }
                else if (Row_Number == 3) { //Checking the row number is 3
                    if (Seat_Number >= 1 && Seat_Number <= 20 && row_3[Seat_Number-1]==0) { //Validating the seat number whether its between 1 and 20. Also, whether the user entered seat is empty
                        array_3[Seat_Number - 1] = 1;
                        row_3[Seat_Number-1]=1; //Making that seat unavailable
                        System.out.print("Row 3: ");
                        for (int j : array_3) {
                            System.out.print(j + " "); //Prints out the row1 seats
                        }
                        break;
                    } else {
                        System.out.println("Enter a valid input!" + "\n");
                    }
                }
            }
            else {
                System.out.println("Enter a valid input!");
            }
        }
        String Your_Name;
        String Your_Surname;
        String Your_Email;
        while(true) {
            System.out.println("\nEnter your Name: ");
            Your_Name = input.next();                     //Getting user's name, surname and email
            System.out.println("Enter your Surname: ");
            Your_Surname = input.next();
            if (Your_Name.matches(".*\\d+.*")  || Your_Surname.matches(".*\\d+.*")) { //Checking whether there are any numbers in the user entered name
                System.out.println("Enter your Name and Surname again!");
                continue;
            }
            System.out.println("Enter your Email: ");
            Your_Email = input.next();
            String Valid_Email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if (Your_Email.matches(Valid_Email)) {
                break;
            }
            else{
                System.out.println("Enter your email again!");
            }
        }
        Person person=new Person(Your_Name.toLowerCase(),Your_Surname.toLowerCase(),Your_Email.toLowerCase());  //Sending the name,surname and the email to the Person class
        for (Ticket Ticket_Details : ticket_List) {
            Ticket_Details.print();   //Calling the print method in the Ticket class and printing the data in the array list
            System.out.println();
        }

        if (Row_Number == 1) {
            if (Seat_Number >= 1 && Seat_Number <= 12) {
                Ticket Ticket = new Ticket(Row_Number, Seat_Number, Row1_Price, person); //Sending the person, row number, seat number the row price to ticket class
                ticket_List.add(Ticket);
            }
        }
        else if (Row_Number == 2) {
            if (Seat_Number >= 1 && Seat_Number <= 16) {
                Ticket Ticket = new Ticket(Row_Number, Seat_Number, Row2_Price, person); //Sending the person, row number, seat number the row price to ticket class
                ticket_List.add(Ticket);
            }
        }
        else if (Row_Number==3) {
            if (Seat_Number >= 1 && Seat_Number <= 20) {
                Ticket Ticket = new Ticket(Row_Number, Seat_Number, Row3_Price, person); //Sending the person, row number, seat number the row price to ticket class
                ticket_List.add(Ticket);
            }
        }
    }

    /***
     * This method is used to print the seating area of the theatre according to the user inputs in the above method
     */
    public static void print_seating_area() {
        System.out.println("********You successfully accessed the option 2********\n");
        System.out.println("""
                     ***********\s
                     *  STAGE  *\s
                     ***********\
                """);
        if (row_1.length < 20) {
            int Spaces = 20 - row_1.length;                 //printing the aligned seating area
            int Spaces_per_side = Spaces / 2;

            for (int i = 0; i < Spaces_per_side; i++) {
                System.out.print(" ");
            }
        }
        for (int i = 0; i < row_1.length; i++) {
            if (i == row_1.length / 2) {
                System.out.print(" ");
            }
            if (row_1[i] == 1) {
                System.out.print("X");   //Already bought seat will be printed as X and empty seat will be printed as O
            } else {
                System.out.print("O");  //Available seats will be appeared as O
            }
        }
        System.out.println();
        if (row_2.length < 20) {
            int Spaces = 20 - row_2.length;                 //printing the aligned seating area
            int Spaces_per_side = Spaces / 2;

            for (int i = 0; i < Spaces_per_side; i++) {
                System.out.print(" ");
            }
        }
        for (int i = 0; i < row_2.length; i++) {
            if (i == row_2.length / 2) {
                System.out.print(" ");
            }
            if (row_2[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
        if (row_3.length < 20) {
            int Spaces = 20 - row_3.length;                 //printing the aligned seating area
            int Spaces_per_side = Spaces / 2;

            for (int i = 0; i < Spaces_per_side; i++) {
                System.out.print(" ");
            }
        }
        for (int i = 0; i < row_3.length; i++) {
            if (i == row_3.length / 2) {
                System.out.print(" ");
            }
            if (row_3[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();

    }

    /***
     * This method is used to cancel a ticket which user has already bought.
     */
    public static void cancel_ticket(){
        System.out.println("********You successfully accessed the option 3********\n");
        while (true) {
            System.out.println("Enter the row number which you want to cancel the booking: ");
            int Cancel_Row = input.nextInt();

            if (Cancel_Row >= 1 && Cancel_Row <= 3) { //Validating the cancel row number whether its between 1 and 3.
                System.out.println("Enter the Seat number which you want to cancel the booking: ");
                int Cancel_Seat = input.nextInt();
                while (true) {
                    System.out.println("Enter the name of the person that you entered when buying the ticket: ");
                    String Cancel_Name = input.next().toLowerCase();
                    System.out.println("Enter the surname of the person that you entered when buying the ticket: ");
                    String Cancel_Surname = input.next().toLowerCase();
                    if (Cancel_Name.matches(".*\\d+.*") || Cancel_Surname.matches(".*\\d+.*")) { //validating the cancel name and cancel surname whether it contains any letters or not
                        System.out.println("Enter your Name and Surname again!");
                        continue;
                    }
                    System.out.println("Enter the email of the person that you entered when buying the ticket: ");
                    String Cancel_Email = input.next().toLowerCase();
                    String Valid_Cancel_Email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // Validating the email to have a proper email format
                    if (Cancel_Email.matches(Valid_Cancel_Email)) {
                        break;
                    }
                    else{
                        System.out.println("Enter your email again!"); //if the email is not in the proper format asking the user to enter again
                    }
                }
                for (Ticket Cancel_Inputs : ticket_List) {  //Accessing ticket class and checking the ticket list whether the user entered cancel row and cancel seat are there.
                    int Iterate_Inputs;
                    if (Cancel_Inputs.getTicketSeat() == Cancel_Seat && Cancel_Inputs.getTicketRow() == Cancel_Row) {
                        Iterate_Inputs = ticket_List.indexOf(Cancel_Inputs);
                        ticket_List.remove(Iterate_Inputs); //If the cancel seat and row are correct this will remove all the data related to that row number and the seat number
                        System.out.println("Successfully Cancelled the tickets!");
                        break;

                    }
                }

                if (Cancel_Row == 1) {
                    if (Cancel_Seat >= 1 && Cancel_Seat <= 12 && row_1[Cancel_Seat-1]==1) { //checking whether the user entered seat number is in proper range and its already taken
                        row_1[Cancel_Seat-1] = 0; //making that seat available again
                        System.out.print("Row 1: ");
                        for (int j : row_1) {
                            System.out.print(j + " ");
                        }
                        break;
                    } else {
                        System.out.println("Enter a valid input!" + "\n");            //These will cancel the seat numbers in the row_1, row_2 and row_3 arrays if the user have already bought them
                    }
                } else if (Cancel_Row == 2) {
                    if (Cancel_Seat >= 1 && Cancel_Seat <= 16 && row_2[Cancel_Seat-1]==1) { //checking whether the user entered seat number is in proper range and its already taken
                        row_2[Cancel_Seat-1] = 0; //making that seat available again
                        System.out.print("Row 2: ");
                        for (int j : row_2) {
                            System.out.print(j + " ");
                        }
                        break;
                    } else {
                        System.out.println("Enter a valid input!" + "\n");
                    }
                }
                else if (Cancel_Row == 3) {
                    if (Cancel_Seat >= 1 && Cancel_Seat <= 20 && row_3[Cancel_Seat-1]==1) { //checking whether the user entered seat number is in proper range and its already taken
                        row_3[Cancel_Seat - 1] = 0; //making that seat available again
                        System.out.print("Row 3: ");
                        for (int j : row_3) {
                            System.out.print(j + " ");
                        }
                        break;
                    }
                    else {
                        System.out.println("Enter a valid input!" + "\n");
                    }
                }
            }
            else {
                System.out.println("Enter a valid input!");
            }
        }
    }

    /***
     * This method will print out the available seat numbers  of the theatre.
     */
    public static void show_available(){
        System.out.println("********You successfully accessed the option 4********\n");
        System.out.print("Seats available in the Row 1: ");
        for(int i=0;i<row_1.length;i++){
            if(row_1[i]==0){
                if (i == (row_1.length -1)){
                    System.out.print((i + 1) + ".");}     //printing the seats in row 1
                else{
                    System.out.print((i + 1) + ", ");
                }

            }

        }
        System.out.println();
        System.out.print("Seats available in the Row 2: ");
        for(int i=0;i<row_2.length;i++){
            if(row_2[i]==0){
                if (i == (row_2.length -1)){
                    System.out.print((i + 1) + ".");}       //printing the seats in row 2
                else{
                    System.out.print((i + 1) + ", ");
                }
            }
        }
        System.out.println();
        System.out.print("Seats available in the Row 3: ");
        for(int i=0;i<row_3.length;i++){
            if(row_3[i]==0){
                if (i == (row_3.length -1)){
                    System.out.print((i + 1) + ".");}     //printing the seats in row 3
                else{
                    System.out.print((i + 1) + ", ");
                }
            }
        }
        System.out.println();
    }
    /***
     * This method is to write the data to the file. This will write the seating arrangement of the theatre. Already bought and empty seats will be recorded.
     */
    public static void save(){
        System.out.println("********You successfully accessed the option 5********\n");
        try {
            FileWriter Save_file = new FileWriter("Theatre.txt"); // Specify the filename
            Save_file.write("Row 1: ");
            for (int value : row_1) {
                Save_file.write(value + " ");
            }
            Save_file.write("\n");
            Save_file.write("Row 2: ");
            for (int k : row_2) {
                Save_file.write(k + " ");
            }
            Save_file.write("\n");
            Save_file.write("Row 3: ");
            for (int j : row_3) {
                Save_file.write(j + " ");
            }
            Save_file.write("\n");
            Save_file.close();
            System.out.println("File writing successfully completed!");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /***
     * This method will load the data in the file and print it in the terminal.
     */
    public static void load(){
        System.out.println("********You successfully accessed the option 6********\n");

        try {
            File Load_file = new File("Theatre.txt");
            Scanner myReader = new Scanner(Load_file);
            while(myReader.hasNextLine()){
                String data=myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    /***
     * This method will print the ticket details and finally calculate the total price of the tickets which users have bought.
     */
    public static void show_tickets_info(){
        System.out.println("********You successfully accessed the option 7********\n");
        System.out.println("----- Ticket Information -----\n");
        for (Ticket Ticket_Details : ticket_List) {
            Ticket_Details.print();         //accessing the print method in the ticket class through the for loop.  prints out the details of each Ticket object in the ticket_List, one by one, with a blank line between each.
            System.out.println();
        }
        double total=0;
        for (Ticket prices : ticket_List) {
            total=total+prices.getTicketPrice();      //accessing the ticket price through a for loop which is in the ticket class and  
        }
        System.out.println("Total cost is : Rs." + total);   //Printing the total price

    }

    /***
     * This method will sort the ticket details according to the price. From lowest to the highest price
     */
    public static void sort_tickets() {
        System.out.println("********You successfully accessed the option 8********\n");
        divide(0, ticket_List.size() - 1);
    }
    public static void divide(int startIndex, int endIndex) { //This method divides an array into smaller arrays recursively, and then merges them together into one sorted array.
        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            divide(startIndex, mid);
            divide(mid + 1, endIndex);
            //merging Sorted array produce above into one sorted array
            merger(startIndex, mid, endIndex);
        }
    }
    public static void merger(int startIndex, int midIndex, int endIndex) {
        ArrayList<Ticket> mergedSortedArray = new ArrayList<>();
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;
        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if ((Double)ticket_List.get(leftIndex).getTicketPrice() <= (Double) ticket_List.get(rightIndex).getTicketPrice()) {
                mergedSortedArray.add(ticket_List.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(ticket_List.get(rightIndex));
                rightIndex++;
            }
        }
        while (leftIndex <= midIndex) {
            mergedSortedArray.add(ticket_List.get(leftIndex));
            leftIndex++;
        }

        for (Ticket ticket : mergedSortedArray) {
            ticket_List.set(startIndex++, ticket);
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre\n");
        int[] Row_1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] Row_2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] Row_3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.print("Row 1: ");
        for (int value : row_1) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.print("Row 2: ");
        for (int k : row_2) {
            System.out.print(k + " ");
        }
        System.out.println();
        System.out.print("Row 3: ");
        for (int j : row_3) {
            System.out.print(j + " ");
        }
        System.out.println();
        Loop:
        while(true){
                System.out.println("""
        
                        -------------------------------------------------
                        Please select an option\s
                        1) Buy a ticket\s
                        2) Print seating area\s
                        3) Cancel ticket\s
                        4) List available seats\s
                        5) Save to file\s
                        6) Load from file\s
                        7) Print ticket information and total price\s
                        8) Sort tickets by price\s
                             0) Quit\s
                        -------------------------------------------------
                        """);
                try {
                    System.out.println("Enter option: ");
                    String Option = input.next();
                    switch (Option) {
                        case "0":
                            System.out.println("Program terminated!");
                            break Loop;
                        case "1":
                             buy_ticket(Row_1, Row_2, Row_3);
                            break;
                        case "2":
                            print_seating_area();
                            break;
                        case "3":
                            cancel_ticket();
                            break;
                        case "4":
                            show_available();
                            break;
                        case "5":
                            save();
                            break;
                        case "6":
                            load();
                            break;
                        case "7":
                            show_tickets_info();
                            break;
                        case "8":
                            sort_tickets();
                            for (Ticket mergedArray : ticket_List) {
                                mergedArray.print();
                                System.out.print("\n");
                            }
                            break;
                    }
                }
                catch (Exception e){
                    System.out.println("Enter a valid input!");
                }
                double v=0.5d;
                float x=0.4f;
                long c=54L;
                double d = 25.0;

            int i = 0;

            for(i = 0 ; i < 5; i++)

            {

            }

            System.out.println(i);
        }
    }
}
//Reference: https://www.withexample.com/merge-sort-using-arraylist-java-example/
//Reference: https://www.w3schools.blog/java-merge-sort-algorithm-example#:~:text=Merge%20Sort%20works%20on%20Divide,is%20only%201%20sublist%20remaining.
//Reference: https://www.tutorialspoint.com/javaexamples/regular_email.html