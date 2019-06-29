package com.example.sokol.cointest.ui.fragment.coin_list;
import com.example.sokol.cointest.R;
import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.repository.ICoinRepository;
import com.example.sokol.cointest.ui.fragment.view.ICoinListFragment;
import com.example.sokol.cointest.ui.fragment.view_model.ICoinListFragmentViewModel;
import com.example.sokol.cointest.ui.view_model.DataViewModel;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;


public class ListViewModel extends DataViewModel<ICoinListFragment,CoinList>
implements ICoinListFragmentViewModel {

    private final ICoinRepository repository;


    @Inject
    public ListViewModel(ICoinRepository repository) {
        this.repository = repository;
    }

    @Override
    public void loadData() {
        view.show();
        repository.getCoins()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<CoinList>() {
                    @Override
                    public void onNext(CoinList coins) {
                    if(liveData != null){
                        liveData.setValue(coins);
                        view.setRefreshing(false);
                    }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.setRefreshing(false);
                    }

                    @Override
                    public void onComplete() {
                        view.hide();
                    }
                });


    }

    @Override
    public void onRefresh() {

        loadData();

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        liveData = null;
    }


}
