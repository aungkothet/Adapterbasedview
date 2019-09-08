package io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.EventsApi;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.response.GetEventsResponse;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RetrofitDataAgentImpl implements EventDataAgent {

    private static RetrofitDataAgentImpl objInstance;

    private EventsApi eventsApi;

    public static RetrofitDataAgentImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    private RetrofitDataAgentImpl(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, SECONDS)
                .writeTimeout(15, SECONDS)
                .readTimeout(15, SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EventConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        eventsApi = retrofit.create(EventsApi.class);

    }

    @Override
    public void getEvents(String accessToken, final GetEnventFromNetworkDelegates delegates) {

        Call<GetEventsResponse> eventsResponseCall = eventsApi.getAllEvents(accessToken);
        eventsResponseCall.enqueue(new Callback<GetEventsResponse>() {
            @Override
            public void onResponse(Call<GetEventsResponse> call, Response<GetEventsResponse> response) {
                if(response.body().isResponseOk()){
                    delegates.onSuccess(response.body().getData());
                }else {
                    delegates.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetEventsResponse> call, Throwable t) {
                delegates.onFailure(t.getMessage());
            }
        });

    }

}
