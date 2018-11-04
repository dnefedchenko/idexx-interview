package com.idexx.service;

import com.idexx.model.Volume;
import com.idexx.model.VolumeItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Value("${volume.url}")
    private String VOLUME_URL;

    @Value("${upstream.results-limit}")
    private String limit;

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
        return volumeResponse.getItems().stream().limit(Integer.valueOf(limit)).collect(Collectors.toList());
    }
}
