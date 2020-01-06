package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * Student
 */
public class Student extends Person {

    Actionable actionable = new Actionable();
    App app = new App();
    ArrayList<Person> studentsList=new ArrayList<>();
    int arrayLength=100;
    Student student[] = new Student[arrayLength];
    Scanner scanner = new Scanner(System.in);

    private String stdBatch;

    public Student() {
        super();
    }

    public Student(String stdBatch) {
        super();
        this.stdBatch = stdBatch;
    }

    public String getStdBatch() {
        return this.stdBatch;
    }

    public void setStdBatch(String stdBatch) {
        this.stdBatch = stdBatch;
    }

    public Student stdBatch(String stdBatch) {
        this.stdBatch = stdBatch;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " stdBatch='" + getStdBatch() + "'" +
            "}";
    }

    @Override
    void input() {
        // TODO 
        Scanner scanner = new Scanner(System.in);
        Actionable actionable = new Actionable();
        String ID_temp;
        String Name_temp;
        String Dob_temp;
        String Email_temp;
        String Address_temp;
        do {
            System.out.println("Enter ID : ");
            ID_temp = scanner.nextLine();
            setID(ID_temp);
        } while (actionable.checkIDStudent(ID_temp)==false);
        
        do {
            System.out.println("Enter Name : ");
            Name_temp = scanner.nextLine();
            setName(Name_temp);
        } while (actionable.checkName(Name_temp)==false);
        do {
            System.out.println("Enter day of birth : ");
            Dob_temp = scanner.nextLine();
            setDob((Dob_temp));
        } while (!actionable.checkDate(Dob_temp)==true);

        do {
            System.out.println("Enter email : ");
            Email_temp = scanner.nextLine();
            setEmail(Email_temp.toLowerCase());
        } while (!actionable.checkEmail(Email_temp)==true);

        do {
            System.out.println("Enter address : ");
            Address_temp = scanner.nextLine();
            setAddress(Address_temp);
        } while (actionable.checkAddress(Address_temp)==false);
        
        do {
            System.out.println("Enter batch : ");
            stdBatch=scanner.nextLine();
        } while (actionable.isNullOrEmpty(stdBatch)==false);
    }

    public void AddStudent()
    {
        Actionable action=new Actionable();
        int count;
        String s;
        Student temp= null;
        
        do {
            System.out.println("Enter number students you want to add : ");
            s=scanner.nextLine(); 
        } while (!action.checkNum(s)==true);
        count=Integer.parseInt(s);
        for (int i = 0; i < count; i++) {
            app.ClearConsole();
            System.out.println("Enter information for student " + (i+1));
            student[i]=new Student();
            student[i].input();
            studentsList.add(student[i]);
        }
        app.ClearConsole();
        System.out.println("Add " + count + " students complete");
    }

    @Override
    void output() {
        
        // TODO Auto-generated method stub
        System.out.printf("\n| %-15s | %-30s | %-15s | %-30s | %-30s | %-10s | ",
        super.getID(), super.getName(), super.getDob(), super.getEmail(), super.getAddress(), getStdBatch()); 
        printFormat();
    }

    public void ViewListStudents()
    {
        //if (studentsList.isEmpty() == true) {
           // super.IfNull();
       // } else {
            app.ClearConsole();
            printTile();
            
        for (int i = 0; i < studentsList.size(); i++) {
            //System.out.println("--------------"+"Student " + (i+1) + "-------------- ");
            studentsList.get(i).output();
       // }
        }
    }

    @Override
    void printTile()
    {
        super.printFormat();
        System.out.printf("\n| %-15s | %-30s | %-15s | %-30s | %-30s | %-10s |", "ID", "Name", "Day of birth", "Email", "Address", "Batch");
        super.printFormat();
    }

    public void searchStudent()
    {
        int index=-1;
        String Name_;
        Actionable actionable = new Actionable();
        do {
            System.out.println("Enter Student Name : ");
            Name_=scanner.nextLine();
        } while (!actionable.checkName(Name_)==true);
        for (Person students : studentsList) {
            if (students.getName().equals(Name_)) {
                index = studentsList.indexOf(students);
            }
        }
        if (index!=-1) {
            printTile();
            studentsList.get(index).output();
        } else {
            System.out.println("Student does not exist");
        }

    }
    
    @Override
    void delete() {
        // TODO Auto-generated method stub
        int index=-1;
        String ID_;
        Actionable actionable = new Actionable();
        do {
            System.out.println("Enter Student ID : ");
            ID_=scanner.nextLine();
        } while (!actionable.checkIDStudent(ID_)==true);
        for (Person students : studentsList) {
            if (students.getID().equals(ID_)) {
                index = studentsList.indexOf(students);
            }
        }
        if (index!=-1) {
            studentsList.remove(index);
            ViewListStudents();
        } else {
            System.out.println("Student does not exist");
        }
    }


    @Override
    void update()
    {
        int index=-1;
        String ID_;
        Actionable actionable = new Actionable();
        do {
            System.out.println("Enter Student ID : ");
            ID_=scanner.nextLine();
        } while (!actionable.checkIDStudent(ID_)==true);
        for (Person students:studentsList) {
            if (students.getID().equals(ID_)) {
                index = studentsList.indexOf(students);
            }
        }

        if (index!=-1) {
        printTile();
        studentsList.get(index).output();
        printFormat();
        System.out.println("\nEdit Student Information:");
        System.out.println("Student ID: " + studentsList.get(index).getID());
        System.out.println("Student Name: " + studentsList.get(index).getName());
        String nametemp=studentsList.get(index).getName();
        System.out.println("Enter the new name (Press Enter to skip and keep the information):  ");
        String Name_tempo=scanner.nextLine();
        if(actionable.isNullOrEmpty(Name_tempo)==false)
        {
            //System.out.println(actionable.isNullOrEmpty(Name_tempo));
            studentsList.get(index).setName(nametemp);
        }else{
            studentsList.get(index).setName(Name_tempo);
        }
        //
        System.out.println("Student's date of birth: "+ studentsList.get(index).getDob() );
        System.out.println("Enter the new day or birth (Press Enter to skip and keep the information): ");
        String Date_tempo=scanner.nextLine();
        if(actionable.isNullOrEmpty(Date_tempo)==false)
        {
            studentsList.get(index).setDob(studentsList.get(index).getDob());
        }else{
            studentsList.get(index).setDob(Date_tempo);
        }

        //
        System.out.println("Student Email: " + studentsList.get(index).getEmail());
        System.out.println("Enter the new email (Press Enter to skip and keep the information): ");
        String Email_tempo=scanner.nextLine();
        if (actionable.isNullOrEmpty(Email_tempo)==false) {
            studentsList.get(index).setEmail(studentsList.get(index).getEmail());
        } else {
            studentsList.get(index).setEmail(Email_tempo.toLowerCase());
        }

        //
        System.out.println("Student Address : " + studentsList.get(index).getAddress());
        System.out.println("Enter the new address (Press Enter to skip and keep the information): ");
        String Address_tempo=scanner.nextLine();
        if (actionable.isNullOrEmpty(Address_tempo)==false) {
            studentsList.get(index).setAddress(studentsList.get(index).getAddress());
        } else {
            studentsList.get(index).setAddress(Address_tempo);
        }

        //
        System.out.println("Student batch : " +student[index].getStdBatch());
        System.out.println("Enter the new batch (Press Enter to skip and keep the information): ");
        String Batch_tempo=scanner.nextLine();
        if (actionable.isNullOrEmpty(Batch_tempo)==false) {
            student[index].setStdBatch(student[index].getStdBatch());
        } else {
            student[index].setStdBatch(Batch_tempo);
        }
        } else {
            System.out.println("Student doesnt exist");
        }
    }


}