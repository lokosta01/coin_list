package com.example.sokol.cointest.ui.fragment.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sokol.cointest.App;
import com.example.sokol.cointest.di.component.AppComponent;

import androidx.annotation.LayoutRes;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    protected static final String  ARG_ITEM = "item";
    protected static final String  ARG_ID = "id";

    protected View view;

    protected abstract void setupActivityComponent(AppComponent appComponent);

    @LayoutRes
    protected abstract int getLayout();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setupActivityComponent(App.getInstance().getAppComponent());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(),container,false);
        ButterKnife.bind(this, view);
        return view;
    }
}
