package paasta.delivery.pipeline.scheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import paasta.delivery.pipeline.scheduler.common.Constants;
import paasta.delivery.pipeline.scheduler.common.RestTemplateService;
import paasta.delivery.pipeline.scheduler.model.CustomJob;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.service
 *
 * @author REX
 * @version 1.0
 * @since 9 /7/2017
 */
@Service
public class JobService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobService.class);
    private final RestTemplateService restTemplateService;


    /**
     * Instantiates a new Job service.
     *
     * @param restTemplateService the rest template service
     */
    @Autowired
    public JobService(RestTemplateService restTemplateService) {this.restTemplateService = restTemplateService;}


    /**
     * Check modified push.
     */
    void checkModifiedPush() {
        LOGGER.info("########## CHECK MODIFIED PUSH :: {} {}", LocalDate.now(), LocalTime.now());

        String requestJobId;
        String currentJobTrigger;
        String originalRepositoryCommitRevision;
        String currentRepositoryCommitRevision;
        String currentLastJobStatus;

        // GET BUILD JOB LIST
        List buildJobList = procGetBuildJobListFromDB();

        for (Object aBuildJobList : buildJobList) {
            Map<String, Object> map = (Map<String, Object>) aBuildJobList;
            requestJobId = String.valueOf(map.get("id"));
            currentJobTrigger = String.valueOf(map.get("jobTrigger"));
            originalRepositoryCommitRevision = String.valueOf(map.get("repositoryCommitRevision"));
            currentLastJobStatus = String.valueOf(map.get("lastJobStatus"));

            // CHECK REPOSITORY COMMIT REVISION
            currentRepositoryCommitRevision = procGetRepositoryInfoFromCiServer(requestJobId).getRepositoryCommitRevision();

            // COMPARE ORIGINAL REPOSITORY COMMIT REVISION TO CURRENT REPOSITORY COMMIT REVISION
            if (!originalRepositoryCommitRevision.equals(currentRepositoryCommitRevision)
                    && Constants.JOB_TRIGGER_MODIFIED_PUSH.equals(currentJobTrigger)
                    && !(Constants.RESULT_STATUS_JOB_WORKING.equals(currentLastJobStatus) || Constants.RESULT_STATUS_BUILT_FILE_UPLOADING.equals(currentLastJobStatus))) {
                // TRIGGER BUILD JOB
                procSetTriggerBuildJobToCiServer(requestJobId);
            }
        }
    }


    // Get Build Job List From DB
    private List procGetBuildJobListFromDB() {
        String reqUrl = "/pipelines/-1/jobs/job-types/BUILD";
        return restTemplateService.send(Constants.TARGET_COMMON_API, reqUrl, HttpMethod.GET, null, List.class);
    }


    // Get Repository Info From Ci Server
    private CustomJob procGetRepositoryInfoFromCiServer(String requestJobId) {
        String reqUrl = "/jobs/" + requestJobId + "/repositories";
        return restTemplateService.send(Constants.TARGET_DELIVERY_PIPELINE_API, reqUrl, HttpMethod.GET, null, CustomJob.class);
    }


    // Trigger Build Job To Ci Server
    private void procSetTriggerBuildJobToCiServer(String requestJobId) {
        LOGGER.info("################################################################################");
        LOGGER.info("## TRIGGER BUILD JOB :: ID :: {} :: {} {}", requestJobId, LocalDate.now(), LocalTime.now());
        LOGGER.info("################################################################################");
        LOGGER.info("");


        // SET PARAM :: TRIGGER BUILD JOB
        CustomJob requestJobModel = new CustomJob();
        requestJobModel.setId(Long.valueOf(requestJobId));
        requestJobModel.setSchedulerModifiedPushYn(Constants.CHECK_YN_Y);

        // TRIGGER BUILD JOB
        restTemplateService.send(Constants.TARGET_DELIVERY_PIPELINE_API, "/jobs/trigger", HttpMethod.POST, requestJobModel, CustomJob.class);
    }

}
