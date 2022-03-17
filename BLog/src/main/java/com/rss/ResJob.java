package com.rss;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ResJob  {


//    @Scheduled(cron = "1 0 * * * ?")
    @Scheduled(cron = "0 0 * * * ? ")
    public void faceMatching() {
        System.out.println("开始");


    }

}
