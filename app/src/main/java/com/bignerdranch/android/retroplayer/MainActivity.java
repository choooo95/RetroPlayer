package com.bignerdranch.android.retroplayer;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);

        //loading the default fragment
        loadFragment(new ForYouFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_for_you:
                fragment = new ForYouFragment();
                mTextMessage.setText(R.string.title_for_you);
                break;

            case R.id.nav_songs:
                fragment = new SongsFragment();
                mTextMessage.setText(R.string.title_songs);
                break;

            case R.id.nav_albums:
                fragment = new AlbumsFragment();
                mTextMessage.setText(R.string.title_albums);
                break;

            case R.id.nav_artists:
                fragment = new ArtistsFragment();
                mTextMessage.setText(R.string.title_artists);
                break;

            case R.id.nav_playlists:
                fragment = new PlaylistsFragment();
                mTextMessage.setText(R.string.title_playlists);
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
