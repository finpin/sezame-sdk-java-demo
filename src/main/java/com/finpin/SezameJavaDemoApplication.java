package com.finpin;

import com.finpin.sezame.SezameRestClient;
import com.finpin.sezame.model.RegistrationRequest;
import com.finpin.sezame.model.RegistrationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;


@SpringBootApplication
public class SezameJavaDemoApplication {

    private static final String TEST_REGISTRATION_EMAIL = "test@gutschi.net";
    private static final String TEST_SERVICE_NAME = "JAVA test service";

    private static SezameRestClient restClient;

    private static final Logger log = LoggerFactory.getLogger(SezameJavaDemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SezameJavaDemoApplication.class, args);

		restClient = new SezameRestClient();
        initiateSslContextForHttpClient();

        RegistrationResponse response = restClient.registerClient(new RegistrationRequest(TEST_REGISTRATION_EMAIL, TEST_SERVICE_NAME));
        log.info(response.toString());
	}


    private static SSLContext initiateSslContextForHttpClient() {
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(restClient.getSslContext().getSocketFactory());
            return restClient.getSslContext();
        }
        catch (Exception e) {
            log.error("An error occurred trying to initiate the SSL context!\nError message: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }
}
