package com.petproject.pastebin.service;

import com.petproject.pastebin.model.Message;
import com.petproject.pastebin.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void createMessage(Message message) throws FileNotFoundException {
        String path;
        String fileName = UUID.randomUUID().toString();

        try{
            Files.createDirectories(Paths.get("D:\\java\\pastebin\\pastebin\\src\\main\\resources\\templates" +
                    "\\messages\\"+ message.getUser().getNickname()));

            path = "D:\\java\\pastebin\\pastebin\\src\\main\\resources\\templates" +
                    "\\messages\\"+ message.getUser().getNickname()+ "\\" + fileName + ".txt";

            FileOutputStream file = new FileOutputStream(path);
            file.write(message.getText().getBytes());
            file.flush();
            file.close();
            message.setText(path);
            log.info("Message created with path : {}", path);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Calendar deleteDate = new GregorianCalendar();
        deleteDate.add(Calendar.DAY_OF_MONTH, 1);
        message.setDeleteDate(deleteDate.getTime());

        messageRepository.save(message);
    }

}
