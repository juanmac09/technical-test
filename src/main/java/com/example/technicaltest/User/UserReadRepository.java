package com.example.technicaltest.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface UserReadRepository extends Repository<User,Long> {

    Page<User> findAllByOrderByNameAsc(Pageable Pageable);
}
