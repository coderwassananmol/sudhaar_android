package com.example.wassan.sudhaar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wassan on 26/10/17.
 */

class Case {
    public String ID;
    public String PLACE;
    public String CATEGORY;
    public String SUBCAT;
    public String OFFICER;
    public String SERVICE;
    public String CASE;
    public boolean PROOF;
    public boolean ANONYMOUS;
    private List<String> stringList;
    public Case(String place, String category, String subcat, String officer, String service, String report, Boolean proof, Boolean anonymous) {
        this.PLACE = place;
        this.CATEGORY = category;
        this.SUBCAT = subcat;
        this.OFFICER = officer;
        this.SERVICE = service;
        this.CASE = report;
        this.PROOF = proof;
        this.ANONYMOUS = anonymous;
    }
    Case() { }
}
