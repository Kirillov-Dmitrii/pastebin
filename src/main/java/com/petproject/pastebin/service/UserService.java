package com.petproject.pastebin.service;

import com.petproject.pastebin.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User createUser(User user);
}
