package com.example.sokol.cointest.ui.activity.base;

import android.content.Intent;
import android.os.Bundle;

import com.example.sokol.cointest.App;
import com.example.sokol.cointest.di.component.AppComponent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract  void setupActivityComponent(AppComponent appComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.getInstance().getAppComponent());
    }

//    public void startWithFinishActivity(Class<?> cls){
//       startActivity(new Intent(this,cls)
//       .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK));
//
//    }
}
