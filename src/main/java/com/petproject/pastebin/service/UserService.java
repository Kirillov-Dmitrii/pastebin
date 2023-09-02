package com.petproject.pastebin.service;

import com.petproject.pastebin.model.Message;
import com.petproject.pastebin.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<Message> getAllMessages(User user);
}
