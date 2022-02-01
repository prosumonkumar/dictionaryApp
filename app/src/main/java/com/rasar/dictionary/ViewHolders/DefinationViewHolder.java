package com.rasar.dictionary.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasar.dictionary.R;

public class DefinationViewHolder extends RecyclerView.ViewHolder {
    public TextView definationTv, exampleTv, synonymsTv, antonymsTv;

    public DefinationViewHolder(@NonNull View itemView) {
        super(itemView);
        definationTv = itemView.findViewById(R.id.definationTvId);
        exampleTv = itemView.findViewById(R.id.exampleTvId);
        synonymsTv = itemView.findViewById(R.id.synonymsTvId);
        antonymsTv = itemView.findViewById(R.id.antonymsTvId);
    }
}
