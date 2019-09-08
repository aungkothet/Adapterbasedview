package io.github.aungkothet.padc.padc_adapterbasedview.akt.network;

import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.response.GetEventsResponse;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EventsApi {

    @POST(EventConstants.GET_EVENTS)
    @FormUrlEncoded
    Call<GetEventsResponse> getAllEvents(@Field(EventConstants.ACCESS_TOKEN) String accessToken);
}
