FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app
COPY target/youtube-mcp-0.0.1-SNAPSHOT.jar app.jar
COPY get_transcript.js get_transcript.js
COPY package.json package.json
RUN apk add --no-cache nodejs npm
RUN npm install
EXPOSE 8080
ENV YOUTUBE_API_KEY=""
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
