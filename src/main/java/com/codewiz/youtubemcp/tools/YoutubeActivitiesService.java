package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubeActivitiesService {
    private final YoutubeApiClient apiClient;

    public YoutubeActivitiesService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_channel_activities",
        description = "List activities for a YouTube channel by channel ID. (Public activities only)"
    )
    public String listActivities(String channelId, int maxResults) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet,contentDetails");
        params.put("channelId", channelId);
        params.put("maxResults", maxResults);
        return apiClient.get("/activities", params);
    }
}
