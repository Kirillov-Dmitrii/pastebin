package com.petproject.pastebin.service;

import com.petproject.pastebin.model.Message;
import com.petproject.pastebin.model.User;
import com.petproject.pastebin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        User result = userRepository.findByNickname(user.getNickname().toLowerCase());
        if(result != null) {
            return  null;
        }
        return userRepository.save(user);
    }

    public List<Message> getAllMessages(User user) {
        Optional<User> result = userRepository.findById(user.getId());
        return result.get().getMessages();
    }
}
