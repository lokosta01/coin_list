package com.example.sokol.cointest.di.module;

import androidx.lifecycle.ViewModel;

import com.example.sokol.cointest.di.ViewModelKey;
import com.example.sokol.cointest.ui.fragment.coin_info.CoinInfoViewModel;
import com.example.sokol.cointest.ui.fragment.coin_list.ListViewModel;

import butterknife.BindView;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    public abstract ViewModel listviewmodel(ListViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CoinInfoViewModel.class)
    public abstract ViewModel coinviewmodel(CoinInfoViewModel viewModel);

}
