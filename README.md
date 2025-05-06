# YouTube-MCP

MCP(Model Context Protocol) server for Youtube search, transcript etc built using Spring Boot. For transcript extraction alone Javascript is used.


## Running MCP Server as docker container

This is already pushed to docker hub - https://hub.docker.com/r/codewizard01/youtube-mcp


### Running the server externally and then connecting to it from MCP host

#### Prerequisites
- Docker

```bash
docker run -e YOUTUBE_API_KEY=<your_api_key_here> -p 8085:8080 codewizard01/youtube-mcp:latest
```
This will start the MCP server on port 8085. 

Then add the following to your mcp config file:

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


