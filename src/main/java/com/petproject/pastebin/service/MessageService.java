package com.petproject.pastebin.service;

import com.petproject.pastebin.model.Message;
import com.petproject.pastebin.model.User;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;


public interface MessageService {
    void createMessage(Message message) throws FileNotFoundException;
}
