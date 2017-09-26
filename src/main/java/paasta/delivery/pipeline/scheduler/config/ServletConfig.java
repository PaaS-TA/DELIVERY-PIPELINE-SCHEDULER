package paasta.delivery.pipeline.scheduler.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import paasta.delivery.pipeline.scheduler.Application;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.config
 *
 * @author REX
 * @version 1.0
 * @since 9/6/2017
 */
@Configuration
public class ServletConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
