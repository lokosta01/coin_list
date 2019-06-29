package com.example.sokol.cointest.ui.view_model;

import androidx.lifecycle.ViewModel;
import android.view.View;

public class BaseViewModel<V> extends ViewModel implements IViewModel<V> {
    protected V view;
    protected boolean isCleared;

    @Override
    public void setView(V view) {
      this.view = view;
      isCleared = false;
    }

    @Override
    protected void onCleared() {
        isCleared = true;
    }
}
