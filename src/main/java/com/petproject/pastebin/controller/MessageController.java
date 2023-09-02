package com.petproject.pastebin.controller;

import com.petproject.pastebin.model.Message;

import com.petproject.pastebin.model.User;
import com.petproject.pastebin.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;import java.io.FileNotFoundException;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageServiceImpl) {
        this.messageService = messageServiceImpl;
    }

    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody Message message) throws FileNotFoundException {
        messageService.createMessage(message);
        return ResponseEntity.ok(message);
    }






}
