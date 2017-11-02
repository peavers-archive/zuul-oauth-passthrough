package zuul.oauth.passthrough.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@CrossOrigin
@RestController
public class InstanceQueryGatewayRestController {

    private final RestTemplate restTemplate;

    private final static String SERVICE = "http://localhost:8081";

    @Autowired
    public InstanceQueryGatewayRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/instances")
    public ResponseEntity<String> listAllInstances() {
        ParameterizedTypeReference<String> reference = new ParameterizedTypeReference<String>() {
        };

        return restTemplate.exchange(SERVICE, HttpMethod.GET, null, reference);
    }
}