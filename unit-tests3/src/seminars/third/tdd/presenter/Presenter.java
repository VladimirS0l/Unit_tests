package seminars.third.tdd.presenter;

import seminars.third.tdd.model.Admin;
import seminars.third.tdd.model.UserRepository;
import seminars.third.tdd.view.ConsoleView;

public class Presenter {
    private final UserRepository ur;
    private final ConsoleView view;

    public Presenter() {
        ur = new UserRepository();
        view = new ConsoleView();
    }

    public void showAllUsers(){
        view.getShowUser(ur.getShowUsers());
    }

    public void addUser(){
        if (ur.addUser(view.getLoginMes(), view.getPasswordMes(), Admin.USER)){
            view.mesAddUser();
        }else {
            view.mesNotAddUser();
        }
    }

    public void deleteUser(){
        showAllUsers();
        int answer = ur.removeUser(view.getUserId());
        if (answer == 1){
            view.userIsDelete();
        }else if (answer == 2){
            view.userIsAdminNotDel();
        }else if (answer == 3){
            view.userNotFound();
        }
    }

    public void userAdmin(){
        showAllUsers();
        int answer = ur.getUserAdmin(view.getUserForAdmin());
        if (answer == 1){
            view.mesUserIsAdmin();
        }else if (answer == 2){
            view.mesAdminIsAdmin();
        }else if (answer == 3){
            view.userNotFound();
        }
    }

    public void adminUser(){
        showAllUsers();
        int answer = ur.getAdminUser(view.getAdminForUser());
        if (answer == 1){
            view.mesAdminIsUser();
        }else if (answer == 2){
            view.mesUserIsUser();
        }else if (answer == 3){
            view.userNotFound();
        }
    }
}
