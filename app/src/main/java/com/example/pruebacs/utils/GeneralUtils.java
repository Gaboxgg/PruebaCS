package com.example.pruebacs.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.example.pruebacs.CsApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;

public class GeneralUtils {
    public static void showToast(@StringRes int resId){
        Toast.makeText(
                CsApp.getMainContext(),
                resId,
                Toast.LENGTH_LONG
        ).show();
    }

    public static String[] decodeResponse (ResponseBody response){

        try {
            JSONObject json = new JSONObject(response.string());

            JSONArray arrJson = json.getJSONArray("message");

            String [] arr = new String[arrJson.length()];

            for(int i = 0; i < arrJson.length(); i++)
                arr[i] = arrJson.getString(i);

            return arr;


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static List<String> arrayToList(String [] array){
        return Arrays.asList(array);
    }

}
