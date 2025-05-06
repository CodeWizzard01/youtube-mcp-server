package com.codewiz.youtubemcp;

import com.codewiz.youtubemcp.tools.*;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YoutubeMcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeMcpApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider youtubeToolsCallbackProvider(
			YoutubeActivitiesService youtubeActivitiesService,
			YoutubeChannelService youtubeChannelService,
			YoutubeCommentsService youtubeCommentsService,
			YoutubeMetaService youtubeMetaService,
			YoutubePlaylistItemsService youtubePlaylistItemsService,
			YoutubePlaylistService youtubePlaylistService,
			YoutubeThumbnailsService youtubeThumbnailsService,
			YoutubeVideoDetailsService youtubeVideoDetailsService,
			YoutubeVideoSearchService youtubeVideoSearchService,
			YoutubeChannelSectionsService youtubeChannelSectionsService,
			YoutubeTranscriptionService youtubeTranscriptionService
	) {
		var toolCallbackProvider = MethodToolCallbackProvider.builder()
				.toolObjects(
					youtubeActivitiesService,
					youtubeChannelService,
					youtubeCommentsService,
					youtubeMetaService,
					youtubePlaylistItemsService,
					youtubePlaylistService,
					youtubeThumbnailsService,
					youtubeVideoDetailsService,
					youtubeVideoSearchService,
					youtubeChannelSectionsService,
					youtubeTranscriptionService
				)
				.build();
		return toolCallbackProvider;
	}

	/*@Bean
	public CommandLineRunner testYoutubeTools(YoutubeTools youtubeTools) {
		return args -> {
			System.out.println("Testing YoutubeTools...");
			try {
				String searchResult = youtubeTools.searchVideos("Spring Boot tutorial", 1);
				System.out.println("Search Result: " + searchResult);
				// Optionally, extract a videoId from searchResult and test getVideoDetails
			} catch (Exception e) {
				System.err.println("Error testing YoutubeTools: " + e.getMessage());
			}
		};
	}*/
}
