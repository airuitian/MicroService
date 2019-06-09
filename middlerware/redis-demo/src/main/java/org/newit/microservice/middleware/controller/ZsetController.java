package org.newit.microservice.middleware.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/zset")
public class ZsetController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestParam("name") String name, @RequestParam("age") int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        String userStr= JSONObject.toJSONString(user);
        redisTemplate.opsForZSet().add("userList", userStr,age);
        return "success";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public Object getUserList(){
        List<User> result = new ArrayList();
        Set<String> userList = redisTemplate.opsForZSet().range("userList",0, -1);
        Iterator<String> iterator = userList.iterator();
        while(iterator.hasNext()){
            User user = JSONObject.parseObject(iterator.next(), User.class);
            result.add(user);
        }
        return result;
    }
}
