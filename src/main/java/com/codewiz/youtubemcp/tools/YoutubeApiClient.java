package com.codewiz.youtubemcp.tools;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class YoutubeApiClient {
    private static final Logger logger = LoggerFactory.getLogger(YoutubeApiClient.class);
    private final String apiKey;
    private final RestClient restClient;
    private static final String API_BASE_URL = "https://www.googleapis.com/youtube/v3";

    public YoutubeApiClient(@Value("${youtube.api.key}") String apiKey) {
        this.apiKey = apiKey;
        this.restClient = RestClient.builder().build();
    }

    public String get(String endpoint, Map<String, Object> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL + endpoint)
                .queryParam("key", apiKey);
        if (params != null) {
            params.forEach(builder::queryParam);
        }
        String url = builder.toUriString();
        logger.info("[YoutubeApiClient] Sending GET request: {}", url);
        ResponseEntity<String> response = restClient.get().uri(url).retrieve().toEntity(String.class);
        logger.info("[YoutubeApiClient] Response: {}", response.getBody());
        return response.getBody();
    }
}
