package com.example.sokol.cointest.ui.fragment.view_model;

import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.storage.entity.Coin;
import com.example.sokol.cointest.ui.fragment.view.ICoinInfoFragment;
import com.example.sokol.cointest.ui.view_model.IDataViewModel;

public interface ICoinInfoFragmentViewModel extends IDataViewModel<ICoinInfoFragment,Coin> {

    void setId(long id);

    void setData(Coin coin);
}
