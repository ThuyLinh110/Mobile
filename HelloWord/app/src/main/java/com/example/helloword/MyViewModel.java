package com.example.helloword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    private MutableLiveData<ArrayList<String>> listNumber;
    public LiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }
        return number;
    }
    public LiveData<ArrayList<String>> getListNumber() {
        if (listNumber == null) {
            listNumber = new MutableLiveData<ArrayList<String>>();
            listNumber.setValue(new ArrayList<>());
        }
        return listNumber;
    }
   public void increaseNumber() {
        number.setValue(number.getValue() +1 );
    }
    public void addNumber(String i) {
        listNumber.getValue().add(i);
    }

    public void delNumber(int index){
        listNumber.getValue().remove(index);
    }

    public void updateNumber(int index, String i){
        listNumber.getValue().set(index,i);
    }

}
