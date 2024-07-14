package com.example.technicaltest.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@RestController
@RequestMapping("/client")
public class UserController {

    private final IUserReadService userReadService;

    @Autowired
    public UserController(IUserReadService userReadService) {
        this.userReadService = userReadService;
    }


    @GetMapping("/getAllClient/page/{page}/size/{size}")
    public Page<User> getAllClient(@PathVariable Integer page,@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.userReadService.getAllClient(pageable);
    }
}
