// get_transcript.js
// Usage: node get_transcript.js <videoId>
const { YoutubeTranscript } = require('youtube-transcript');

async function main() {
  const videoId = process.argv[2];
  if (!videoId) {
    console.log(JSON.stringify({ error: 'Usage: node get_transcript.js <videoId>' }));
    process.exit(1);
  }
  
  try {
    const transcript = await YoutubeTranscript.fetchTranscript(videoId);
    
    console.log(`# Transcript for YouTube Video: ${videoId}\n`);
    
    transcript.forEach((entry, index) => {
      // Clean up any HTML entities in the text
      const cleanText = entry.text.replace(/&amp;#39;/g, "'").replace(/&amp;#34;/g, '"');
      const timestamp = formatTimestamp(entry.offset);
      
      console.log(`[${timestamp}] : ${cleanText}`);
      
    });
    
  } catch (error) {
    console.log(JSON.stringify({ error: error.message }));
  }
}

// Helper function to format seconds into MM:SS format
function formatTimestamp(seconds) {
  const mins = Math.floor(seconds / 60);
  const secs = Math.floor(seconds % 60);
  return `${mins}:${secs.toString().padStart(2, '0')}`;
}

main();
