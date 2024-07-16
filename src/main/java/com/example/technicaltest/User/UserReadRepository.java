package com.example.technicaltest.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;
public interface UserReadRepository extends Repository<User,Long> {

    Page<User> findAllByOrderByNameAsc(Pageable Pageable);
    @Query(value = "SELECT u.name AS name, u.email AS email, TIMESTAMPDIFF(YEAR, u.bornDate, CURDATE()) AS age " +
            "FROM User u ORDER BY u.bornDate ASC", countQuery = "SELECT count(u) FROM User u")
    Page<UserProjection> findAllByOrderByBornDateAsc(Pageable Pageable);
}
