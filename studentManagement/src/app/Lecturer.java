package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lecturer
 */
public class Lecturer extends Person {
    App app = new App();
    int arrayLength=100;
    Lecturer lecturer[]=new Lecturer[arrayLength];
    ArrayList<Person> lecturersList=new ArrayList<>();

    String lecDept;

    public Lecturer() {
    }

    public Lecturer(String lecDept) {
        this.lecDept = lecDept;
    }

    public String getLecDept() {
        return this.lecDept;
    }

    public void setLecDept(String lecDept) {
        this.lecDept = lecDept;
    }

    public Lecturer lecDept(String lecDept) {
        this.lecDept = lecDept;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " lecDept='" + getLecDept() + "'" +
            "}";
    }


    @Override
    void output() {
        // TODO Auto-generated method stub
        System.out.printf("\n| %-15s | %-30s | %-15s | %-30s | %-30s | %-10s | ",
        super.getID(), super.getName(), super.getDob(), super.getEmail(), super.getAddress(), getLecDept()); 
        printFormat();

    }

    @Override
    void printTile() {
        // TODO Auto-generated method stub
        super.printFormat();
        System.out.printf("\n| %-15s | %-30s | %-15s | %-30s | %-30s | %-10s |", "ID", "Name", "Day of birth", "Email", "Address", "Define");
        super.printFormat();
    }

    @Override
    void input()
    {
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
        } while (actionable.checkIDLecturer(ID_temp)==false);
        
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
            setEmail(Email_temp);
        } while (!actionable.checkEmail(Email_temp)==true);

        do {
            System.out.println("Enter address : ");
            Address_temp = scanner.nextLine();
            setAddress(Address_temp);
        } while (actionable.checkAddress(Address_temp)==false);

        do {
            System.out.println("Enter lecturer define : ");
            lecDept=scanner.nextLine();
        } while (actionable.isNullOrEmpty(lecDept)==false);
    }

    public void AddLecturer()
    {
        Actionable action=new Actionable();
        int count;
        String s;
        
        do {
            System.out.println("Enter number lecturer you want to add : ");
            s=scanner.nextLine();
        } while (!action.checkNum(s)==true && !action.isNullOrEmpty(s)==true);
        count=Integer.parseInt(s);
        for (int i = 0; i < count; i++) {
            app.ClearConsole();
            System.out.println("Enter information for lecturer " + (i+1));
            lecturer[i]=new Lecturer();
            lecturer[i].input();
            lecturersList.add(lecturer[i]);
        }
        app.ClearConsole();
        System.out.println("Add " + count + " lecturers complete");
    }
    
    public void searchLecturer()
    {
        int index=-1;
        String Name_;
        Actionable actionable = new Actionable();
        do {
            System.out.println("Enter Lecturer Name : ");
            Name_=scanner.nextLine();
        } while (!actionable.checkName(Name_)==true);
        for (Person lecturers : lecturersList) {
            if (lecturers.getID().equals(Name_)) {
                index=lecturersList.indexOf(lecturers);
            }
        }
        if (index!=-1) {
            printTile();
            lecturersList.get(index).output();
        } else {
            System.out.println("Lecturer does not exist");
        }
    }

    @Override
    void delete() {
        // TODO Auto-generated method stub
        int index =-1;
        String ID_;
        Actionable actionable=new Actionable();
        do {
            System.out.println("Enter lecturer id : ");
            ID_=scanner.nextLine();
        } while (actionable.checkIDLecturer(ID_)==false);

        for (Person lecturers : lecturersList) {
            if (lecturers.getID().equals(ID_)) {
                index=lecturersList.indexOf(lecturers);
            }
        }
        if (index!=-1) {
            lecturersList.remove(index);
            //view list
            ViewListLecturers();
        } else {
            System.out.println("Lecturer does not exist");
        }

    }

    @Override
    void update() {
        // TODO Auto-generated method stub
        int index=-1;
        String ID_;
        Actionable actionable=new Actionable();
        do {
            System.out.println("Enter Lecturer ID : ");
            ID_=scanner.nextLine();
        } while (actionable.checkIDLecturer(ID_)==false);

        for (Person lecturers : lecturersList) {
            if (lecturers.getID().equals(ID_)) {
                index=lecturersList.indexOf(lecturers);
            }
        }

        if (index!=-1) {
            printTile();
            //in ra thong tin 
            ViewListLecturers();
            printFormat();
            System.out.println("\nEdit Lecturer Information: ");
            System.out.println("Lecturer ID: " + lecturersList.get(index).getID());
            System.out.println("Lecturer Name: " + lecturersList.get(index).getName());
            System.out.println("Enter the new name (Press Enter to skip and keep the information):  ");
            String Name_tempo=scanner.nextLine();
            if (actionable.isNullOrEmpty(Name_tempo)==false) {
                lecturersList.get(index).setName(lecturersList.get(index).getName());
            } else {
                lecturersList.get(index).setName(Name_tempo);
            }
            
            System.out.println("Lecturer's date of birth: " + lecturersList.get(index).getDob());
            System.out.println("Enter the new day or birth (Press Enter to skip and keep the information): ");
            String Date_tempo=scanner.nextLine();
            if (actionable.isNullOrEmpty(Date_tempo)==false) {
                lecturersList.get(index).setDob(lecturersList.get(index).getDob());
            } else {
                lecturersList.get(index).setDob(Date_tempo);
            }

            System.out.println("Lecturer Email: "+ lecturersList.get(index).getEmail());
            System.out.println("Enter the new email (Press Enter to skip and keep the information): ");
            String Email_tempo=scanner.nextLine();
            if (actionable.isNullOrEmpty(Email_tempo)==false) {
                lecturersList.get(index).setEmail(lecturersList.get(index).getEmail());
            } else {
                lecturersList.get(index).setEmail(Email_tempo);
            }

            System.out.println("Lecturer Address: " + lecturersList.get(index).getAddress());
            System.out.println("Enter the new address (Press Enter to skip and keep the information): ");
            String Address_tempo=scanner.nextLine();
            if (actionable.isNullOrEmpty(Address_tempo)==false) {
                lecturersList.get(index).setAddress(lecturersList.get(index).getAddress());
            } else {
                lecturersList.get(index).setAddress(Address_tempo);
            }

            System.out.println("Lecturer Define: " + lecturer[index].getLecDept());
            System.out.println("Enter the new define (Press Enter to skip and keep the information): ");
            String Define_tempo=scanner.nextLine();
            if (actionable.isNullOrEmpty(Define_tempo)==false) {
                lecturer[index].setLecDept(lecturer[index].getLecDept());
            } else {
                lecturer[index].setLecDept(Define_tempo);
            }
        } else {
            System.out.println("Lecturer does not exist");
        }
    }
    
    public void ViewListLecturers()
    {
        app.ClearConsole();
        printTile();
        for (int i = 0; i < lecturersList.size(); i++) {
            lecturersList.get(i).output();
        }
    }



}