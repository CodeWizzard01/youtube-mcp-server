package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubeChannelService {
    private final YoutubeApiClient apiClient;

    public YoutubeChannelService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_channel_info",
        description = "Get information about a YouTube channel by channel ID."
    )
    public String getChannelInfo(String channelId) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet,statistics");
        params.put("id", channelId);
        return apiClient.get("/channels", params);
    }
}
