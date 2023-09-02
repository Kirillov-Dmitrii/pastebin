package com.petproject.pastebin.controller;

import com.petproject.pastebin.model.Message;

import com.petproject.pastebin.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageServiceImpl) {
        this.messageService = messageServiceImpl;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        messageService.createMessage(message);
        return ResponseEntity.ok(message);
    }





}
