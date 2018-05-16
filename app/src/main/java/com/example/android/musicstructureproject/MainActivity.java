package com.example.android.musicstructureproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        // Find the View that shows the mix_album category
        Button mixAlbum = (Button) findViewById (R.id.mix_album);

// Set a click listener on that View
        mixAlbum.setOnClickListener (new View.OnClickListener () {
            // The code in this method will be executed when the mix_album View is clicked on.
            @Override
            public void onClick(View view) {
                Intent mixAlbumIntent = new Intent (MainActivity.this, MixAlbumActivity.class);
                startActivity (mixAlbumIntent);
            }
        });

        // Find the View that shows the custom_playlist category
        Button customPlaylist = (Button) findViewById (R.id.custom_playlist);

        // Set a click listener on that View
        customPlaylist.setOnClickListener (new View.OnClickListener () {
            // The code in this method will be executed when the custom_playlist View is clicked on.
            @Override
            public void onClick(View view) {
                Intent customPlaylistIntent = new Intent (MainActivity.this, CustomPlaylistActivity.class);
                startActivity (customPlaylistIntent);
            }
        });


        // Find the View that shows the info category
        Button info = (Button) findViewById (R.id.info);

        // Set a click listener on that View
        info.setOnClickListener (new View.OnClickListener () {
            // The code in this method will be executed when the info View is clicked on.
            @Override
            public void onClick(View view) {
                Intent browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.info_link)));
                startActivity (browser);
            }
        });

        // Find the View that shows the shop category
        Button shop = (Button) findViewById (R.id.shop);

        // Set a click listener on that View
        shop.setOnClickListener (new View.OnClickListener () {
            // The code in this method will be executed when the shop View is clicked on.
            @Override
            public void onClick(View view) {
                Intent shopIntent = new Intent (MainActivity.this, ShopActivity.class);
                startActivity (shopIntent);
            }
        });
    }
}
