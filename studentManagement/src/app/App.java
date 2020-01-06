package app;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.printMenu();
    }

    public void ClearConsole()
    {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}