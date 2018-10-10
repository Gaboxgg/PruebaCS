package com.example.pruebacs.interfaces.callbacks;

import android.support.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Response;

public interface getBreedListCallback {
    void onGetFinish(@Nullable ResponseBody response);
}
