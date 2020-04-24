package com.sakura.usermanage.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.sakura.usermanage.entity.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Test1 {
    private Integer jobCount1 = 1;
    private Integer jobCount2 = 1;

    public static void main(String[] args) {
    }

    @Scheduled(fixedRate = 1000)
    @Async
    public void job1() {
        System.out.println(Thread.currentThread().getName() + ":[job1]每秒钟执行一次" +
                "目前第:" + jobCount1 + "次");
        jobCount1++;
    }
    @Scheduled(fixedRate = 1000)
    @Async
    public void job2() {
        System.out.println(Thread.currentThread().getName() + ":[job2]每秒钟执行一次" +
                "目前第:" + jobCount2 + "次");
        jobCount2++;
    }
}
