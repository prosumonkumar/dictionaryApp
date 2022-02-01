package com.rasar.dictionary.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rasar.dictionary.Models.Meanings;
import com.rasar.dictionary.R;
import com.rasar.dictionary.ViewHolders.MeaningViewHolder;


import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {
    private Context context;
    private List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.partOfSpeechTv.setText("Parts of speech: " + meaningsList.get(position).getPartOfSpeech());
        holder.definationRecyclerView.setHasFixedSize(true);
        holder.definationRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));

        DefinationAdapter definationAdapter = new DefinationAdapter(context, meaningsList.get(position).getDefinitions());
        holder.definationRecyclerView.setAdapter(definationAdapter);

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
