package io.github.aungkothet.padc.padc_adapterbasedview.akt.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.R;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.delegates.EventItemDelegate;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.views.holders.EventItemViewHolder;

public class EventListAdapter extends BaseRecyclerAdapter<EventItemViewHolder, EventV0> {

    private EventItemDelegate mEventItemDelegate;

    public EventListAdapter(EventItemDelegate mEventItemDelegate) {
        this.mEventItemDelegate = mEventItemDelegate;
    }

    @NonNull
    @Override
    public EventItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_event,viewGroup,false);
        return new EventItemViewHolder(view, mEventItemDelegate);
    }
}
