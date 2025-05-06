package com.codewiz.youtubemcp.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class YoutubePlaylistItemsService {
    private final YoutubeApiClient apiClient;

    public YoutubePlaylistItemsService(YoutubeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Tool(
        name = "youtube_playlist_items",
        description = "List videos in a YouTube playlist by playlist ID."
    )
    public String listPlaylistItems(String playlistId, int maxResults) {
        Map<String, Object> params = new HashMap<>();
        params.put("part", "snippet");
        params.put("playlistId", playlistId);
        params.put("maxResults", maxResults);
        return apiClient.get("/playlistItems", params);
    }
}
