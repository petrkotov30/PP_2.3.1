package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    {
        users.add(new User("Petr", "Kotov", (byte) 27));
    }

    public List<User> getUsers() {
        return users;
    }

//    public void save(User user) {
//        users.add(user);
//    }
}
