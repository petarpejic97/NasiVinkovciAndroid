package com.example.petarpejic.naivinkovci;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class Prijedlog extends Fragment {

    EditText edImePrezime;
    EditText edOib;
    EditText edPrijedlog;
    Button btnPosalji;
    Button btnPogledajPrijedloge;
    private Realm realm;

    public static Prijedlog newInstance() {
        Prijedlog fragment = new Prijedlog();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_prijedlog, container, false);

        edImePrezime=(EditText)view.findViewById(R.id.imeprezime);
        edOib=(EditText)view.findViewById(R.id.oib);
        edPrijedlog=(EditText)view.findViewById(R.id.prijedlog) ;
        btnPosalji=(Button)view.findViewById(R.id.posalji);
        btnPogledajPrijedloge=(Button)view.findViewById(R.id.pogledajprijedloge);

        onBtnPosaljiClick();
        onBtnPogledajPrijedlogeClick();
        deleteAllFromRealm();
        return view;
    }

    public void onBtnPosaljiClick(){
        btnPosalji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edImePrezime.getText().toString().isEmpty()||edOib.getText().toString().isEmpty()|| edPrijedlog.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(),"Sva polja moraju biti popunjena!",Toast.LENGTH_LONG).show();
                }
                else if(edOib.getText().toString().length()<13){
                    Toast.makeText(getActivity(),"Polje OIB ima nedovoljno znakova!",Toast.LENGTH_LONG).show();
                }
                else {
                    saveToDatabase(edPrijedlog.getText().toString(), edImePrezime.getText().toString(), edOib.getText().toString());
                    edImePrezime.setText("");
                    edOib.setText("");
                    edPrijedlog.setText("");
                }

            }
        });

    }
    public void onBtnPogledajPrijedlogeClick(){
        btnPogledajPrijedloge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPP();
            }
        });
    }

    private void saveToDatabase(final String prijedlog, final String impr,final String oib) {
        realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Model model = new Model();
                model.setPrijedlog(prijedlog);
                model.setImeprezime(impr);
                model.setOib(oib);
                bgRealm.insertOrUpdate(model);
            }
        });
    }

    private void deleteAllFromRealm(){
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //realm.deleteAll();
            }
        });
    }

    private void openActivityPP() {
        Intent intent =new Intent(getActivity(),ActivityPogledajPrijedloge.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
