package com.feefasoft.a20230207_slavatsytsikov_nytschools.retrofit;



import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolDetails;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("f9bf-2cp4.json")
    Call<List<SchoolScore>> getSchoolsScore();

    @GET("s3k6-pzi2.json")
    Call<List<SchoolDetails>> getSchools();
}
