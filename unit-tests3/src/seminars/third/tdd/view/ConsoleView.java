package seminars.third.tdd.view;

import seminars.third.tdd.model.Admin;
import seminars.third.tdd.model.User;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleView {
    Scanner scn;

    public ConsoleView(){
        scn = new Scanner(System.in);
    }

    public String choice() {
        System.out.println("""

                     1 - Показать всех пользователей в сети
                     2 - Добавить пользователя
                     3 - Удалить пользователя
                     4 - Предоставить пользователю права администратора
                     5 - Отнять у пользователя права администратора
                     q - Выход
                     
                    Ваш выбор: \s""");
        return scn.nextLine();
    }

    public void hello() {
        System.out.println("Приложение авторизация!");
    }

    public void bye() {
        System.out.println("Пока!");
    }

    public void getShowUser(List<User> users) {
        System.out.println("Все пользователи: ");
        for (User user: users) {
            System.out.println(user);
        }
    }

    public void mesAddUser(){
        System.out.println("Пользователь добавлен");
    }
    public void mesNotAddUser(){
        System.out.println("Пользователь не зарегистрирован");
    }

    public String getLoginMes() {
        String str;
        System.out.print("Введите логин: \n");
        do {
            str = scn.nextLine();
        } while (str.isEmpty());
        return str;
    }

    public String getPasswordMes() {
        String str;
        System.out.print("Введите пароль: \n");
        do {
            str = scn.nextLine();
        } while (str.isEmpty());
        return str;
    }

    public int getUserId() {
        System.out.println("Введите идентификатор пользователя, которого вы хотите удалить: ");
        while (!scn.hasNextInt()) {
            System.out.println("Ошибка ввода! Введите целое число:");
            scn.next();
        }
        int number = scn.nextInt();
        return number;
    }

    public int getUserForAdmin() {
        System.out.println("Введите идентификатор пользователя, который станет администратором: ");
        while (!scn.hasNextInt()) {
            System.out.println("Ошибка ввода! Введите целое число:");
            scn.next();
        }
        int number = scn.nextInt();
        return number;
    }

    public int getAdminForUser() {
        System.out.println("Введите идентификатор пользователя, который станет пользователем: ");
        while (!scn.hasNextInt()) {
            System.out.println("Ошибка ввода! Введите целое число:");
            scn.next();
        }
        int number = scn.nextInt();
        return number;
    }

    public void userNotFound(){
        System.out.println("Пользователь не найден");
    }

    public void mesUserIsAdmin(){
        System.out.println("Пользователь стал администратором");
    }

    public void mesAdminIsUser(){
        System.out.println("Администратор стал пользователем");
    }

    public void mesUserIsUser(){
        System.out.println("Пользователь уже является пользователем");
    }

    public void mesAdminIsAdmin(){
        System.out.println("Администратор уже является администратором");
    }

    public void userIsDelete(){
        System.out.println("Пользователь успешно удален");
    }

    public void userIsAdminNotDel(){
        System.out.println("Пользователь является администратором, и не может быть удален");
    }
}
