package com.example.pruebacs.interfaces.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CsClient {

    @GET("api/breeds/list")
    Call<ResponseBody> getBreeds(
    );

    @GET("api/breed/{breed_name}/images")
    Call<ResponseBody> getBreedImages(
            @Path("breed_name") String breed
    );

    @GET("api/breeds/image/random/50")
    Call<ResponseBody> getBreedRandomImages(
    );

}
