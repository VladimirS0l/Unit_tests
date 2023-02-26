package seminars.third.tdd.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadDb {
    private final List<User> usersInDb;

    public LoadDb() {
        usersInDb = new ArrayList<>();
    }

    public int count(){
        return usersInDb.size();
    }

    public User get(int index){
        return usersInDb.get(index);
    }

    public void readWriteDb(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
             String line;
             String pass;
             while ((line = br.readLine()) != null) {
                 pass = br.readLine();
                 User user = new User();
                 user.setLogin(line);
                 user.setPassword(pass);
                 usersInDb.add(user);
             }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
    }
}
