package org.example.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ProfileViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_viewer);
        Toolbar toolbar = findViewById(R.id.profile_viewer_toolbar);
        setSupportActionBar(toolbar);
        setTitle(getIntent().getStringExtra("userName"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_bookmark:
                Toast.makeText(getApplicationContext(), "Added to bookmarks", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void handleGithubPageClick(View view) {
        ResourceLink link = (ResourceLink) view;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link.getLinkLabel()));
        startActivity(intent);
    }
}
