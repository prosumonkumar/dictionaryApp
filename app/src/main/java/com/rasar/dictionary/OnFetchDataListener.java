package com.rasar.dictionary;

import com.rasar.dictionary.Models.ApiResponce;

public interface OnFetchDataListener {
    void onFetchData(ApiResponce apiResponce, String message);
    void onError(String message);
}
