package com.petproject.pastebin.controller;

import com.petproject.pastebin.exception.NicknameAlreadyTakenException;
import com.petproject.pastebin.model.Message;
import com.petproject.pastebin.model.User;
import com.petproject.pastebin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("User creating is processing");
        User result = userService.createUser(user);

        if(result == null) {
            throw new NicknameAlreadyTakenException();
        }
        log.info("User added: {}", user);
        return ResponseEntity.ok(result);
    }

//    @GetMapping("/messages")
//    public ResponseEntity<List<Message>> getAllMessages(@RequestBody User user) {
//        return ResponseEntity.ok()
//    }
}
