package com.example.sokol.cointest.ui.fragment.view_model;

import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.ui.fragment.view.ICoinListFragment;
import com.example.sokol.cointest.ui.view_model.IDataViewModel;
import com.example.sokol.cointest.ui.view_model.IListViewModel;
import com.example.sokol.cointest.ui.view_model.IViewModel;

public interface ICoinListFragmentViewModel extends IDataViewModel<ICoinListFragment,CoinList>,
        IListViewModel {
    void loadData();


}
