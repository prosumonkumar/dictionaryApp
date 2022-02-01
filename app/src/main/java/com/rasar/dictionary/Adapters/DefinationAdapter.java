package com.rasar.dictionary.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasar.dictionary.Models.Definitions;
import com.rasar.dictionary.Models.Phonetics;
import com.rasar.dictionary.R;
import com.rasar.dictionary.ViewHolders.DefinationViewHolder;


import java.util.List;

public class DefinationAdapter extends RecyclerView.Adapter<DefinationViewHolder> {
    private Context context;
    private List<Definitions> definitionsList;

    public DefinationAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinationViewHolder(LayoutInflater.from(context).inflate(R.layout.defination_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinationViewHolder holder, int position) {
        holder.definationTv.setText("Defination: "+definitionsList.get(position).getDefinition());
        holder.exampleTv.setText("Example: "+definitionsList.get(position).getExample());
        StringBuilder synonmys = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();
        synonmys.append(definitionsList.get(position).getSynonyms());
        antonyms.append(definitionsList.get(position).getAntonyms());
        holder.synonymsTv.setText(synonmys);
        holder.antonymsTv.setText(antonyms);

        holder.synonymsTv.setSelected(true);
        holder.antonymsTv.setSelected(true);


    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
