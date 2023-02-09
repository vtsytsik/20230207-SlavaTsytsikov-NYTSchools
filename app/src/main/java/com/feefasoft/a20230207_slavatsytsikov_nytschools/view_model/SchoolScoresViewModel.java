package com.feefasoft.a20230207_slavatsytsikov_nytschools.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolScore;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.repository.SchoolRepository;

import java.util.List;


public class SchoolScoresViewModel extends AndroidViewModel {

    private SchoolRepository schoolRepository;

    private LiveData<List<SchoolScore>> schoolsScores;

    public SchoolScoresViewModel(@NonNull Application application) {
        super(application);

        schoolRepository = new SchoolRepository();
        this.schoolsScores = schoolRepository.getSchoolScores();
    }


    public LiveData<List<SchoolScore>> getSchoolScores() {
        return schoolsScores;
    }
}
