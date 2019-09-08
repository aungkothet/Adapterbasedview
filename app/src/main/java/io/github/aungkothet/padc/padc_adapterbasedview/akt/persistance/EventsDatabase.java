package io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.daos.EventDao;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.typeconverters.EventOrganizerTypeConverter;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.typeconverters.EventRequirementTypeConverter;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.persistance.typeconverters.InterestUserListTypeConverter;

import static io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants.DB_NAME;

@Database(entities = {EventV0.class}, version = 5)
@TypeConverters({EventOrganizerTypeConverter.class,
        EventRequirementTypeConverter.class,
        InterestUserListTypeConverter.class})
public abstract class EventsDatabase extends RoomDatabase {

    private static EventsDatabase objectInstance;

    public static EventsDatabase getObjectInstance(Context context) {
        if (objectInstance == null) {
            objectInstance = Room.databaseBuilder(context, EventsDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objectInstance;
    }

    public abstract EventDao eventDao();

    public boolean eventsExitInDB() {
        return !eventDao().getAllEventsFromDB().isEmpty();
    }

}
