package com.example.notesandroidjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class NotesTakerActivity extends AppCompatActivity {

    EditText edit_text_title, edit_text_notes;
    ImageView image_view_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        image_view_save = findViewById(R.id.image_view_save);
        edit_text_title = findViewById(R.id.edit_text_title);
        edit_text_notes = findViewById(R.id.edit_text_notes);
    }
}