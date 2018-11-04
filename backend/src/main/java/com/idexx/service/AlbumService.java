package com.idexx.service;

import com.google.gson.Gson;
import com.idexx.model.AlbumSearchResult;
import com.idexx.model.AlbumTrack;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    @Value("${album.url}")
    private String ALBUMS_URL;

    @Value("${upstream.results-limit}")
    private String limit;

    private RestTemplate restTemplate;
    private Gson gson;

    public AlbumService(RestTemplate restTemplate, Gson gson) {
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    public List<AlbumTrack> getAlbums(String term, String countryCode) {
        StringBuilder builder = new StringBuilder(ALBUMS_URL);
        if (!StringUtils.isEmpty(term)) {
            builder.append("?q=").append(term);
        }
        if (!StringUtils.isEmpty(countryCode)) {
            builder.append("&country=").append(countryCode);
        }

        ResponseEntity<String> response = restTemplate.getForEntity(builder.toString(), String.class);
        AlbumSearchResult albumSearchResult = gson.fromJson(response.getBody(), AlbumSearchResult.class);
        return albumSearchResult.getResults().stream().limit(Integer.valueOf(limit)).collect(Collectors.toList());
    }
}
