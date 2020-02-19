package com.example.petarpejic.naivinkovci;

import io.realm.RealmObject;

public class Model extends RealmObject {
    String imeprezime;
    String oib;
    String prijedlog;

    public String getImeprezime() {
        return imeprezime;
    }

    public String getOib() {
        return oib;
    }

    public String getPrijedlog() {
        return prijedlog;
    }

    public void setImeprezime(String imeprezime) {
        this.imeprezime = imeprezime;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public void setPrijedlog(String prijedlog) {
        this.prijedlog = prijedlog;
    }

    @Override
    public String toString() {
        return prijedlog + "\n"+ imeprezime + "\n" + oib ;
    }
}
