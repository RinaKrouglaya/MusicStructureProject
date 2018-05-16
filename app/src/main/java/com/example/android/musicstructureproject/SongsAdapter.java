package com.example.android.musicstructureproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link SongsAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * <p>
 * based on a data source, which is a list of {@link Songs} objects.
 */

public class SongsAdapter extends ArrayAdapter <Songs> {


    /**
     * Create a new {@link SongsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs   is the list of {@link Songs} to be displayed.
     */

    public SongsAdapter(Context context, ArrayList <Songs> songs) {

        super (context, 0, songs);


    }


    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view

        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from (getContext ()).inflate (

                    R.layout.playlist_item, parent, false);

        }


        // Get the {@link Songs} object located at this position in the list

        final Songs currentSong = getItem (position);


        // Find the TextView in the playlist_item.xml layout with the ID song_name.

        TextView songNameTextView = (TextView) listItemView.findViewById (R.id.song_name);

        // Get the song_name from the currentSong object and set this text on

        // the songNameTextView.

        songNameTextView.setText (currentSong.getSongNameId ());


        // Find the TextView in the playlist_item.xml layout with the ID album_name.

        TextView albumNameTextView = (TextView) listItemView.findViewById (R.id.album_name);

        // Get the album_name from the currentSong object and set this text on

        // the albumNameTextView.

        albumNameTextView.setText (currentSong.getAlbumNameId ());


        // Find the ImageView in the playlist_item.xml layout with the ID album_icon.

        ImageView imageView = (ImageView) listItemView.findViewById (R.id.album_icon);

        // Check if an image is provided for this song or not

        if (currentSong.hasImage ()) {

            // If an image is available, display the provided image based on the resource ID

            imageView.setImageResource (currentSong.getImageResourceId ());

            // Make sure the view is visible

            imageView.setVisibility (View.VISIBLE);

        } else {

            // Otherwise hide the ImageView (set visibility to GONE)

            imageView.setVisibility (View.GONE);

        }

        // Find the ImageView in the playlist_item.xml layout with the ID favorite_button.


        // Return the whole list item layout (so that it can be shown in

        // the ListView.


        return listItemView;

    }

}