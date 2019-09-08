package io.github.aungkothet.padc.padc_adapterbasedview.akt.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.R;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.adapters.EventListAdapter;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.models.EventModel;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.delegates.EventItemDelegate;

public class MainActivity extends BaseActivity implements EventItemDelegate {

    @BindView(R.id.rvEvents)
    RecyclerView rvEvents;
    EventListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvEvents.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));
        adapter = new EventListAdapter(this);
        rvEvents.setAdapter(adapter);

        mEventModel.getEvents(new EventModel.GetEventsFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<EventV0> events) {
                adapter.setNewData(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                showSnack(errorMessage);
            }
        });

    }

    @Override
    public void onTapEventItem() {
        startActivity(new Intent(this, NewActivity.class));
    }
}
