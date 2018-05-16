package com.example.android.musicstructureproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_shop);


        // Create a list of images
        ArrayList <Integer> albumIcons = new ArrayList <Integer> ();
        albumIcons.add (R.drawable.album1icon);
        albumIcons.add (R.drawable.album2icon);
        albumIcons.add (R.drawable.album3icon);
        albumIcons.add (R.drawable.album4icon);
        albumIcons.add (R.drawable.album5icon);
        albumIcons.add (R.drawable.album6icon);

        LinearLayout linearLayout = (LinearLayout) (findViewById (R.id.linear_layout));
        Intent browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.info_link)));

        for (int i = 0; i < albumIcons.size (); i++) {
            ImageView imageView = new ImageView (this);
            imageView.setImageResource (albumIcons.get (i));
            linearLayout.addView (imageView);
            linearLayout.setDividerPadding (R.dimen.activity_vertical_margin);
            imageView.setPadding (0, 100, 0, 0);
            final int j = i;
            imageView.setOnClickListener (new View.OnClickListener () {

                @Override
                public void onClick(View view) {
                    Intent browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.link_shop_album_1)));

                    switch (j) {
                        case (0): {
                            browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.link_shop_album_1)));
                            break;
                        }
                        case (1): {
                            browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.link_shop_album_2)));
                            break;
                        }
                        case (2): {
                            browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.link_shop_album_3)));
                            break;
                        }
                        case (3): {
                            browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.link_shop_album_4)));
                            break;
                        }
                        case (4): {
                            browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.link_shop_album_5)));
                            break;
                        }
                        case (5): {
                            browser = new Intent (Intent.ACTION_VIEW, Uri.parse (getString (R.string.link_shop_album_6)));
                            break;
                        }

                    }
                    startActivity (browser);
                }
            });


        }

    }
}