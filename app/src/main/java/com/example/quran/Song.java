package com.example.quran;


    public class Song {
        private String title;
        private String artist;

        private static int audioResourceId;

        // Add more attributes as needed

        public Song(String title, String artist,int audioResourceId) {
            this.title = title;
            this.artist = artist;
            this.audioResourceId = audioResourceId;
        }

        public String getTitle() {

            return title;
        }

        public String getArtist() {
            return artist;
        }

        public static int getAudioResourceId() {
            return audioResourceId;
        }
        // Add getters and setters as needed
        private boolean isPlaying;

        public boolean isPlaying() {
            return isPlaying;
        }

        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }
    }


