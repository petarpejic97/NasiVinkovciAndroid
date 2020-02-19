package com.example.petarpejic.naivinkovci;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Naslov extends Fragment {

    View v;
    private RecyclerView recycler;
    private List<Poznati> lista;
    private RecyclerAdapter adapter;

    public static Naslov newInstance() {
        Naslov fragment = new Naslov();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lista=new ArrayList<Poznati>();
        lista.add(new Poznati("Ivan Kozarac","Pisac",R.drawable.ikozarac_round));
        lista.add(new Poznati("Goran Bare","Pjevač",R.drawable.gbare_round));
        lista.add(new Poznati("Dalibor Bartulović-Shorty","Pjevač",R.drawable.dbartulovic_round));
        lista.add(new Poznati("Rade Šerbedžija","Glumac",R.drawable.rserbedia_round));
        lista.add(new Poznati("Dubravko Mataković","Stripopisac",R.drawable.dmatakovic_round));
        lista.add(new Poznati("Mirko Cro Cop Filipović","MMA borac",R.drawable.mfilipovic_round));
        lista.add(new Poznati("Duje Čop","Nogometaš",R.drawable.dcop_round));
        lista.add(new Poznati("Mladen Bartolović","Nogometaš",R.drawable.mbartolovic_round));
        lista.add(new Poznati("Mario Kasun","Košarkaš",R.drawable.mkasun_round));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_naslov, container, false);

        recycler=(RecyclerView)v.findViewById(R.id.RecyclerView);
        adapter=new RecyclerAdapter(getContext(),lista);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);

        return v;
    }


}
