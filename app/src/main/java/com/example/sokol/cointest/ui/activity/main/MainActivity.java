package com.example.sokol.cointest.ui.activity.main;

import android.os.Bundle;

import com.example.sokol.cointest.App;
import com.example.sokol.cointest.R;
import com.example.sokol.cointest.di.component.AppComponent;
import com.example.sokol.cointest.ui.activity.base.BaseActivity;
import com.example.sokol.cointest.ui.activity.view.IListActivity;
import com.example.sokol.cointest.ui.fragment.coin_list.ListFragment;
import com.example.sokol.cointest.utils.FragmentUtils;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IListActivity {




    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.getInstance().getAppComponent());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentUtils.changeFragmentWithoutBackStack(this, new ListFragment());
    }


}
