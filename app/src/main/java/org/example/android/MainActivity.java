package org.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int counter = 0;

    private TextView label;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activity created");

        label = findViewById(R.id.label);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                label.setText("CLICKED " + String.valueOf(++counter) + " TIMES");
//                Toast.makeText(getApplicationContext(), "Clicked " + String.valueOf(counter) + " times", Toast.LENGTH_LONG).show();
                Snackbar.make(view, "Clicked " + String.valueOf(counter) + " times", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                label.setText("CLICKED " + String.valueOf(--counter) + " TIMES");
                                Toast.makeText(getApplicationContext(), "Undone", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });


    }

}
