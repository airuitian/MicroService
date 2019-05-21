package org.newit.microservice.databasedemo.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Date createdTime;
}
