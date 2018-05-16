package com.example.android.musicstructureproject;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomPlaylistActivity extends AppCompatActivity {


    int globalPosition;

    // Handles playback of all the sound files
    private MediaPlayer mMediaPlayer;

    // Handles audio focus when playing a sound file
    private AudioManager mAudioManager;


    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener () {

        @Override

        public void onCompletion(MediaPlayer mediaPlayer) {

            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer ();
        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_custom_playlist);

        // Create a list of songs
        final ArrayList <Songs> songs = new ArrayList <Songs> ();
        songs.add (new Songs (R.string.song1, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song1, false));
        songs.add (new Songs (R.string.song2, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song2, false));
        songs.add (new Songs (R.string.song3, R.string.album1, R.drawable.album1icon, R.drawable.album1, R.raw.song3, true));
        songs.add (new Songs (R.string.song4, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song4, true));
        songs.add (new Songs (R.string.song5, R.string.album1, R.drawable.album1icon, R.drawable.album1, R.raw.song5, false));
        songs.add (new Songs (R.string.song6, R.string.album2, R.drawable.album2icon, R.drawable.album2, R.raw.song6, false));
        songs.add (new Songs (R.string.song7, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song7, true));
        songs.add (new Songs (R.string.song8, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song8, true));
        songs.add (new Songs (R.string.song9, R.string.album1, R.drawable.album1icon, R.drawable.album1, R.raw.song9, true));
        songs.add (new Songs (R.string.song10, R.string.album3, R.drawable.album3icon, R.drawable.album3, R.raw.song10, true));
        songs.add (new Songs (R.string.song11, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song11, true));
        songs.add (new Songs (R.string.song12, R.string.album4, R.drawable.album4icon, R.drawable.album4, R.raw.song12, false));
        songs.add (new Songs (R.string.song13, R.string.album5, R.drawable.album5icon, R.drawable.album5, R.raw.song13, false));
        songs.add (new Songs (R.string.song14, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song14, true));
        songs.add (new Songs (R.string.song15, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song15, true));
        songs.add (new Songs (R.string.song16, R.string.album6, R.drawable.album6icon, R.drawable.album6, R.raw.song16, true));
        songs.add (new Songs (R.string.song17, R.string.album5, R.drawable.album5icon, R.drawable.album5, R.raw.song17, false));
        songs.add (new Songs (R.string.song18, R.string.album3, R.drawable.album3icon, R.drawable.album3, R.raw.song18, false));


        //Create a list of only favorite songs
        final ArrayList <Songs> favoriteSongs = new ArrayList <Songs> ();
        for (int i = 0; i < songs.size (); i++) {
            Songs song = songs.get (i);
            if (song.customPlaylistAdded ()) {
                favoriteSongs.add (new Songs (song.getSongNameId (), song.getAlbumNameId (), song.getImageResourceId (), song.getLargeImageResourceId (), song.getAudioResourceId (), song.customPlaylistAdded ()));
            }
        }


        // Create an {@link SongsAdapter}, whose data source is a list of {@link Songs}. The
        // adapter knows how to create list items for each item in the list.
        final SongsAdapter adapter = new SongsAdapter (this, favoriteSongs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_custom_playlist.xml layout file.
        final ListView listView = (ListView) findViewById (R.id.list);

        // Make the {@link ListView} use the {@link SongsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Songs} in the list.
        listView.setAdapter (adapter);

        // Set a click listener to open NowPlaying Activity
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {

            @Override

            public void onItemClick(AdapterView <?> adapterView, View view, final int position, long l) {

                openTheSongMenu (position, favoriteSongs);
            }

        });


    }

    private void openTheSongMenu(int playListPosition, final ArrayList <Songs> favoriteSongs) {

        globalPosition = playListPosition;

        final Songs favoriteSong = favoriteSongs.get (playListPosition);
        setContentView (R.layout.activity_now_playing);

        // Find the View that shows the album cover image
        ImageView albumCoverImage = (ImageView) findViewById (R.id.album_cover);
        // Set the image from the ArrayList songs
        albumCoverImage.setImageResource (favoriteSong.getLargeImageResourceId ());

        // Find the TextView that shows the song name
        TextView songName = (TextView) findViewById (R.id.song_name);
        // Set the song name  from the ArrayList songs
        songName.setText (favoriteSong.getSongNameId ());

        // Find the TextView that shows the album name
        TextView albumName = (TextView) findViewById (R.id.album_name);
        // Set the song name  from the ArrayList songs
        albumName.setText (favoriteSong.getAlbumNameId ());

        // Find the Play Button ImageView
        ImageView playButton = (ImageView) findViewById (R.id.play_button);

        // Find the Stop Button ImageView
        ImageView stopButton = (ImageView) findViewById (R.id.stop_button);


        // Find the  Button that determines whether or not the song is favorite
        final ImageView favoriteButton = (ImageView) findViewById (R.id.favorite_button);
        // Set the image based on condition in the ArrayList songs
        favoriteButton.setImageResource (R.drawable.favoritered);


        // Find the Forward Button
        ImageView forwardButton = (ImageView) findViewById (R.id.forward_button);

        // Find the Previous Song Button ImageView
        ImageView backwardButton = (ImageView) findViewById (R.id.backward_button);

        // Find the Back To the Playlist Button
        Button backToPlaylistButton = (Button) findViewById (R.id.back_to_playlist_button);

        // Set a click listener on that Back To the Playlist Button
        backToPlaylistButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer ();
                Intent customAlbumIntent = new Intent (getBaseContext (), CustomPlaylistActivity.class);
                startActivity (customAlbumIntent);
            }
        });

        // Set a click listener on the forward Button
        forwardButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (globalPosition < (favoriteSongs.size () - 1)) {
                    releaseMediaPlayer ();
                    openTheSongMenu (globalPosition + 1, favoriteSongs);
                } else
                    Toast.makeText (getBaseContext (), R.string.end_of_playlist, Toast.LENGTH_SHORT).show ();
            }

        });

        // Set a click listener on the backward Button
        backwardButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (globalPosition > 0) {
                    releaseMediaPlayer ();
                    openTheSongMenu (globalPosition - 1, favoriteSongs);
                } else
                    Toast.makeText (getBaseContext (), R.string.end_of_playlist, Toast.LENGTH_SHORT).show ();
            }

        });


        // Set a click listener on the Play Button
        playButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                releaseMediaPlayer ();

                // Create and setup the {@link MediaPlayer} for the audio resource associated

                // with the PlayButton

                mMediaPlayer = MediaPlayer.create (getBaseContext (), favoriteSong.getAudioResourceId ());


                // Start the audio file

                mMediaPlayer.start ();


                // Setup a listener on the media player, so that we can stop and release the

                // media player once the sound has finished playing.

                mMediaPlayer.setOnCompletionListener (mCompletionListener);

            }

        });

        // Set a click listener on the Stop Button
        stopButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                releaseMediaPlayer ();

            }

        });


        // Set a click listener on the add to custom Playlist Button
        favoriteButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                favoriteButton.setImageResource (R.drawable.favoritewhite);
                favoriteSongs.remove (globalPosition);
            }


        });

    }


    @Override

    public void onStop() {

        super.onStop ();


        // When the activity is stopped, release the media player resources because we won't

        // be playing any more sounds.

        releaseMediaPlayer ();

    }


    /**
     * Clean up the media player by releasing its resources.
     */

    private void releaseMediaPlayer() {

        // If the media player is not null, then it may be currently playing a sound.

        if (mMediaPlayer != null) {

            // Regardless of the current state of the media player, release its resources

            // because we no longer need it.

            mMediaPlayer.release ();


            // Set the media player back to null. For our code, we've decided that

            // setting the media player to null is an easy way to tell that the media player

            // is not configured to play an audio file at the moment.

            mMediaPlayer = null;


        }
    }

}

