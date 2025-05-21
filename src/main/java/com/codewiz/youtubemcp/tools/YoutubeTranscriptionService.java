package com.codewiz.youtubemcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class YoutubeTranscriptionService {

    @Tool(
            name = "youtube_transcript",
            description = "Get transcript for a YouTube video by video ID."
    )
    public String getTranscript(String videoId) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                "node", "get_transcript.js", videoId
            );
            pb.redirectErrorStream(true);
            Process process = pb.start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String output = reader.lines().collect(Collectors.joining("\n"));
                int exitCode = process.waitFor();
                return output;
            }
        } catch (Exception e) {
            return "{\"error\": \"" + e.getMessage().replace("\"", "'") + "\"}";
        }
    }
}
