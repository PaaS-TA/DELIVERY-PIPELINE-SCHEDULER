package paasta.delivery.pipeline.scheduler.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.common
 *
 * @author REX
 * @version 1.0
 * @since 9 /6/2017
 */
@Service
public class RestTemplateService {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";
    private final String commonApiBase64Authorization;
    private final String deliveryPipelineApiBase64Authorization;
    private final RestTemplate restTemplate;
    private String base64Authorization;
    private String baseUrl;


    // COMMON API
    @Value("${commonApi.url}")
    private String commonApiUrl;

    // DELIVERY PIPELINE API
    @Value("${deliveryPipelineApi.url}")
    private String deliveryPipelineApiUrl;


    /**
     * Instantiates a new Rest template service.
     *
     * @param restTemplate                             the rest template
     * @param commonApiAuthorizationId                 the common api authorization id
     * @param commonApiAuthorizationPassword           the common api authorization password
     * @param deliveryPipelineApiAuthorizationId       the delivery pipeline api authorization id
     * @param deliveryPipelineApiAuthorizationPassword the delivery pipeline api authorization password
     */
    @Autowired
    public RestTemplateService(RestTemplate restTemplate,
                               @Value("${commonApi.authorization.id}") String commonApiAuthorizationId,
                               @Value("${commonApi.authorization.password}") String commonApiAuthorizationPassword,
                               @Value("${deliveryPipelineApi.authorization.id}") String deliveryPipelineApiAuthorizationId,
                               @Value("${deliveryPipelineApi.authorization.password}") String deliveryPipelineApiAuthorizationPassword) {
        this.restTemplate = restTemplate;

        this.commonApiBase64Authorization = "Basic "
                + Base64Utils.encodeToString(
                (commonApiAuthorizationId + ":" + commonApiAuthorizationPassword).getBytes(StandardCharsets.UTF_8));
        this.deliveryPipelineApiBase64Authorization = "Basic "
                + Base64Utils.encodeToString(
                (deliveryPipelineApiAuthorizationId + ":" + deliveryPipelineApiAuthorizationPassword).getBytes(StandardCharsets.UTF_8));

    }


    /**
     * Send t.
     *
     * @param <T>          the type parameter
     * @param reqApi       the req api
     * @param reqUrl       the req url
     * @param httpMethod   the http method
     * @param bodyObject   the body object
     * @param responseType the response type
     * @return the t
     */
    public <T> T send(String reqApi, String reqUrl, HttpMethod httpMethod, Object bodyObject, Class<T> responseType) {
        procSetApiUrlAuthorization(reqApi);

        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.add(AUTHORIZATION_HEADER_KEY, base64Authorization);
        reqHeaders.add(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return restTemplate.exchange(baseUrl + reqUrl, httpMethod, new HttpEntity<>(bodyObject, reqHeaders), responseType).getBody();
    }


    private void procSetApiUrlAuthorization(String reqApi) {

        String apiUrl = "";
        String authorization = "";

        // COMMON API
        if (Constants.TARGET_COMMON_API.equals(reqApi)) {
            apiUrl = commonApiUrl;
            authorization = commonApiBase64Authorization;
        }

        // DELIVERY PIPELINE API
        if (Constants.TARGET_DELIVERY_PIPELINE_API.equals(reqApi)) {
            apiUrl = deliveryPipelineApiUrl;
            authorization = deliveryPipelineApiBase64Authorization;
        }

        this.base64Authorization = authorization;
        this.baseUrl = apiUrl;
    }

}
