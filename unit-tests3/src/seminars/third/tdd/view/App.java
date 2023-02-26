package seminars.third.tdd.view;

import seminars.third.tdd.presenter.Presenter;

public class App {
    public static void buttonClick(){
        Presenter presenter = new Presenter();
        ConsoleView c = new ConsoleView();

        String userSelect;
        c.hello();
        while (true){
            userSelect = c.choice();
            if (userSelect.equals("q")){
                c.bye();
                return;
            }
            try {
                switch (userSelect) {
                    case "1" -> presenter.showAllUsers();
                    case "2" -> presenter.addUser();
                    case "3" -> presenter.deleteUser();
                    case "4" -> presenter.userAdmin();
                    case "5" -> presenter.adminUser();
                    default -> System.out.println("\n Команда не найдена!");
                }
            } catch (Exception ex) {
                System.out.println("Error. " + ex.getMessage());
            }
        }
    }
}
