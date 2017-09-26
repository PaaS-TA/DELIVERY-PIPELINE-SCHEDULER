package paasta.delivery.pipeline.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.service
 *
 * @author REX
 * @version 1.0
 * @since 8 /3/2017
 */
@Service
public class SchedulerService {

    private final JobService jobService;


    /**
     * Instantiates a new Scheduler service.
     *
     * @param jobService the job service
     */
    @Autowired
    public SchedulerService(JobService jobService) {this.jobService = jobService;}

    /**
     * Gets job status.
     */
    public void getJobStatus() {
        // CALL CHECKING MODIFIED PUSH OF JOB SERVICE
        jobService.checkModifiedPush();
    }

}
