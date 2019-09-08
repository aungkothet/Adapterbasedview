package io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventOrganizerVO;

public class EventOrganizerTypeConverter {

    @TypeConverter
    public static String eventOrganizerToJson(EventOrganizerVO eventOrganizerVO){
       return new Gson().toJson(eventOrganizerVO);
    }

    @TypeConverter
    public static EventOrganizerVO eventOrganizerFromJson(String jsonString){
        return new Gson().fromJson(jsonString,EventOrganizerVO.class);
    }
}
