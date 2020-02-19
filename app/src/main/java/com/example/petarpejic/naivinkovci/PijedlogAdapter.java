package com.example.petarpejic.naivinkovci;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PijedlogAdapter extends RecyclerView.Adapter<NameViewHolderPrijedlog> {

    private ArrayList<Model> dataList;
    private Context mContext;

    public PijedlogAdapter(Context mContext, ArrayList<Model> dataList) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NameViewHolderPrijedlog onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cellView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_prijedlog,viewGroup,false);
        return new NameViewHolderPrijedlog(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolderPrijedlog nameViewHolderPrijedlog, int i) {
        nameViewHolderPrijedlog.setPrijedlog(dataList.get(i).getPrijedlog(),dataList.get(i).getImeprezime(),dataList.get(i).getOib());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<Model> data){
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }
}
