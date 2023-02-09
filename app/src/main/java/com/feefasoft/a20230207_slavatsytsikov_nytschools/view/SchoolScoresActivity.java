package com.feefasoft.a20230207_slavatsytsikov_nytschools.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feefasoft.a20230207_slavatsytsikov_nytschools.R;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolScore;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.view_model.SchoolScoresViewModel;

import java.util.List;

public class SchoolScoresActivity extends AppCompatActivity {


    private SchoolScoresViewModel articleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_scores);
        getSupportActionBar().setTitle("The School Scores:");

        Intent in = getIntent();
        String dbn = in.getStringExtra("school_dbn");
        articleViewModel = new ViewModelProvider(this).get(SchoolScoresViewModel.class);
        getSchoolScores(dbn);


    }

    private void getSchoolScores(String dbn) {

        TextView tv_school_name = findViewById(R.id.tv_school_name);
        TextView tvNumberTestTakers = findViewById(R.id.tv_number_test_takers);
        TextView tvReadingScore = findViewById(R.id.tv_reading);
        TextView tvSatMathScore = findViewById(R.id.tv_sat_math);
        TextView tvSatWritingScore = findViewById(R.id.tv_sat_writing);

        Button btnClose = findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        articleViewModel.getSchoolScores().observe(this, response -> {
            if (response != null) {
                List<SchoolScore> articles = response;
                for(SchoolScore school: articles){
                    if(school.getDbn().equalsIgnoreCase(dbn)){

                        tv_school_name.setText(school.getSchool_name());
                        tvNumberTestTakers.setText("Number of test takers: " + school.getNum_of_sat_test_takers());
                        tvReadingScore.setText("SAT Critical Reading Average Score: " + school.getSat_critical_reading_avg_score());
                        tvSatMathScore.setText("SAT Math Average Score: " + school.getSat_math_avg_score());
                        tvSatWritingScore.setText("SAT Writing Average Score: " + school.getSat_writing_avg_score());

                    }
                }
            }
        });
    }
}