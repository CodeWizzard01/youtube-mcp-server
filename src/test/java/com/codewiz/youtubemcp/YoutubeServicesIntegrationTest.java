package com.codewiz.youtubemcp;

import com.codewiz.youtubemcp.tools.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class YoutubeServicesIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(YoutubeServicesIntegrationTest.class);

    @Autowired YoutubeVideoSearchService videoSearchService;
    @Autowired YoutubeVideoDetailsService videoDetailsService;
    @Autowired YoutubeChannelService channelService;
    @Autowired YoutubePlaylistService playlistService;
    @Autowired YoutubePlaylistItemsService playlistItemsService;
    @Autowired YoutubeCommentsService commentsService;
    @Autowired YoutubeActivitiesService activitiesService;
    @Autowired YoutubeMetaService metaService;
    @Autowired YoutubeThumbnailsService thumbnailsService;
    @Autowired YoutubeTranscriptionService transcriptionService;
    @Autowired YoutubeChannelSectionsService channelSectionsService;

    @Test
    void testSearchVideos() {
        String response = videoSearchService.searchVideos("Microservices Resilience Patterns Spring", 1);
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }

    @Test
    void testGetVideoDetails() {
        String response = videoDetailsService.getVideoDetails("GwKRRsjfBOA");
        assertNotNull(response);
        assertTrue(response.contains("snippet"));
    }

    @Test
    void testGetChannelInfo() {
        String response = channelService.getChannelInfo("UC_x5XG1OV2P6uZZ5FSM9Ttw");
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }

    @Test
    void testListPlaylists() {
        String response = playlistService.listPlaylists("UC_x5XG1OV2P6uZZ5FSM9Ttw", 1);
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }

    @Test
    void testListPlaylistItems() {
        // Use a known playlist ID (Google Developers)
        String response = playlistItemsService.listPlaylistItems("PLOU2XLYxmsIIuDZXFpPEM85OReP_NV3tI", 1);
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }

    @Test
    void testListComments() {
        String response = commentsService.listComments("dQw4w9WgXcQ", 1);
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }

    @Test
    void testListActivities() {
        String response = activitiesService.listActivities("UC_x5XG1OV2P6uZZ5FSM9Ttw", 1);
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }

    @Test
    void testListVideoCategories() {
        String response = metaService.listVideoCategories("US");
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }

    @Test
    void testGetThumbnails() {
        String response = thumbnailsService.getThumbnails("dQw4w9WgXcQ");
        assertNotNull(response);
        assertTrue(response.contains("thumbnails"));
    }

    @Test
    void testGetTranscript() {
        String videoId = "7j1t3UZA1TY";
        String result = transcriptionService.getTranscript(videoId);
        assertNotNull(result);
    }

    @Test
    void testListChannelSections() {
        // Use a known channel ID (Google Developers)
        String response = channelSectionsService.listChannelSections("UC_x5XG1OV2P6uZZ5FSM9Ttw");
        assertNotNull(response);
        assertTrue(response.contains("items"));
    }


}


