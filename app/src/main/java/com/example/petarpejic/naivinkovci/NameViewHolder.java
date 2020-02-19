package com.example.petarpejic.naivinkovci;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvJob;
    private ImageView img;

    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName=itemView.findViewById(R.id.ime);
        tvJob=itemView.findViewById(R.id.zanimanje);
        img=itemView.findViewById(R.id.slika);

    }
    public void setName(String name){
        tvName.setText(name);
    }
    public void setJob(String job){
        tvJob.setText(job);
    }
    public void setImg(int slika){img.setImageResource(slika);}
}
