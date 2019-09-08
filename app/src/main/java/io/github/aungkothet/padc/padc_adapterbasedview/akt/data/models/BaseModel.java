package io.github.aungkothet.padc.padc_adapterbasedview.akt.data.models;

import android.content.Context;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents.EventDataAgent;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents.HttpUrlConnectionDataAgentsImpl;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents.OkHttpDataAgentImpl;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.EventsDatabase;

public abstract class BaseModel {
    protected EventDataAgent mDataAgent;

    protected EventsDatabase mDatabase;

    BaseModel(Context context) {
//        this.mDataAgent = HttpUrlConnectionDataAgentsImpl.getObjInstance();
        this.mDataAgent = OkHttpDataAgentImpl.getObjInstance();
        this.mDatabase = EventsDatabase.getObjectInstance(context);
    }
}
