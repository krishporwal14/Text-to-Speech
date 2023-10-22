package com.example.texttospeechexample;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;
import java.util.Locale;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et1;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        btn = findViewById(R.id.btn);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                tts.setLanguage(Locale.US);
            }
        });
        btn.setOnClickListener(view -> {
            String toSpeak = et1.getText().toString();
            Toast.makeText(this, toSpeak, Toast.LENGTH_SHORT).show();
            tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        });
    }
    public void onPause() {
        super.onPause();
        tts.stop();
        tts.shutdown();
    }
}