package org.newit.microservice.middleware.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    public User getUserById(int id){
        User user = new User();
        user.setId(id);
        user.setName(UUID.randomUUID().toString());
        return user;
    }


}
