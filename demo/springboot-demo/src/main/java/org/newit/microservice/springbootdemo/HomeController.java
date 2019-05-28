package org.newit.microservice.springbootdemo;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("time", Calendar.getInstance().getTime());
        return "index";
    }

    @RequestMapping("/currentTime")
    @ResponseBody
    public CurrentTime currentTime(){
        CurrentTime currentTime = new CurrentTime();
        currentTime.setTimestamp(System.currentTimeMillis());
        return currentTime;
    }
}
