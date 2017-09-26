package paasta.delivery.pipeline.scheduler.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import paasta.delivery.pipeline.scheduler.service.SchedulerService;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.job
 *
 * @author REX
 * @version 1.0
 * @since 8 /3/2017
 */
public class SchedulerJob implements Job {

    @Autowired
    private SchedulerService schedulerService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        schedulerService.getJobStatus();
    }

}
