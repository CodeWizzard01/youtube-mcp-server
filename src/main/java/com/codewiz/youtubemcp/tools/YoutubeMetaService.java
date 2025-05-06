package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubeMetaService {
    private final YoutubeApiClient apiClient;

    public YoutubeMetaService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_video_categories",
        description = "List video categories available in a region."
    )
    public String listVideoCategories(String regionCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet");
        params.put("regionCode", regionCode);
        return apiClient.get("/videoCategories", params);
    }
}
