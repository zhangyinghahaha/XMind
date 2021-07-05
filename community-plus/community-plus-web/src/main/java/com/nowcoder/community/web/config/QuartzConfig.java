package com.nowcoder.community.web.config;

import com.nowcoder.community.quartz.AlphaJob;
import com.nowcoder.community.quartz.PostScoreRefreshJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author ying.zhang01
 */
@Configuration
public class QuartzConfig {
    // FactoryBean简化Bean的实例化过程

    // @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(AlphaJob.class);
        factoryBean.setName("alphaJob");
        factoryBean.setGroup("alphaJobGroup");
        factoryBean.setDurability(true);
        factoryBean.setRequestsRecovery(true);
        return factoryBean;
    }

    // @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetail jobDetail) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setName("alphaTrigger");
        factoryBean.setGroup("alphaTriggerGroup");
        factoryBean.setRepeatInterval(3000);
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }

    @Bean
    public JobDetail postScoreRefreshJob() {
        return JobBuilder.newJob(PostScoreRefreshJob.class)
                .withIdentity("postScoreRefreshJob", "communityGroup")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger postScoreRefreshTrigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity("postScoreRefreshTrigger", "communityGroup")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(5)
                        .repeatForever()
                )
                .forJob(postScoreRefreshJob())
                .build();
    }
}
