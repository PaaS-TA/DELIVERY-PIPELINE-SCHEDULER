package paasta.delivery.pipeline.scheduler.config;

import org.quartz.SimpleTrigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import paasta.delivery.pipeline.scheduler.job.SchedulerJob;
import paasta.delivery.pipeline.scheduler.quartz.QuartzJobFactory;

import java.util.Properties;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.config
 *
 * @author REX
 * @version 1.0
 * @since 8 /3/2017
 */
@Configuration
public class QuartzConfig {

    @Value("${org.quartz.scheduler.instanceName}")
    private String instanceName;

    @Value("${org.quartz.scheduler.instanceId}")
    private String instanceId;

    @Value("${org.quartz.threadPool.threadCount}")
    private String threadCount;

    @Value("${job.startDelay}")
    private Long startDelay;

    @Value("${job.repeatInterval}")
    private Long repeatInterval;

    @Value("${job.description}")
    private String description;

    @Value("${job.key}")
    private String key;


    /**
     * Job factory job factory.
     *
     * @param applicationContext the application context
     * @return the job factory
     */
    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        QuartzJobFactory quartzJobFactory = new QuartzJobFactory();
        quartzJobFactory.setApplicationContext(applicationContext);

        return quartzJobFactory;
    }


    /**
     * Scheduler factory bean scheduler factory bean.
     *
     * @param applicationContext the application context
     * @return the scheduler factory bean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        Properties quartzProperties = new Properties();

        quartzProperties.setProperty("org.quartz.scheduler.instanceName", instanceName);
        quartzProperties.setProperty("org.quartz.scheduler.instanceId", instanceId);
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", threadCount);

        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory(applicationContext));
        factory.setQuartzProperties(quartzProperties);
        factory.setTriggers(schedulerJobTrigger().getObject());

        return factory;
    }


    /**
     * Scheduler job trigger simple trigger factory bean.
     *
     * @return the simple trigger factory bean
     */
    @Bean(name = "schedulerJobTrigger")
    public SimpleTriggerFactoryBean schedulerJobTrigger() {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();

        factoryBean.setJobDetail(schedulerJobDetails().getObject());
        factoryBean.setStartDelay(startDelay);
        factoryBean.setRepeatInterval(repeatInterval);
        factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);

        return factoryBean;
    }


    /**
     * Scheduler job details job detail factory bean.
     *
     * @return the job detail factory bean
     */
    @Bean(name = "schedulerJobDetails")
    public JobDetailFactoryBean schedulerJobDetails() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();

        jobDetailFactoryBean.setJobClass(SchedulerJob.class);
        jobDetailFactoryBean.setDescription(description);
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setName(key);

        return jobDetailFactoryBean;
    }

}