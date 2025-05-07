# YouTube-MCP

MCP(Model Context Protocol) server for Youtube search, transcript etc built using Java MCP SDK and Spring AI. For transcript extraction alone Javascript is used.

## Exposed Tools

- youtube_search: Search for videos on YouTube using a query string.
- youtube_transcript: Get transcript for a YouTube video by video ID.
- youtube_video_details: Get details of a YouTube video using its video ID.
- youtube_video_thumbnails: Get thumbnail URLs for a YouTube video by video ID.
- youtube_video_comments: List comments for a YouTube video by video ID. (Public comments only)
- youtube_channel_info: Get information about a YouTube channel by channel ID.
- youtube_channel_playlists: List playlists for a YouTube channel by channel ID.
- youtube_channel_sections: List channel sections (shelves) for a YouTube channel by channel ID.
- youtube_playlist_items: List videos in a YouTube playlist by playlist ID.
- youtube_activities: List activities for a YouTube channel by channel ID. (Public activities only)
- youtube_video_categories: List video categories available in a region.



## Running MCP Server and then connecting to it from MCP host

### Running MCP Server as docker container

Docker image is available on docker hub - https://hub.docker.com/r/codewizard01/youtube-mcp

#### Prerequisites
- Docker

```bash
docker run -e YOUTUBE_API_KEY=<your_api_key_here> -p 8085:8080 codewizard01/youtube-mcp:latest
```
This will start the MCP server on port 8085. 

Then add the following to your mcp config file to interact via SSE:

```json
{
  "youtube": {
    "mcp_server": "http://localhost:8085"
  }
}
```

### Running the MCP server from an IDE

### Prerequisites
- Java 24
- Maven 3.8.1
- Node
  

1. Clone the repository
2. Open the project in your IDE
3. Run the following command to build the project
```bash
mvn clean install
npm install
```
4. Run the following command to start the server
```bash
mvn spring-boot:run
```
5. The server will start on port 8080 by default. You can change the port in the application.properties file.


## Interacting with the MCP server via standard input output

Enable the below commented properties in the application.properties file to enable standard input output.

```properties
# For integration using stdio enable the below
#spring.ai.mcp.server.stdio=true
#spring.main.banner-mode=off
#spring.main.web-application-type=none
#logging.pattern.console=
#logging.file.name=youtube-mcp-spring.log
```

Run `mvn package` to build the jar file. The jar file will be created in the target directory.

Now add the below to your MCP config file in any MCP host like Claude desktop or Github Copilot  to interact via stdio:

```json
  "youtube-mcp": {
    "command": "java",
    "args": [
      "-jar", 
      "/Users/ratheesh/Projects/codewiz/youtube-mcp/target/youtube-mcp-0.0.1-SNAPSHOT.jar"
    ],
    "env": {
      "YOUTUBE_API_KEY": "<your_api_key_here>"
    }
  }
```


