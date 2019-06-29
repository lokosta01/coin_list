package com.example.sokol.cointest.ui.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public abstract class DataViewModel<V, M> extends BaseViewModel<V> implements IDataViewModel<V, M>{

    protected MutableLiveData<M> liveData;
    @Override
    public LiveData<M> getData() {
        if(liveData == null){
            liveData = new MutableLiveData<>();
            loadData();
        }
        return liveData;
    }

    protected void loadData() {
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


//    protected abstract void loadData();
}
