package com.example.sokol.cointest.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sokol.cointest.R;
import com.example.sokol.cointest.storage.entity.Coin;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoinListAdapter extends RecyclerView.Adapter<CoinListAdapter.ViewHolder> {

    private Context context;
    private List<Coin> mCoinList;
    static AdapterClickListener listener;

    public CoinListAdapter(Context context, AdapterClickListener listener) {
        this.context = context;
//        this.mCoinList = mCoinList;
        this.listener = listener;
        mCoinList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void setItems(List<Coin> items) {
        mCoinList.clear();
        mCoinList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coin coin = mCoinList.get(position);


        holder._coinName.setText(coin.getName());
        holder._coinSymbole.setText(coin.getSymbol());
        holder._coinPrice.setText(coin.getQuote().getUsd().getPrice());
        holder._coin24HourChange.setText(coin.getQuote().getUsd().getVolume_24h());
    }

    @Override
    public int getItemCount() {
        return mCoinList.size();
    }

    public Coin getItem(int position){return mCoinList.get(position);}

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
//        super.onViewAttachedToWindow(holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(mCoinList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
        holder.itemView.setOnClickListener(null);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.coinName)
        TextView _coinName;
        @BindView(R.id.coinSymbol)
        TextView _coinSymbole;
        @BindView(R.id.coinPrice)
        TextView _coinPrice;
        @BindView(R.id.coin24HourChange)
        TextView _coin24HourChange;


        public ViewHolder(View itemView){
          super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
