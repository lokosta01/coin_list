package com.example.sokol.cointest.ui.fragment.view;

import com.example.sokol.cointest.ui.view.IBaseView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public interface ICoinListFragment extends IBaseView, SwipeRefreshLayout.OnRefreshListener {
    //для методов , которые будем использовать во ViewModel
    void setRefreshing(boolean refreshing);

    void show();
    void hide();
}
