package com.example.pruebacs.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.pruebacs.R;
import com.example.pruebacs.interfaces.callbacks.getBreedImagesCallback;
import com.example.pruebacs.interfaces.callbacks.getBreedListCallback;
import com.example.pruebacs.interfaces.retrofit.CsClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static CsClient csClient;

    private static CsClient getRetrofitCsInstance(){
        if(csClient == null){
            csClient = new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CsClient.class);
        }

        return csClient;
    }

    public static ResponseBody getBreedList(final getBreedListCallback callback){
        Call<ResponseBody> call = getRetrofitCsInstance().getBreeds();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(callback != null)
                    callback.onGetFinish(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.e("error", t.toString());
                GeneralUtils.showToast(R.string.api_bad_response);
                if(callback != null)
                    callback.onGetFinish(null);
            }
        });
        return null;
    }

    public static ResponseBody getBreedImages(final String breed,
                                      final getBreedImagesCallback callback){
        Call<ResponseBody> call = getRetrofitCsInstance().getBreedImages(breed);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(callback != null)
                    callback.onGetFinish(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.e("error", t.toString());
                GeneralUtils.showToast(R.string.api_bad_response);
                if(callback != null)
                    callback.onGetFinish(null);
            }
        });
        return null;
    }

    public static ResponseBody getBreedRandomImages(final getBreedImagesCallback callback){
        Call<ResponseBody> call = getRetrofitCsInstance().getBreedRandomImages();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(callback != null)
                    callback.onGetFinish(response.isSuccessful() ? response.body() : null);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.e("error", t.toString());
                GeneralUtils.showToast(R.string.api_bad_response);
                if(callback != null)
                    callback.onGetFinish(null);
            }
        });
        return null;
    }

}
