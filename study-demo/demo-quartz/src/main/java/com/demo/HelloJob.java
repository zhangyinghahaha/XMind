package com.demo;

import org.quartz.*;

/**
 * @author ying.zhang01
 */
@PersistJobDataAfterExecution
public class HelloJob implements Job {

    private static int count = 0;

    private String name;
    private int age;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        System.out.println("Hello Quartz: " + jobKey);
        System.out.println("JobDetail: " + context.getJobDetail());
        System.out.println("name: " + getName());
        System.out.println("age: " + getAge());
        jobDataMap.put("age", getAge()+1);
        count++;
        System.out.println("count: " + count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
