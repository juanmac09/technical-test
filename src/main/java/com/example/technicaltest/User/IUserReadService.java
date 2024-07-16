package com.example.technicaltest.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IUserReadService {

    public Page<User> getAllClient(Pageable pageable);
    public Page<UserProjection> getAllClientOrder(Pageable pageable);

}
