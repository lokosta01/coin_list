package com.example.sokol.cointest.ui.fragment.coin_list;


import android.os.Bundle;
import android.view.View;
import com.example.sokol.cointest.R;
import com.example.sokol.cointest.di.component.AppComponent;
import com.example.sokol.cointest.storage.entity.Coin;
import com.example.sokol.cointest.ui.adapter.AdapterClickListener;
import com.example.sokol.cointest.ui.adapter.CoinListAdapter;
import com.example.sokol.cointest.ui.fragment.base.BaseFragment;
import com.example.sokol.cointest.ui.fragment.coin_info.CoinInfoFragment;
import com.example.sokol.cointest.ui.fragment.view.ICoinListFragment;
import com.example.sokol.cointest.ui.fragment.view_model.ICoinListFragmentViewModel;
import com.example.sokol.cointest.ui.view_model.ViewModelFactory;
import com.example.sokol.cointest.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;


public class ListFragment extends BaseFragment implements ICoinListFragment, AdapterClickListener {

    @BindView(R.id.list)
    RecyclerView rvList;

    @BindView(R.id.refresh)
    SwipeRefreshLayout swRefresh;

    @BindView(R.id.progress)
    ContentLoadingProgressBar progress;

    @Inject
    ViewModelFactory viewModelFactory;
    private ICoinListFragmentViewModel viewModel;
    private CoinListAdapter mAdapter;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
       appComponent.inject(this);
       viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel.class);
       viewModel.setView(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_fragment;
    }

    @Override
    public void show() {
        progress.show();
    }

    @Override
    public void hide() {
        progress.hide();
    }


    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new CoinListAdapter(getContext(),this);
        rvList.setAdapter(mAdapter);
        viewModel.getData()
                .observe(this, coinList -> {
                    if(coinList != null && coinList.getCoins() != null){
                        Coin[] coins = coinList.getCoins();
                        List<Coin> items = new ArrayList<>();
                        for(Coin coin: coins){
                            if(coin != null){
                                items.add(coin);
                            }
                        }
                        mAdapter.setItems(items); //!!
                    }
                });
    }

    @Override
    public void setRefreshing(boolean refreshing) {
    if(swRefresh != null){
        swRefresh.setRefreshing(refreshing);
    }
    }



    @Override
    public void onRefresh()
    {
     viewModel.onRefresh();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.onRefresh();

    }

    @Override
    public void onItemClick(Coin coin) {

        CoinInfoFragment f = new CoinInfoFragment();
        Bundle args = new Bundle();
        args.putLong("id",coin.getId());
//        args.putParcelable("item",coin);
        f.setArguments(args);
        FragmentUtils.changeFragment(getActivity(),f);
    }
}
