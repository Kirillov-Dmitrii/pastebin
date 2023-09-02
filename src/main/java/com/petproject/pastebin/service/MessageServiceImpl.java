package com.petproject.pastebin.service;

import com.petproject.pastebin.model.Message;
import com.petproject.pastebin.model.User;
import com.petproject.pastebin.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void createMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getAllMessages(User user) {
        return null;
    }
}
