package com.example.technicaltest.User;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
public class UserReadService implements IUserReadService{


    private final UserReadRepository UserRepository;

    @Autowired
    public UserReadService(UserReadRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public Page<User> getAllClient(Pageable pageable) {
        return this.UserRepository.findAllByOrderByNameAsc(pageable);
    }


    public Page<UserProjection> getAllClientOrder(Pageable pageable) {

        return this.UserRepository.findAllByOrderByBornDateAsc(pageable);
    }


    public List<UserReport> getAverageClient() {
        return this.UserRepository.findCountUsersAndAverageAge();
    }
}
