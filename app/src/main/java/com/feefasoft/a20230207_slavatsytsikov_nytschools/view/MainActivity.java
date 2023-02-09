package com.feefasoft.a20230207_slavatsytsikov_nytschools.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.feefasoft.a20230207_slavatsytsikov_nytschools.R;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.adapter.SchoolAdapter;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolDetails;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.view_model.SchoolViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress_circular;
    private SchoolAdapter adapter;
    private ArrayList<SchoolDetails> articleArrayList = new ArrayList<>();
    private SchoolViewModel articleViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("NYT HIgh Schools:");

        progress_circular = (ProgressBar) findViewById(R.id.progress_circular_school);

        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setHasFixedSize(true);

        adapter = new SchoolAdapter(MainActivity.this, articleArrayList);
        my_recycler_view.setAdapter(adapter);

        articleViewModel =new ViewModelProvider(this).get(SchoolViewModel.class);

        getSchoolsDetails();
    }


    private void getSchoolsDetails() {
        articleViewModel.getSchoolsData().observe(this, response -> {
            if (response != null) {
                progress_circular.setVisibility(View.GONE);
                List<SchoolDetails> articles = response;
                articleArrayList.addAll(articles);
                adapter.notifyDataSetChanged();
            }
        });
    }
}