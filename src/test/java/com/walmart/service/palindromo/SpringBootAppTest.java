package com.walmart.service.palindromo;

import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.walmart.service.palindromo.dto.DataProductsResponse;
import com.walmart.service.palindromo.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootAppTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testOkFindById() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/palindromo/search/id/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try {
            restTemplate.exchange(uri, HttpMethod.GET, entity, Product.class);
        } catch (HttpClientErrorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testBadRequestFindById() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/palindromo/search/id/1la";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try {
            restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            fail("Error 400");
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void testOkFindByDescription() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/palindromo/search/string/als";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try {
            ResponseEntity<DataProductsResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, DataProductsResponse.class);
            
            if (responseEntity.getBody().getData() == null || responseEntity.getBody().getData().size() == 0) {
                fail("Error, products list is empty");
            }
        } catch (HttpClientErrorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testResultZeroFindByDescription() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/palindromo/search/string/nodeberiaencontrarestestring";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try {
            ResponseEntity<DataProductsResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, DataProductsResponse.class);
            
            if (responseEntity.getBody().getData() != null && responseEntity.getBody().getData().size() > 0) {
                fail("Error, product list is not empty");
            }
        } catch (HttpClientErrorException e) {
            fail(e.getMessage());
        }
    }

}
