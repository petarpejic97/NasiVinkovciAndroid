package com.example.petarpejic.naivinkovci;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder> {

    Context mContext;
    public List<Poznati> dataList ;

    public RecyclerAdapter(Context mContext, List<Poznati> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cellView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_name, viewGroup, false);
        return new NameViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int i) {
        nameViewHolder.setName(dataList.get(i).getIme());
        nameViewHolder.setJob(dataList.get(i).getZanimanje());
        nameViewHolder.setImg(dataList.get(i).getSlika());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
