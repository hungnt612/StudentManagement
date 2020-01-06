package app;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Person
 */
abstract class Person {

    Scanner scanner = new Scanner(System.in);
    private String ID;
    private String Name;
    private String Dob;
    private String Email;
    private String Address;

    public Person() {
        super();
    }

    public Person(String ID, String Name, String Dob, String Email, String Address) {
        super();
        this.ID = ID;
        this.Name = Name;
        this.Dob = Dob;
        this.Email = Email;
        this.Address = Address;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDob() {
        return this.Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Person ID(String ID) {
        this.ID = ID;
        return this;
    }

    public Person Name(String Name) {
        this.Name = Name;
        return this;
    }

    public Person Dob(String Dob) {
        this.Dob = Dob;
        return this;
    }

    public Person Email(String Email) {
        this.Email = Email;
        return this;
    }

    public Person Address(String Address) {
        this.Address = Address;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " ID='" + getID() + "'" + ", Name='" + getName() + "'" + ", Dob='" + getDob() + "'" + ", Email='"
                + getEmail() + "'" + ", Address='" + getAddress() + "'" + "}";
    }

    abstract void input();

    abstract void output();

    abstract void delete();

    abstract void update();
    
    public void IfNull() {
        String reply;
        Actionable actionable=new Actionable();
        if (getID() == null) {
            
            do {
                System.out.println("Database is emty ! Are you want enter somethings ? Please enter yes or no ");
                Scanner scanner = new Scanner(System.in);
                reply = scanner.nextLine();
            } while (!actionable.CheckAnswer(reply));

            if (reply.equalsIgnoreCase("Yes")) {
                Student student = new Student();

                student.AddStudent();
            } else if (reply.equalsIgnoreCase("no")) {
                System.out.println("Goodbye.....");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }

    public static void printFormat()
    {
        System.out.println();

        for (int i = 1; i <= 149; i++)
        {
            if (i == 1 || i == 19 || i == 52 || i == 70 || i == 103 || i == 136 || i == 149 )
            {
                System.out.print("+");
            }
            else
            {
                System.out.print("-");
            }
        }
    }

    abstract void printTile();


    
}