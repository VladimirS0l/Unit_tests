package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.model.Admin;
import seminars.third.tdd.model.User;
import seminars.third.tdd.model.UserRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    /**
     * 3.6. Нужно написать класс User (пользователь) с методом аутентификации по логину и паролю,
     * (В метод передаются логин и пароль, метод возвращает true, если пароль и логин совпадают, иначе - false)
     */
    private UserRepository users;
    private User user;

    @BeforeEach
    void setUp() {
        users = new UserRepository();
        user = new User();
    }

    @Test
    void userCreationTrue() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        assertTrue(users.auth(user));
    }

    @Test
    void userCreationFalse() {
        user.setLogin("Vladimir");
        user.setPassword("12342323");
        assertFalse(users.auth(user));
    }

    @Test
    void addUserTrue() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.USER);
        assertTrue(users.addUser(user.getLogin(), user.getPassword(), user.getAdmin()));
    }

    @Test
    void addUserFalse() {
        user.setLogin("Vladimir");
        user.setPassword("1234478452");
        user.setAdmin(Admin.USER);
        assertFalse(users.addUser(user.getLogin(), user.getPassword(), user.getAdmin()));
    }

    @Test
    void removeUserOne() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.USER);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.removeUser(0)).isEqualTo(1);
    }

    //Нельзя удалить, если пользователь является админом
    @Test
    void removeUserTwo() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.ADMIN);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.removeUser(0)).isEqualTo(2);
    }

    //Пользователь с таким id не найден
    @Test
    void removeUserThree() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.USER);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.removeUser(1)).isEqualTo(3);
    }

    @Test
    void getUserAdminOne() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.USER);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.getUserAdmin(0)).isEqualTo(1);
    }

    @Test
    void getUserAdminTwo() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.ADMIN);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.getUserAdmin(0)).isEqualTo(2);
    }

    //Пользователь с таким id не найден
    @Test
    void getUserAdminThree() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.USER);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.getUserAdmin(4)).isEqualTo(3);
    }

    @Test
    void getAdminUserOne() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.ADMIN);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.getAdminUser(0)).isEqualTo(1);
    }

    @Test
    void getAdminUserTwo() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.USER);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.getAdminUser(0)).isEqualTo(2);
    }

    @Test
    void getAdminUserThree() {
        user.setLogin("Vladimir");
        user.setPassword("1234");
        user.setAdmin(Admin.ADMIN);
        users.addUser(user.getLogin(), user.getPassword(), user.getAdmin());
        assertThat(users.getAdminUser(3)).isEqualTo(3);
    }


}