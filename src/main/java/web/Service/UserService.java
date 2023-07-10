package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> showAllUser();
    void add(User user);
}
