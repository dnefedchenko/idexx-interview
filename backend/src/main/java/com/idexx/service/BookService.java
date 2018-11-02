package com.idexx.service;

import com.idexx.model.Volume;
import com.idexx.model.VolumeItem;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {
    private static String VOLUME_URL = "https://www.googleapis.com/books/v1/volumes";

    private RestTemplate restTemplate;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VolumeItem> getVolumeItems(String term) {
        StringBuilder builder = new StringBuilder(VOLUME_URL);
        if (!StringUtils.isEmpty(term)) {
            builder.append("?q=").append(term);
        }
        Volume volumeResponse = restTemplate.getForObject(builder.toString(), Volume.class);
        return volumeResponse.getItems();
    }
}
