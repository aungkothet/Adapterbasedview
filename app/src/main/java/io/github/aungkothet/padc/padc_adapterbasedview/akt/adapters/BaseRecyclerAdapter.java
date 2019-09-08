package io.github.aungkothet.padc.padc_adapterbasedview.akt.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.views.holders.BaseViewHolder;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    private List<W> mData;

    BaseRecyclerAdapter(){
        mData = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return  mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    public void setNewData(List<W> data){
        this.mData = data;
        notifyDataSetChanged();
    }

    public void appendNewData(List<W> data){
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
