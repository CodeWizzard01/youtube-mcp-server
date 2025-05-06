package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubeCommentsService {
    private final YoutubeApiClient apiClient;

    public YoutubeCommentsService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_video_comments",
        description = "List comments for a YouTube video by video ID. (Public comments only)"
    )
    public String listComments(String videoId, int maxResults) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet");
        params.put("videoId", videoId);
        params.put("maxResults", maxResults);
        return apiClient.get("/commentThreads", params);
    }
}
