package com.demo;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.listeners.JobListenerSupport;

/**
 * @author ying.zhang01
 */
public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        return "My Job Listener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("Job to be executed");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("Job Execution Vetoed");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("Job was executed");
    }
}
