package org.newit.microservice.springmvc;

public class MyTime {
    private Long currentTime;

    public Long getCurrentTime() {
        return currentTime;
    }
    // test
    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }
}
