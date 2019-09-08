package io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents;

import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;

public interface EventDataAgent {
    void getEvents(String accessToken,GetEnventFromNetworkDelegates delegates);

    interface GetEnventFromNetworkDelegates{
        void onSuccess(List<EventV0> events);
        void onFailure(String errorMessage);
    }

}
