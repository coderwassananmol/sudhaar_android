package com.example.wassan.sudhaar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wassan on 24/10/17.
 */

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment1, container, false);
        Button button = (Button) rootView.findViewById(R.id.submit);
        TextView textView = (TextView) rootView.findViewById(R.id.arrow);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/raleway.ttf");
        textView.setTypeface(typeface);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CaseActivity.class);
                intent.setAction(Intent.ACTION_SEND);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
