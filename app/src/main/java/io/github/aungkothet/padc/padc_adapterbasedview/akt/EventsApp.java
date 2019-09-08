package io.github.aungkothet.padc.padc_adapterbasedview.akt;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.models.EventModelImpl;

public class EventsApp extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        EventModelImpl.initializeEventModel(getApplicationContext());
    }
}
