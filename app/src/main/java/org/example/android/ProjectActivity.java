package org.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
    }

    public void handleGroupLayoutClick(View view) {
        Intent profileViewerIntent = new Intent(this, ProfileViewerActivity.class);
        profileViewerIntent.putExtra("userName", "Alice Bush");
        startActivity(profileViewerIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_profile:
                showProfileEditor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showProfileEditor() {
        Intent intent = new Intent(this, ProfileEditorActivity.class);
        startActivity(intent);
    }
}
