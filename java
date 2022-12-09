package com.example.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Credit,Grade;
    private Button addCourse, seeGpa, eraser;
    private TextView textview;

    double counter = 0, total_cradit=0,credit=0,grade=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Credit = findViewById(R.id.et1);
        Grade = findViewById(R.id.et2);

        addCourse = findViewById(R.id.bt);
        seeGpa = findViewById(R.id.bt2);
        eraser = findViewById(R.id.bt3);
        textview = findViewById(R.id.tv);

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                credit = Double.parseDouble(Credit.getText().toString());
                grade = Double.parseDouble(Grade.getText().toString());
                counter += (grade*credit);
                total_cradit +=credit;
                Toast.makeText(getApplicationContext(),"Cradit : "+credit+"\ngrade : "+grade,Toast.LENGTH_LONG).show();
                Credit.setText("");
                Grade.setText("");
            }
        });

        seeGpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result = counter/ total_cradit;
                textview.setText("Your CGPA : "+result);
            }
        });

        eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                total_cradit=0;
                credit=0;
                grade=0;

                Credit.setText("");
                Grade.setText("");
                textview.setText("");
            }
        });
    }
}
