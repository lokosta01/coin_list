package com.example.sokol.cointest.ui.fragment.coin_info;


import androidx.lifecycle.ViewModelProviders;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.sokol.cointest.R;
import com.example.sokol.cointest.di.component.AppComponent;
import com.example.sokol.cointest.storage.entity.Coin;
import com.example.sokol.cointest.ui.fragment.base.BaseFragment;
import com.example.sokol.cointest.ui.fragment.view.ICoinInfoFragment;
import com.example.sokol.cointest.ui.fragment.view_model.ICoinInfoFragmentViewModel;
import com.example.sokol.cointest.ui.view_model.ViewModelFactory;

import javax.inject.Inject;

public class CoinInfoFragment extends BaseFragment implements ICoinInfoFragment {


    @BindView(R.id.coinNameInfo)
    TextView _coinNameInfo;
    @BindView(R.id.priceInfo)
    TextView _priceInfoe;
    @BindView(R.id.supply)
    TextView _supply;

    @Inject
    ViewModelFactory viewModelFactory;
    private ICoinInfoFragmentViewModel viewModel;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    appComponent.inject(this);
    viewModel = ViewModelProviders.of(this,viewModelFactory).get(CoinInfoViewModel.class);
    viewModel.setView(this);

    viewModel.setId(getArguments().getLong("id"));

}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getData()
            .observe(this,coin -> {



                Log.d("hy",coin.getName());
            _coinNameInfo.setText(coin.getName());

//            _priceInfoe.setText(coin.getQuote().getUsd().getPrice());
                _priceInfoe.setPaintFlags(_priceInfoe.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                _priceInfoe.setText(coin.getQuote().getUsd().getPrice());

                _supply.setPaintFlags(_supply.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                _supply.setText(coin.getQuote().getUsd().getPrice());

//            _supply.setText(coin.getSupply());


        });
    }

    @Override
    protected int getLayout() {
        return R.layout.coin_info_fragment;
    }
}
