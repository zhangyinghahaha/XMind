package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ThreadPoolTests {
    private static final Logger logger = LoggerFactory.getLogger(TransactionTest.class);

    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExecutorService() {
        Runnable task = () -> {logger.debug("Hello ExecutorService!");};

        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }

        sleep(10*1000);
    }

    @Test
    public void testSchedulerExecutorService() {
        Runnable task = () -> {logger.debug("Hello SchedulerExecutorService!");};

        scheduledExecutorService.scheduleAtFixedRate(task, 1000, 1000, TimeUnit.MILLISECONDS);

        sleep(10*1000);
    }

    @Test
    public void testSpringExecutorService() {
        Runnable task = () -> {logger.debug("Hello ExecutorService!");};

        for (int i = 0; i < 10; i++) {
            threadPoolTaskExecutor.submit(task);
        }

        sleep(10*1000);
    }

    @Test
    public void testSpringSchedulerExecutorService() {
        Runnable task = () -> {logger.debug("Hello SchedulerExecutorService!");};

        threadPoolTaskScheduler.scheduleAtFixedRate(task, new Date(), 1000);
        sleep(10*1000);
    }
}
