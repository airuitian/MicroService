package org.newit.microservice.databasedemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.newit.microservice.databasedemo.model.User;

@Mapper
public interface UserMapper {
    int insert(User user);

    User selectById(Long userId);
}
