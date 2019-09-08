package io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;

@Dao
public interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertEvents(List<EventV0> eventV0List);

    @Query("SELECT * FROM event")
    List<EventV0> getAllEventsFromDB();

}
