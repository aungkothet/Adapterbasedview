package io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.UserVO;

public class InterestUserListTypeConverter {

    @TypeConverter
    public static String interestUserListToJson(List<UserVO> interestUserList) {
        String s = new Gson().toJson(interestUserList,new TypeToken<List<UserVO>>(){}.getType());
        return s;
    }

    @TypeConverter
    public static List<UserVO> interestUserListFromJson(String jsonString) {
        return new Gson().fromJson(jsonString, new TypeToken<List<UserVO>>() {
        }.getType());
    }
}
