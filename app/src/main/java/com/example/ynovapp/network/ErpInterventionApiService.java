package com.example.ynovapp.network;

import com.example.ynovapp.model.Affaire;
import com.example.ynovapp.model.ApiResponse;
import com.example.ynovapp.model.RandomPerson;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by Nicolas Churlet on 21/03/2018.
 */

public interface ErpInterventionApiService {

    // region GETTER ALL
    // region Used
    @GET("/api/?nat=fr")
    Call<ApiResponse> getRandomPersons(@Query("results") Integer results);
}
