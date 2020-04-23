package com.sakura.usermanage.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private Integer jobCount1 = 1;

//    @Scheduled(fixedRate = 1000)
//    @Async
//    public void job1() {
//        System.out.println(Thread.currentThread().getName() + ":[job1]每秒钟执行一次" +
//                "目前第:" + jobCount1 + "次");
//        jobCount1++;
//    }
}
