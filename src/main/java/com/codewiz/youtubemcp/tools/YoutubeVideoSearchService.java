package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubeVideoSearchService {
    private final YoutubeApiClient apiClient;

    public YoutubeVideoSearchService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_search",
        description = "Search for videos on YouTube using a query string."
    )
    public String searchVideos(String query, int maxResults) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet");
        params.put("q", query);
        params.put("maxResults", maxResults);
        return apiClient.get("/search", params);
    }
}
