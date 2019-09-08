package io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventRequirementsVO;

public class EventRequirementTypeConverter {

    @TypeConverter
    public static String eventRequirementToJson(EventRequirementsVO eventRequirementsVO) {
        return new Gson().toJson(eventRequirementsVO);
    }

    @TypeConverter
    public static EventRequirementsVO eventRequirementFromJson(String jsonString) {
        return new Gson().fromJson(jsonString, EventRequirementsVO.class);
    }
}
