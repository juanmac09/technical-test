package com.example.technicaltest.User;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;


@Service
public class UserReadService implements IUserReadService{


    private final UserReadRepository UserReporsitory;

    @Autowired
    public UserReadService(UserReadRepository UserReporsitory) {
        this.UserReporsitory = UserReporsitory;
    }

    public Page<User> getAllClient(Pageable pageable) {
        return this.UserReporsitory.findAllByOrderByNameAsc(pageable);
    }
}
