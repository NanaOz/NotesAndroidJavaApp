package com.example.notesandroidjavaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesandroidjavaapp.Models.Notes;
import com.example.notesandroidjavaapp.NotesClickListener;
import com.example.notesandroidjavaapp.R;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{

    Context context;
    List<Notes> list;

    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.text_view_title.setText(list.get(position).getTitle());
        holder.text_view_title.setSelected(true);

        holder.text_view_notes.setText(list.get(position).getNotes());

        holder.date.setText(list.get(position).getDate());
        holder.date.setSelected(true);

        if (list.get(position).isPinned()) {
            holder.image_view_pin.setImageResource(R.drawable.fix_icon);
        } else {
            holder.image_view_pin.setImageResource(0);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class NotesViewHolder extends RecyclerView.ViewHolder {

    CardView notes_conteiner;
    TextView text_view_title, text_view_notes, date;
    ImageView image_view_pin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);

        notes_conteiner = itemView.findViewById(R.id.notes_conteiner);
        text_view_title = itemView.findViewById(R.id.text_view_title);
        text_view_notes = itemView.findViewById(R.id.text_view_notes);
        date = itemView.findViewById(R.id.date);
        image_view_pin = itemView.findViewById(R.id.image_view_pin);

    }
}
