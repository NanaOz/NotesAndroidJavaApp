package com.example.notesandroidjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.notesandroidjavaapp.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText edit_text_title, edit_text_notes;
    ImageView image_view_save;

    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        image_view_save = findViewById(R.id.image_view_save);
        edit_text_title = findViewById(R.id.edit_text_title);
        edit_text_notes = findViewById(R.id.edit_text_notes);

        image_view_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edit_text_title.getText().toString();
                String description = edit_text_notes.getText().toString();

                if(description.isEmpty()) {
                    Toast.makeText(NotesTakerActivity.this, "**добавьте описание**", Toast.LENGTH_LONG).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
                Date date = new Date();
                notes = new Notes();
                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(formatter.format(date));

                Intent intent = new Intent();
                intent.putExtra("notes", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}