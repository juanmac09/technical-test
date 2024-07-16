package com.example.technicaltest.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWriteService  implements IUserWriteService{

    private final UserWriteRepository userRepository;
    @Autowired
    public UserWriteService(UserWriteRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        this.userRepository.save(user);
        return user;
    }
}


