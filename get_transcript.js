// get_transcript.js
// Usage: node get_transcript.js <videoId>
const { YoutubeTranscript } = require('youtube-transcript');

async function main() {
  const videoId = process.argv[2];
  if (!videoId) {
    console.log(JSON.stringify({ error: 'Usage: node get_transcript.js <videoId>' }));
    process.exit(1);
  }
  YoutubeTranscript.fetchTranscript(videoId).then(console.log);
}

main();
