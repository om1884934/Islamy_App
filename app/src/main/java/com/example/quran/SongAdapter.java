package com.example.quran;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

// SongAdapter.java
// SongAdapter.java
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> songList;
    private MediaPlayer mediaPlayer;
    private int currentlyPlayingPosition = -1;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
        this.mediaPlayer = new MediaPlayer();
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        final Song song = songList.get(position);

        holder.bindData(song);

        holder.buttonPlay.setOnClickListener(v -> {
            if (currentlyPlayingPosition == position) {
                holder.togglePlayPause();
            } else {
                holder.playSong(song);
            }
        });

        holder.buttonStop.setOnClickListener(v -> {
            holder.stopSong();
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewSongTitle;
        public TextView textViewArtist;
        public Button buttonPlay;
        public Button buttonStop;
        private MediaPlayer mediaPlayer;
        private Song currentSong; // Track the currently bound song

        public SongViewHolder(View itemView) {
            super(itemView);
            textViewSongTitle = itemView.findViewById(R.id.textViewSongTitle);
            textViewArtist = itemView.findViewById(R.id.textViewArtist);
            buttonPlay = itemView.findViewById(R.id.buttonPlay);
            buttonStop = itemView.findViewById(R.id.buttonStop);
            this.mediaPlayer = new MediaPlayer();

            buttonPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSong(currentSong);
                }
            });

            buttonStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopSong();
                }
            });
        }

        public void bindData(Song song) {
            currentSong = song;
            textViewSongTitle.setText(song.getTitle());
            textViewArtist.setText(song.getArtist());
            buttonPlay.setText("Play");
            buttonPlay.setText(song.isPlaying() ? "Pause" : "Play");
            // Reset the text on play button
        }

        private void playSong(Song song) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                buttonPlay.setText("Play");
            } else {
                try {
                    mediaPlayer.setDataSource(itemView.getContext(),
                            Uri.parse("android.resource://" + itemView.getContext().getPackageName()
                                    + "/" + song.getAudioResourceId()));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    buttonPlay.setText("Pause");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void stopSong() {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                buttonPlay.setText("Play");
            }
        }

        private void resumeSong(Song song) {
            stopSong(); // Stop any currently playing song
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(itemView.getContext(),
                        Uri.parse("android.resource://" + itemView.getContext().getPackageName()
                                + "/" + song.getAudioResourceId()));
                mediaPlayer.prepare();
                mediaPlayer.start();
                song.setPlaying(true);
                currentlyPlayingPosition = getAdapterPosition();
                notifyDataSetChanged();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void pauseSong() {
            mediaPlayer.pause();
            songList.get(currentlyPlayingPosition).setPlaying(false);
            notifyDataSetChanged();
        }


        public void togglePlayPause() {
            Song song = songList.get(getAdapterPosition());
            if (song.isPlaying()) {
                pauseSong();
            } else {
                resumeSong(song);
            }
        }
    }
}


