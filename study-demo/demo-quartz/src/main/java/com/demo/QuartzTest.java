package com.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

/**
 * @author ying.zhang01
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            HolidayCalendar holidayCalendar = new HolidayCalendar();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            QueryParams queryParams = new QueryParams();

            JobDetail job1 = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("name", "zhang ying")
                    .usingJobData("age", 1)
                    .build();
            JobDetail job2 = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job2", "group1")
                    .usingJobData("name", "zhang ying")
                    .usingJobData("age", 1)
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .usingJobData("name", "zhang san")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                    .build();
            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2", "group1")
                    .usingJobData("name", "zhang san")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                    .build();
            scheduler.scheduleJob(job1, trigger);
            scheduler.scheduleJob(job1, trigger2);

            Thread.sleep(60000);

            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException se) {
            se.printStackTrace();
        }
    }
}
