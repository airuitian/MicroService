package org.newit.microservice.ebusiness.service;

import org.newit.microservice.ebusiness.model.User;
import org.newit.microservice.ebusiness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        userRepository.insert(user);
    }
}
