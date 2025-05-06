package com.codewiz.youtubemcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class YoutubeThumbnailsService {
    private final YoutubeApiClient apiClient;

    public YoutubeThumbnailsService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_video_thumbnails",
        description = "Get thumbnail URLs for a YouTube video by video ID."
    )
    public String getThumbnails(String videoId) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet");
        params.put("id", videoId);
        return apiClient.get("/videos", params);
    }
}
