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
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.doNothing;

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
public class SchedulerServiceTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    private SchedulerService schedulerService;


    @Before
    public void setUp() throws Exception {
    }


    @After
    public void tearDown() throws Exception {
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////// MethodName_StateUnderTest_ExpectedBehavior
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test
    public void checkJobStatus_ReturnVoid() throws Exception {
        // TRIGGER JOB MODIFIED SOURCES PUSHED
        doNothing().when(jobService).triggerJobModifiedSourcesPushed();


        // TEST
        schedulerService.checkJobStatus();
    }

}