package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> showAllUser();

    void add(User user);

    User findUser(long id);

    void update(User user, long id);

    void delete(long id);
}
