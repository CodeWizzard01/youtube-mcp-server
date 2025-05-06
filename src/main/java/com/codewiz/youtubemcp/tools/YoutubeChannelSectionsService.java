package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubeChannelSectionsService {
    private final YoutubeApiClient apiClient;

    public YoutubeChannelSectionsService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_channel_sections",
        description = "List channel sections (shelves) for a YouTube channel by channel ID."
    )
    public String listChannelSections(String channelId) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet,contentDetails");
        params.put("channelId", channelId);
        return apiClient.get("/channelSections", params);
    }
}
