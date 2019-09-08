package io.github.aungkothet.padc.padc_adapterbasedview.akt.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private T mData;

    public abstract void bindData(T Data);

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
