public class Person {
     private final String Name;
     private final String Surname;
     private final String Email;
     //Constructor
    public Person(String name, String surname, String email){
        this.Name=name;
        this.Surname=surname;
        this.Email=email;

    }
    //Getters
    public String getPersonName() {

        return Name;
    }
    public String getPersonSurname() {

        return Surname;
    }

    public String getPersonEmail() {

        return Email;
    }
}
