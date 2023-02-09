package com.feefasoft.a20230207_slavatsytsikov_nytschools.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolDetails;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolScore;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.retrofit.ApiRequest;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolRepository {
    private static final String TAG = SchoolRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public SchoolRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<List<SchoolDetails>> getSchoolDetails() {


        final MutableLiveData<List<SchoolDetails>> data = new MutableLiveData<>();

        Call <List<SchoolDetails>> call = apiRequest.getSchools();

        call.enqueue(new Callback<List<SchoolDetails>>() {
            @Override
            public void onResponse(Call<List<SchoolDetails>> call, Response<List<SchoolDetails>> response) {

                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<SchoolDetails>> call, Throwable t) {
                Log.e(TAG, "Error:: " + t.getLocalizedMessage());
            }
        });

        return data;
    }

    public LiveData<List<SchoolScore>> getSchoolScores() {


        final MutableLiveData<List<SchoolScore>> data = new MutableLiveData<>();

        Call <List<SchoolScore>> call = apiRequest.getSchoolsScore();

        call.enqueue(new Callback<List<SchoolScore>>() {
            @Override
            public void onResponse(Call<List<SchoolScore>> call, Response<List<SchoolScore>> response) {

                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<SchoolScore>> call, Throwable t) {
                Log.e(TAG, "Error:: " + t.getLocalizedMessage());
            }
        });

        return data;
    }


}
