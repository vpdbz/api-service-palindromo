package com.walmart.platform.client;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestClient<EntityT>{
    private RestTemplate restTemplate;
    private String entityEndpoint;
    private Class<EntityT> entityType;

    @SuppressWarnings (value="unchecked")
    public RestClient(String entityEndpoint){
        this.entityEndpoint = entityEndpoint;
        this.entityType = (Class<EntityT>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate = new RestTemplate();
        this.restTemplate.setMessageConverters(messageConverters);
    }

    public EntityT getById(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        String url = String.format("%s/%s", this.entityEndpoint, id);
        
        return this.restTemplate.exchange(url, HttpMethod.GET, httpEntity, this.entityType).getBody();
    }
}