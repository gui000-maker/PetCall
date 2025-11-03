package com.example.petcall;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button catButton;
    private Button dogButton;
    MediaPlayer mp3cat;
    MediaPlayer mp3dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mp3dog = MediaPlayer.create(this, R.raw.dog_call);
        mp3cat = MediaPlayer.create(this, R.raw.cat_call);

        catButton = findViewById(R.id.Cat_id);
        dogButton = findViewById(R.id.Dog_id);
    }

    public void Cat(View view) {
        if (mp3cat != null && !mp3cat.isPlaying()) {
            mp3cat.start();
        }
        catButton.setEnabled(false);
        dogButton.setEnabled(false);

        new Handler().postDelayed(() -> {
            catButton.setEnabled(true);
            dogButton.setEnabled(true);
        }, 5000);
    }

    public void Dog(View view) {
        if (mp3dog != null && !mp3dog.isPlaying()) {
            mp3dog.start();
        }
        catButton.setEnabled(false);
        dogButton.setEnabled(false);

        new Handler().postDelayed(() -> {
            catButton.setEnabled(true);
            dogButton.setEnabled(true);
        }, 5000);
    }
}