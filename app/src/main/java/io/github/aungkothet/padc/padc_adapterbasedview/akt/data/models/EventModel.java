package io.github.aungkothet.padc.padc_adapterbasedview.akt.data.models;

import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;

public interface EventModel {

    void getEvents(GetEventsFromDataLayerDelegate delegates);

    interface GetEventsFromDataLayerDelegate{
        void onSuccess(List<EventV0> events);
        void onFailure(String errorMessage);
    }
}
