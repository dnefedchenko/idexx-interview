package com.idexx;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {
    private static String VOLUME_URL = "https://www.googleapis.com/books/v1/volumes";

    private RestTemplate restTemplate;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getBooks(String term) {
        StringBuilder builder = new StringBuilder(VOLUME_URL);
        if (!StringUtils.isEmpty(term)) {
            builder.append("?q=").append(term);
        }
        return restTemplate.getForEntity(builder.toString(), String.class);
    }
}
