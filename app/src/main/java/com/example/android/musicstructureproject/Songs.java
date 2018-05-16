package com.example.android.musicstructureproject;


public class Songs {

    /**
     * Constant value that represents no image of small album cover was provided
     */

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * String resource ID for the name of the song
     */
    private int mSongNameId;
    /**
     * String resource ID for the name of the Album
     */

    private int mAlbumNameId;
    /**
     * Audio resource ID for the song
     */

    private int mAudioResourceId;
    /**
     * Resource ID of the image of the small album cover
     */

    private int mImageResourceId = R.drawable.defaulticon;
    /**
     * Resource ID of the image of the large album cover
     */

    private int mLargeImageResourceId = R.drawable.defaultimage;
    /**
     * Boolean value to show if the song in the custom playlist
     */

    private boolean mInTheCustomPlaylist;


    /**
     * Create a new Songs object without an image.
     *
     * @param songNameId      is the String resource ID for the name of the song
     * @param albumNameId     is the String resource ID for the name of the Album
     * @param audioResourceId is the resource ID for the audio file of the song
     */

    public Songs(int songNameId, int albumNameId, int audioResourceId, boolean inTheCustomPlaylist) {

        mSongNameId = songNameId;

        mAlbumNameId = albumNameId;

        mAudioResourceId = audioResourceId;

        mInTheCustomPlaylist = inTheCustomPlaylist;

    }


    /**
     * Create a new Songs object (image included).
     *
     * @param songNameId           is the String resource ID for the name of the song
     * @param albumNameId          is the String resource ID for the name of the album
     * @param imageResourceId      is the drawable resource ID for the image of  the small album cover
     * @param largeImageResourceId is the drawable resource ID for the image of  the large album cover
     * @param audioResourceId      is the resource ID for the audio file of the song
     */

    public Songs(int songNameId, int albumNameId, int imageResourceId, int largeImageResourceId,

                 int audioResourceId, boolean inTheCustomPlaylist) {

        mSongNameId = songNameId;

        mAlbumNameId = albumNameId;

        mImageResourceId = imageResourceId;

        mLargeImageResourceId = largeImageResourceId;

        mAudioResourceId = audioResourceId;

        mInTheCustomPlaylist = inTheCustomPlaylist;

    }


    /**
     * Get the string resource ID for the name of the song.
     */

    public int getSongNameId() {

        return mSongNameId;

    }

    /**
     * Get the string resource ID for the name of the album.
     */

    public int getAlbumNameId() {

        return mAlbumNameId;

    }


    /**
     * Return the image of the small album cover resource ID .
     */

    public int getImageResourceId() {

        return mImageResourceId;

    }


    /**
     * Return the image of the large album cover resource ID .
     */

    public int getLargeImageResourceId() {

        return mLargeImageResourceId;

    }


    /**
     * Returns whether or not there is a small  image of the album cover.
     */

    public boolean hasImage() {

        return mImageResourceId != NO_IMAGE_PROVIDED;

    }

    /**
     * Return the audio resource ID of the song.
     */

    public int getAudioResourceId() {

        return mAudioResourceId;

    }

    /**
     * Returns whether or not the song is added to the custom list.
     */

    public boolean customPlaylistAdded() {


        return mInTheCustomPlaylist;

    }

    /**
     * Add the song to the custom list.
     */

    public boolean addToCustomPlaylist() {
        mInTheCustomPlaylist = true;

        return mInTheCustomPlaylist;

    }


    /**
     * Remove the song from the custom list.
     */

    public boolean removeFromCustomPlaylist() {
        mInTheCustomPlaylist = false;

        return mInTheCustomPlaylist;

    }


}

