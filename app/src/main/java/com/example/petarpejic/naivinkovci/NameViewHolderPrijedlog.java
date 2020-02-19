package com.example.petarpejic.naivinkovci;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NameViewHolderPrijedlog extends RecyclerView.ViewHolder {
    private TextView tvPrijedlog;
    private TextView tvImePrezime;
    private TextView tvOib;

    public NameViewHolderPrijedlog(@NonNull View itemView) {
        super(itemView);
        tvPrijedlog=itemView.findViewById(R.id.tvprijedlog);
        tvImePrezime=itemView.findViewById(R.id.tvimpr);
        tvOib=itemView.findViewById(R.id.tvoib);
    }

    public void setPrijedlog(String prijedlog,String imeprezime,String Oib){
        tvPrijedlog.setText(prijedlog);
        tvImePrezime.setText(imeprezime);
        tvOib.setText(Oib);
    }
}
