package com.example.election;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText cand1, cand2, cand3;
    int c1 = 0, c2 = 0, c3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cand1 = findViewById(R.id.VotesCount1);
        cand2 = findViewById(R.id.VoteCount2);
        cand3 = findViewById(R.id.VoteCount3);

        cand1.setText("Candidate 1: " + c1);
        cand2.setText("Candidate 2: " + c2);
        cand3.setText("Candidate 3: " + c3);
        b = (Button) findViewById(R.id.Vote);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  votingPerson();
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                c1 = i.getExtras().getInt("voteSend1");
                c2 = i.getExtras().getInt("voteSend2");
                c3 = i.getExtras().getInt("voteSend3");
                cand1.setText(" " +c1 + " vote");
                cand2.setText(" " +c2 + " vote");
                cand3.setText(" " +c3 + " vote");
            }
        }
    }

    public void votingPerson(){
        Intent i=new Intent(this,Candidate.class);
        i.putExtra("candidate1",c1);
        i.putExtra("candidate2",c2);
        i.putExtra("candidate3",c3);
        startActivityForResult(i,1);

    }
}