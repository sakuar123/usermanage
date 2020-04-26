package com.sakura.usermanage.config.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * springBoot全局监听器:监听程序销毁的时候
 */
@Slf4j
@Component
public class SpringBootEndListener implements ApplicationListener<ContextClosedEvent> {
//    @Override
//    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
//        Jedis jedis = new Jedis("localhost");
//        log.info("程序结束...");
//        jedis.set("userList", "");
//    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        log.info("SpringBoot销毁成功:");
    }
}
