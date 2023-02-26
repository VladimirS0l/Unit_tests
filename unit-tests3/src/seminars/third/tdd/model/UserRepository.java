package seminars.third.tdd.model;

import seminars.third.tdd.Config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class UserRepository implements Iterable<User>{
    private int id;
    private final List<User> users;
    private final LoadDb sl;

    public UserRepository() {
        users = new ArrayList<>();
        sl = new LoadDb();
        id = 0;
    }

    public List<User> getShowUsers(){
        return users;
    }

    public boolean auth(User user){
        boolean flag = false;
        sl.readWriteDb(Config.path);
        for (int i = 0; i < sl.count(); i++) {
            if (Objects.equals(sl.get(i).getLogin(), user.getLogin()) &&
                    Objects.equals(sl.get(i).getPassword(), user.getPassword())){
                flag = true;
            }
        }
        return flag;
    }

    public boolean addUser(String login, String password, Enum admin){
        User user = new User(id, login, password, admin);
        id++;
        if (auth(user)){
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public int removeUser(int userId){
        if (indexContains(userId) != -1){
            if (users.get(userId).getAdmin() == Admin.USER){
                users.remove(indexContains(userId));
                return 1;
            }else {
                return 2;
            }
        }else {
            return 3;
        }
    }

    private int indexContains(int index) {
        int searchIndex = -1;
        for (User user : users) {
            if (user.getId() == index)
                searchIndex = users.indexOf(user);
        }
        return searchIndex;
    }

    public int getUserAdmin(int userId){
        if (indexContains(userId) != -1){
            if (users.get(userId).getAdmin() == Admin.USER){
                users.get(userId).setAdmin(Admin.ADMIN);
                return 1;
            }else {
                return 2;
            }
        }else {
            return 3;
        }
    }

    public int getAdminUser(int userId){
        if (indexContains(userId) != -1){
            if (users.get(userId).getAdmin() == Admin.ADMIN){
                users.get(userId).setAdmin(Admin.USER);
                return 1;
            }else {
                return 2;
            }
        }else {
            return 3;
        }
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}
