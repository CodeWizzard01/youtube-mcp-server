package com.codewiz.youtubemcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class YoutubeVideoDetailsService {
    private final YoutubeApiClient apiClient;

    public YoutubeVideoDetailsService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_video_details",
        description = "Get details of a YouTube video using its video ID."
    )
    public String getVideoDetails(String videoId) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet,contentDetails,statistics");
        params.put("id", videoId);
        return apiClient.get("/videos", params);
    }
}
