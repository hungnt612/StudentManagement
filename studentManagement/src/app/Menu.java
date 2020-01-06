package app;

import java.util.Scanner;
/**
 * Menu
 */
public class Menu {

    Actionable action=new Actionable();
    Student student=new Student();
    Scanner scanner=new Scanner(System.in);
    App app=new App();
    Lecturer lecturer=new Lecturer();
    
    
    public void printMenu()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n****************************");
        System.out.println("*     1.Manage Students    *");
        System.out.println("*     2.Manage Lecturers   *");
        System.out.println("*     3.Exits              *");
        System.out.println("****************************");
        String s;
        do {
            System.out.println("Your option is ( please enter a number ):");
            s=scanner.nextLine(); 
        } while (!action.checkNum(s)==true);
        
        int key;
        key=Integer.parseInt(s);
        
        switch (key) {
            case 1:
            app.ClearConsole();
                printSubMenuStudent();
                break;
            
            case 2:
            app.ClearConsole();
                printSubMenuLecturer();
                break;
            case 3:
                System.exit(-1);
                break;
            default:
                System.out.println("Input wrong!");
                printMenu();
                break;
        }
    }

    public void printSubMenuStudent()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n****************************");
        System.out.println("*    1.Add new Students    *");
        System.out.println("*    2.View all Students   *");
        System.out.println("*    3.Search Students     *");
        System.out.println("*    4.Delete Students     *");
        System.out.println("*    5.Update Students     *");
        System.out.println("*    6.Back to main menu   *");
        System.out.println("****************************");
        String s;
        do {
            System.out.println("Your option is ( please enter a number ):");
            s=scanner.nextLine(); 
        } while (!action.checkNum(s)==true);
        
        int key;
        key=Integer.parseInt(s);
        switch (key) {
            case 1:
                app.ClearConsole();
                student.AddStudent();
                printSubMenuStudent();
                break;
            case 2:
                app.ClearConsole();
                student.ViewListStudents();
                printSubMenuStudent();
                break;
            case 3:
                app.ClearConsole();
                student.searchStudent();
                printSubMenuStudent();
                break;
            case 4:
                student.delete();
                printSubMenuStudent();
                break;
            case 5:
                app.ClearConsole();
                student.update();
                printSubMenuStudent();
                break;
            default:
            printMenu();
                break;
        }
    }

    public void printSubMenuLecturer()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n****************************");
        System.out.println("*    1.Add new Lecturers   *");
        System.out.println("*    2.View all Lecturers  *");
        System.out.println("*    3.Search Lecturers    *");
        System.out.println("*    4.Delete Lecturers    *");
        System.out.println("*    5.Update Lecturers    *");
        System.out.println("*    6.Back to main menu   *");
        System.out.println("****************************");
        String s;
        do {
            System.out.println("Your option is ( please enter a number ):");
            s=scanner.nextLine(); 
        } while (!action.checkNum(s)==true);
        
        int key;
        key=Integer.parseInt(s);
        switch (key) {
            case 1:
            app.ClearConsole();
                lecturer.AddLecturer();
                printSubMenuLecturer();
                break;
            case 2:
            app.ClearConsole();
                lecturer.ViewListLecturers();
                printSubMenuLecturer();
                break;
            case 3:
            app.ClearConsole();
                lecturer.searchLecturer();
                printSubMenuLecturer();
                break;
            case 4:
            app.ClearConsole();
                lecturer.delete();
                printSubMenuLecturer();
                break;
            case 5:
            app.ClearConsole();
                lecturer.update();
                printSubMenuLecturer();
                break;
            default:
                printMenu();
                break;
        }
    }

}