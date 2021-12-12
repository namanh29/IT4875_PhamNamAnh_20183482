package com.example.calculatorfragment.ui.unitconvert;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UnitConvertViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UnitConvertViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}