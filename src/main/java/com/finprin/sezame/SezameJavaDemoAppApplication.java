package com.finprin.sezame;

import com.finprin.sezame.model.RegistrationRequest;
import com.finprin.sezame.model.RegistrationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.finprin.sezame.SezameRestClient;


@SpringBootApplication
public class SezameJavaDemoAppApplication {

    private static final String TEST_REGISTRATION_EMAIL = "test@gutschi.net";
    private static final String TEST_SERVICE_NAME = "JAVA test service";

    private static final Logger log = LoggerFactory.getLogger(SezameJavaDemoAppApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SezameJavaDemoAppApplication.class, args);

		SezameRestClient client = new SezameRestClient();
        RegistrationResponse response = client.registerClient(new RegistrationRequest(TEST_REGISTRATION_EMAIL, TEST_SERVICE_NAME));
        log.info(response.toString());
	}
}
