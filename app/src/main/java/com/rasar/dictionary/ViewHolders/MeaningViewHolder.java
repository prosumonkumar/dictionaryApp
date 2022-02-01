package com.rasar.dictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasar.dictionary.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {
    public TextView partOfSpeechTv;
    public RecyclerView definationRecyclerView;

    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);
        partOfSpeechTv = itemView.findViewById(R.id.partOfSpeechTvId);
        definationRecyclerView = itemView.findViewById(R.id.definationRecyclerViewId);

    }
}
