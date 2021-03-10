package com.example.election;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Candidate extends AppCompatActivity {
       Button submitVote;
       EditText v_ID;
       EditText name;
       Spinner candidates;
       ToggleButton accept;
       int countVotes1, countVotes2,countVotes3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        Intent i = getIntent();
        countVotes1=i.getExtras().getInt("candidate1");
        countVotes2=i.getExtras().getInt("candidate2");
        countVotes3=i.getExtras().getInt("candidate3");

         v_ID =findViewById(R.id.PersonId);
         name=findViewById(R.id.PersonName);
         candidates=findViewById(R.id.spinner);
         submitVote=findViewById(R.id.voting);
         accept=findViewById(R.id.tb);
        
        ArrayList<String> arrayList = new ArrayList<String>();
        submitVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_name= name.getText().toString();
                String string_id= v_ID.getText().toString();
                String value=candidates.getSelectedItem().toString();
                String value0=candidates.getItemAtPosition(0).toString();
                String value1=candidates.getItemAtPosition(1).toString();
                String value2=candidates.getItemAtPosition(2).toString();

                if(accept.isChecked() && !string_name.isEmpty() && !string_id.isEmpty() && !value.equals(value0)) {
                    if (!arrayList.contains(string_id)) {
                        arrayList.add(string_id);
                        Toast.makeText(getApplicationContext(), "Vote Added Successfully", Toast.LENGTH_SHORT).show();

                        if (value.equals(value1)) {
                            countVotes1++;

                        } else if (value.equals(value2)) {
                            countVotes2++;

                        } else {
                            countVotes3++;
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Sorry!! You already vote.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Context con= getApplicationContext();
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                }
        });

    }
    @Override
    public void onBackPressed(){
        Intent i2= new Intent();
        i2.putExtra("voteSend1",countVotes1);
        i2.putExtra("voteSend2",countVotes2);
        i2.putExtra("voteSend3",countVotes3);
        setResult(RESULT_OK,i2);
        finish();

    }


}
