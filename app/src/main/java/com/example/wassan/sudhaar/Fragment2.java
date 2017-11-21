package com.example.wassan.sudhaar;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView2 = (ViewGroup) inflater.inflate(
                R.layout.fragment2, container, false);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/raleway.ttf");
        DatabaseReference db;
        db = FirebaseDatabase.getInstance().getReference();
        db.child("cases").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Case> list = new ArrayList<Case>();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Case report = dataSnapshot1.getValue(Case.class);
                    Log.i("Category",report.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView2;
    }
}
