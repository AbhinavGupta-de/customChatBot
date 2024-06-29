package org.abhinavgpt.workshopgpt.services.user;

import org.abhinavgpt.workshopgpt.models.User;
import org.abhinavgpt.workshopgpt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long createUser(String name) {
        User user = new User("name");
        return userRepository.save(user).getUserId();
    }

    public User getUser(long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) return user.get();
//        implement a custom exception!
        else throw new Exception("User not found!");
    }

}
