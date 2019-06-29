package com.example.sokol.cointest.ui.view_model;

import androidx.lifecycle.LiveData;

public interface IDataViewModel<V, T> extends IViewModel<V>{
    LiveData<T> getData();
}
