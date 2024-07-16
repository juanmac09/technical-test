package com.example.technicaltest.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/client")
public class UserController {
    @Autowired
    private final IUserReadService userReadService;
    @Autowired
    private final IUserWriteService userWriteService;

    @Autowired
    public UserController(IUserReadService userReadService,IUserWriteService userWriteService) {
        this.userReadService = userReadService;
        this.userWriteService = userWriteService;
    }


    @PostMapping("/create/client")
    public ResponseEntity<?> saveClient(@Valid @RequestBody User user){
            return ResponseEntity.status(HttpStatus.OK).body(this.userWriteService.save(user));
    }


    @GetMapping("/getAllClient/page/{page}/size/{size}")
    public ResponseEntity<?> getAllClient(@PathVariable Integer page,@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(this.userReadService.getAllClient(pageable));
    }

    @GetMapping("/getAllClientOrder/page/{page}/size/{size}")
    public ResponseEntity<?> getAllClientOrder(@PathVariable Integer page,@PathVariable Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(this.userReadService.getAllClientOrder(pageable));
    }

    @GetMapping("/getClient/average")
    public ResponseEntity<?> getAverage(){
        return ResponseEntity.status(HttpStatus.OK).body(this.userReadService.getAverageClient());
    }

}
