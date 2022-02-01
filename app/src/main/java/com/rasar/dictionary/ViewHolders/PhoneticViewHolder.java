package com.rasar.dictionary.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasar.dictionary.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
    public TextView phoneticTv;
    public ImageButton imageBtnAudio;
    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);
        phoneticTv = itemView.findViewById(R.id.phoneticTvId);
        imageBtnAudio = itemView.findViewById(R.id.imageBtnAudioId);
    }
}
