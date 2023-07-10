package web.Service;

import org.springframework.stereotype.Service;
import web.dao.UserRepository;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User>showAllUser(){
        return userRepository.getUsers();
    }

    @Override
    public void add(User user) {
        userRepository.getUsers().add(user);
    }
}
