package com.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * @author ying.zhang01
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            HolidayCalendar holidayCalendar = new HolidayCalendar();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());
            scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(), EverythingMatcher.allTriggers());

            scheduler.start();

            JobDetail job1 = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .storeDurably()
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
                    .startAt(DateBuilder.futureDate(5, DateBuilder.IntervalUnit.SECOND))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                    .forJob(JobKey.jobKey("job1", "group1"))
                    .build();
            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2", "group1")
                    .usingJobData("name", "zhang san")
                    .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
                    .forJob(JobKey.jobKey("job1", "group1"))
                    .build();
            scheduler.addJob(job1, true);
            scheduler.scheduleJob(trigger);
            scheduler.scheduleJob(trigger2);

            Thread.sleep(60000);

            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException se) {
            se.printStackTrace();
        }
    }
}
