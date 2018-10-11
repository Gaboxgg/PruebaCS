package com.example.pruebacs;

import com.example.pruebacs.utils.GeneralUtils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class UnitTests {

    @Test
    public void null_response_decodeResponse() {
        assertEquals(null,GeneralUtils.decodeResponse(null),0);
    }

    @Test
    public void array_to_list(){
        String[]  arrayInt = {"1","2","3","4","5"};
        assertEquals(Arrays.asList("1", "2", "3", "4", "5"),GeneralUtils.arrayToList(arrayInt));
    }

}
