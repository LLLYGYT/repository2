package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DataRepository {
    public MutableLiveData<String> data=new MutableLiveData<>();
    public LiveData<String> getData(){
        return data;
    }
    public void setData(String value){
        data.setValue(value);
    }
}
