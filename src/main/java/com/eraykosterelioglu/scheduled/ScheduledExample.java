package com.eraykosterelioglu.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {

    @Scheduled(cron = "*/5 * * * * *")
    public void print_arr() {
        for(int i=0;i<=10;i++) {
            System.out.println(i + " ");
        }
    }
}
