package paasta.delivery.pipeline.scheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.config
 *
 * @author REX
 * @version 1.0
 * @since 9/6/2017
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Rest template rest template.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
