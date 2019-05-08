package com.example.pruebacs.database;

import com.example.pruebacs.interfaces.callbacks.getBreedImagesCallback;
import com.example.pruebacs.interfaces.callbacks.getBreedListCallback;
import com.example.pruebacs.utils.RetrofitUtils;

import okhttp3.ResponseBody;

public class BreedUtils {

    public static ResponseBody getBreedList(final getBreedListCallback callback){
        return RetrofitUtils.getBreedList(callback::onGetFinish);
    }

    public static ResponseBody getBreedPics(final String breed,final getBreedImagesCallback callback){
        return RetrofitUtils.getBreedImages(breed,callback::onGetFinish);
    }

    public static ResponseBody getBreedRandomPics(final getBreedImagesCallback callback){
        return RetrofitUtils.getBreedRandomImages(callback::onGetFinish);
    }
}
