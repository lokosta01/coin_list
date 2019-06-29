package com.example.sokol.cointest.ui.fragment.coin_info;

import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.repository.ICoinRepository;
import com.example.sokol.cointest.storage.entity.Coin;
import com.example.sokol.cointest.ui.fragment.view.ICoinInfoFragment;
import com.example.sokol.cointest.ui.fragment.view_model.ICoinInfoFragmentViewModel;
import com.example.sokol.cointest.ui.fragment.view_model.ICoinListFragmentViewModel;
import com.example.sokol.cointest.ui.view_model.BaseViewModel;
import com.example.sokol.cointest.ui.view_model.DataViewModel;



import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;

public class CoinInfoViewModel extends DataViewModel<ICoinInfoFragment,Coin>
        implements ICoinInfoFragmentViewModel {


    private final ICoinRepository repository;

    private long id;


    @Inject
    public CoinInfoViewModel(ICoinRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void loadData() {

        repository.getCoin(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Coin>() {
                    @Override
                    public void onNext(Coin coin) {

                        liveData.postValue(coin);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }


                });
    }


    @Override
    public void setId(long id) {

     this.id = id;
    }

    @Override
    public void setData(Coin coin) {

        getData().getValue();


    }
}
