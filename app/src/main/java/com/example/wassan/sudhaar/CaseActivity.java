package com.example.wassan.sudhaar;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

public class CaseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Button.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private static String place_name;
    private static String category;
    private static String subcat;
    private static boolean proof;
    private static boolean anonymous;
    private static int a[];
    private final static String TAG = "log";
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);
        Spinner categories_spinner = (Spinner) findViewById(R.id.allcat);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,R.array.categories,android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories_spinner.setAdapter(dataAdapter);
        categories_spinner.setOnItemSelectedListener(this);
        RadioGroup proof = (RadioGroup) findViewById(R.id.proof);
        proof.setOnCheckedChangeListener(this);
        RadioGroup anonymous = (RadioGroup) findViewById(R.id.anonymous);
        anonymous.setOnCheckedChangeListener(this);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.gmaps);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                place_name = place.getName().toString();
                Log.i(TAG,"Place: "+place.getName());
            }

            @Override
            public void onError(Status status) {
                Log.i(TAG,"Error: "+status);
            }
        });
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (parent.getId()) {
            case R.id.allcat:
                category = parent.getItemAtPosition(pos).toString();
                Spinner subcat_spinner = (Spinner) findViewById(R.id.subcat);
                TextView textView = (TextView) findViewById(R.id.subcatext);
                textView.setVisibility(View.GONE);
                subcat_spinner.setVisibility(View.GONE);
                ArrayAdapter<CharSequence> subcat_adapter;
                switch (category) {
                    case "Administrative":
                        textView.setVisibility(View.VISIBLE);
                        subcat_spinner.setVisibility(View.VISIBLE);
                        subcat_adapter = ArrayAdapter.createFromResource(this,R.array.Administative,android.R.layout.simple_spinner_dropdown_item);
                        subcat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subcat_spinner.setAdapter(subcat_adapter);
                        subcat_spinner.setOnItemSelectedListener(this);
                        break;
                    case "Private Sector":
                        textView.setVisibility(View.VISIBLE);
                        subcat_spinner.setVisibility(View.VISIBLE);
                        subcat_adapter = ArrayAdapter.createFromResource(this,R.array.Private_Sector,android.R.layout.simple_spinner_dropdown_item);
                        subcat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subcat_spinner.setAdapter(subcat_adapter);
                        subcat_spinner.setOnItemSelectedListener(this);
                        break;
                    case "Religious":
                        textView.setVisibility(View.VISIBLE);
                        subcat_spinner.setVisibility(View.VISIBLE);
                        subcat_adapter = ArrayAdapter.createFromResource(this,R.array.Religious,android.R.layout.simple_spinner_dropdown_item);
                        subcat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subcat_spinner.setAdapter(subcat_adapter);
                        subcat_spinner.setOnItemSelectedListener(this);
                        break;
                    default:
                        subcat = null;
                }
                break;
            case R.id.subcat:
                subcat = parent.getItemAtPosition(pos).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (radioGroup.getId()) {
            case R.id.proof:
                switch (checkedId) {
                    case R.id.proof_yes:
                        proof = true;
                        break;
                    case R.id.proof_no:
                        proof = false;
                        break;
                }
            case R.id.anonymous:
                switch (checkedId) {
                    case R.id.anonymous_yes:
                        anonymous = true;
                        break;
                    case R.id.anonymous_no:
                        anonymous = false;
                        break;
                }
        }
    }

    public void onClick(View view) {
        String officer;
        String service;
        String caseEdit;
        Log.i(TAG,"Button Clicked" + place_name);
        EditText officerText = (EditText) findViewById(R.id.officer);
        EditText serviceText = (EditText) findViewById(R.id.service);
        EditText caseText = (EditText) findViewById(R.id.casedit);
        officer = officerText.getText().toString();
        service = serviceText.getText().toString();
        caseEdit = caseText.getText().toString();
        SQLdatabase db = new SQLdatabase(this);
        db.onInsert(place_name,category,subcat,officer,service,caseEdit,proof,anonymous);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thank you!")
                .setMessage("Case submitted successfully!\n Officer: " + place_name)
                .setCancelable(true);
        builder.create();
        builder.show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

