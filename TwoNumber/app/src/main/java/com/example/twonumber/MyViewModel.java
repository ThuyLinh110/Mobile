package com.example.twonumber;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<ArrayList<String>> listNumber;

    public LiveData<ArrayList<String>> getListNumber() {
        if (listNumber == null) {
            listNumber = new MutableLiveData<ArrayList<String>>();
            listNumber.setValue(new ArrayList<>());
        }
        return listNumber;
    }

    public void addNumber(Integer a, Integer b)
    {   Integer summ =a+b;
        listNumber.getValue().add(""+a+" + "+b+" = "+summ);
    }
    public void subNumber(Integer a, Integer b)
    {   Integer sub =a-b;
        listNumber.getValue().add(""+a+" - "+b+" = "+sub);
    }
    public void mulNumber(Integer a, Integer b)
    {   Integer mul =a*b;
        listNumber.getValue().add(""+a+" * "+b+" = "+mul);
    }
    public void devNumber(Integer a, Integer b)
    {   double dev =a/b;
        listNumber.getValue().add(""+a+" / "+b+" = "+dev);
    }



}
