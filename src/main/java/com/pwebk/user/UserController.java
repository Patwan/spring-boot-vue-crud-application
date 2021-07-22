package com.pwebk.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    User findOne(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    User create(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    User update(@PathVariable int id, @RequestBody User user){
        User olduser = userRepository.findById(id).orElse(null);
        olduser.setName(user.getName());
        olduser.setEmail(user.getEmail());
        olduser.setPassword(user.getPassword());
        return userRepository.save(olduser);
    }

    @GetMapping("/{id}")
    Integer destroy(@PathVariable int id){
        userRepository.deleteById(id);
        return id;
    }
}
