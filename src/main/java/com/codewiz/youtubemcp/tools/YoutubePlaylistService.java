package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubePlaylistService {
    private final YoutubeApiClient apiClient;

    public YoutubePlaylistService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_channel_playlists",
        description = "List playlists for a YouTube channel by channel ID."
    )
    public String listPlaylists(String channelId, int maxResults) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet");
        params.put("channelId", channelId);
        params.put("maxResults", maxResults);
        return apiClient.get("/playlists", params);
    }
}
