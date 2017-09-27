package paasta.delivery.pipeline.scheduler.service;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import paasta.delivery.pipeline.scheduler.common.Constants;
import paasta.delivery.pipeline.scheduler.common.RestTemplateService;
import paasta.delivery.pipeline.scheduler.model.CustomJob;

import java.util.*;

import static org.mockito.Mockito.when;

/**
 * deliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.service
 *
 * @author REX
 * @version 1.0
 * @since 9/27/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobServiceTest {

    private static final long JOB_ID = 2L;
    private static final String REPOSITORY_COMMIT_REVISION = "test-repository-commit-revision";

    private static CustomJob gTestJobDetailModel = null;
    private static CustomJob gTestResultJobModel = null;
    private static List<Map<String, Object>> gTestResultList = null;


    @Mock
    private RestTemplateService restTemplateService;

    @InjectMocks
    private JobService jobService;


    @Before
    public void setUp() throws Exception {
        Map<String, Object> gTestResultMap = new HashMap<>();

        gTestJobDetailModel = new CustomJob();
        gTestResultJobModel = new CustomJob();
        gTestResultList = new ArrayList<>();

        gTestJobDetailModel.setId(JOB_ID);
        gTestJobDetailModel.setRepositoryCommitRevision(REPOSITORY_COMMIT_REVISION);

        gTestResultMap.put("id", JOB_ID);
        gTestResultMap.put("jobTrigger", Constants.JOB_TRIGGER_MODIFIED_PUSH);
        gTestResultMap.put("repositoryCommitRevision", 1);
        gTestResultMap.put("lastJobStatus", Constants.RESULT_STATUS_SUCCESS);

        gTestResultList.add(gTestResultMap);
    }


    @After
    public void tearDown() throws Exception {
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////// MethodName_StateUnderTest_ExpectedBehavior
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test
    public void executeTriggerJobModifiedSourcesPushed_ReturnVoid() throws Exception {
        String reqUrl = "/jobs/" + JOB_ID + "/repositories";


        // GET BUILD JOB LIST FROM DATABASE
        when(restTemplateService.send(Constants.TARGET_COMMON_API, "/pipelines/-1/jobs/job-types/BUILD", HttpMethod.GET, null, List.class)).thenReturn(gTestResultList);
        // GET REPOSITORY INFO FROM CI SERVER
        when(restTemplateService.send(Constants.TARGET_DELIVERY_PIPELINE_API, reqUrl, HttpMethod.GET, null, CustomJob.class)).thenReturn(gTestJobDetailModel);
        // TRIGGER BUILD JOB
        when(restTemplateService.send(Constants.TARGET_DELIVERY_PIPELINE_API, "/jobs/trigger", HttpMethod.POST, gTestJobDetailModel, CustomJob.class)).thenReturn(gTestResultJobModel);


        // TEST
        jobService.triggerJobModifiedSourcesPushed();

    }

}