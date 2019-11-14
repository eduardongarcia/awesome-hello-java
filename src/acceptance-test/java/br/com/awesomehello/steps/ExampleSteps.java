package br.com.awesomehello.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

public class ExampleSteps {
    private String result;

    private HttpStatus httpStatus;

    private HttpHeaders httpHeaders;

    private HttpClientErrorException error;

    @Quando("o cliente chama {string}")
    public void performGetRequest(final String endpoint) {
        this.doGet(endpoint);
    }

    @Entao("o cliente recebe status {string}")
    public void checkResultStatusCode(final String status) {
        assertEquals(HttpStatus.valueOf(status), this.httpStatus);
    }

    @E("o cliente recebe {string}")
    public void checkResultValue(final String value) {
        assertEquals(value, this.result);
    }

    private void doGet(final String endpoint) {
        this.clean();
        final String url = "http://localhost:8080" + endpoint;

        final RestTemplate restTemplate = new RestTemplate();
        try {
            final ResponseEntity<String> response = restTemplate.getForEntity(url,
                    String.class);
            this.result = response.getBody();
            this.httpStatus = response.getStatusCode();
            this.httpHeaders = response.getHeaders();
        } catch (final HttpClientErrorException e) {
            this.error = e;
        }
    }

    private void clean() {
        this.result = null;
        this.error = null;
        this.httpStatus = null;
        this.httpHeaders = null;
    }

}
