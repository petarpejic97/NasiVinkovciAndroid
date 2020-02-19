package com.example.petarpejic.naivinkovci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ActivityPogledajPrijedloge extends AppCompatActivity {

    private RecyclerView recycler;
    private PijedlogAdapter adapter;
    private ArrayList<Model> dataList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pogledaj_prijedloge);
        setupRecycler();
        GetDataFromRealm();
    }

    private void setupRecycler(){
        recycler=findViewById(R.id.RecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter=new PijedlogAdapter(this,dataList);
        recycler.setAdapter(adapter);
    }

    private void GetDataFromRealm(){
        Realm realm= Realm.getDefaultInstance();
        RealmResults<Model> realmResults=realm.where(Model.class).findAllAsync();
        if(realmResults!=null){
            for (Model prijedlog:realmResults)
                setupRecyclerData(prijedlog);
        }
    }
    private void setupRecyclerData(Model prijedlog){
        List<Model> data=new ArrayList<>();
        data.add(prijedlog);
        adapter.addData(data);
    }
}
