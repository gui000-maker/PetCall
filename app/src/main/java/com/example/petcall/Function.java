package com.example.petcall;

import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Function extends AppCompatActivity  {
    public Button catButton;

    public Button dogButton;
    public MediaPlayer mp3cat;
    public MediaPlayer mp3dog;
    private boolean Notplaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function);

        catButton = this.findViewById(R.id.Cat_id);
        dogButton = this.findViewById(R.id.Dog_id);

        mp3cat = MediaPlayer.create(this, R.raw.cat_call);
        mp3dog = MediaPlayer.create(this, R.raw.dog_call);
    }
    public void Cat(View view) {
        if (Notplaying) {
            if (mp3cat != null && !mp3cat.isPlaying()) {
                mp3cat.setLooping(true);
                mp3cat.start();
                catButton.setText(R.string.parar);
                Notplaying = false;
                dogButton.setEnabled(false);
            }
        } else {
            if (mp3cat != null && mp3cat.isPlaying()) {
                mp3cat.stop();
                try {
                    mp3cat.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                catButton.setText(R.string.gato);
                Notplaying = true;
                dogButton.setEnabled(true);
            }
        }
    }

    public void Dog(View view) {
        if (Notplaying) {
            if (mp3dog != null && !mp3dog.isPlaying()) {
                mp3dog.setLooping(true);
                mp3dog.start();
                dogButton.setText(R.string.parar);
                Notplaying = false;
                catButton.setEnabled(false);
            }
        } else {
            if (mp3dog != null && mp3dog.isPlaying()) {
                mp3dog.stop();
                try {
                    mp3dog.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dogButton.setText(R.string.cachorro);
                Notplaying = true;
                catButton.setEnabled(true);
            }
        }
    }
}
