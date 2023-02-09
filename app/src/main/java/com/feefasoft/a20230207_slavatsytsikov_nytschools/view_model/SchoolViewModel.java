package com.feefasoft.a20230207_slavatsytsikov_nytschools.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolDetails;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.repository.SchoolRepository;

import java.util.List;


public class SchoolViewModel extends AndroidViewModel {

    private SchoolRepository schoolRepository;
    private LiveData<List<SchoolDetails>> schoolsData;

    public SchoolViewModel(@NonNull Application application) {
        super(application);

        schoolRepository = new SchoolRepository();
        this.schoolsData = schoolRepository.getSchoolDetails();
    }

    public LiveData<List<SchoolDetails>> getSchoolsData() {
        return schoolsData;
    }

}
