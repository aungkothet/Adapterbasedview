package io.github.aungkothet.padc.padc_adapterbasedview.akt.data.models;

import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents.EventDataAgent;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants;

import static io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants.DUMMY_ACCESS_TOKEN;

public class EventModelImpl extends BaseModel implements EventModel {


    private static EventModelImpl objInstance;

    private EventModelImpl(Context context) {
        super(context);
    }

    public static void initializeEventModel(Context context){
        objInstance = new EventModelImpl(context);
    }
    public static EventModelImpl getObjInstance() {
        if (objInstance == null) {
            throw new RuntimeException(EventConstants.MSG_RUNTIME_EXCEPTION);
        }
        return objInstance;
    }

    @Override

    public void getEvents(final GetEventsFromDataLayerDelegate delegates) {
        if(!mDatabase.eventsExitInDB()) {
            mDataAgent.getEvents(DUMMY_ACCESS_TOKEN, new EventDataAgent.GetEnventFromNetworkDelegates() {

                @Override
                public void onSuccess(List<EventV0> events) {
                    long[] ids = mDatabase.eventDao().insertEvents(events);
                    delegates.onSuccess(events);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegates.onFailure(errorMessage);
                }
            });
        } else {
            List<EventV0> eventsFromDB = mDatabase.eventDao().getAllEventsFromDB();
            delegates.onSuccess(eventsFromDB);
        }
    }
}
