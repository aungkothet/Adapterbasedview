package io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.network.response.GetEventsResponse;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants.ACCESS_TOKEN;
import static io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants.EM_NULL_RESPONSE;
import static java.util.concurrent.TimeUnit.SECONDS;

public class OkHttpDataAgentImpl implements EventDataAgent {

    private static OkHttpDataAgentImpl objInstance;

    private OkHttpClient mHttpClient;

    private OkHttpDataAgentImpl() {

        mHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, SECONDS)
                .writeTimeout(15, SECONDS)
                .readTimeout(15, SECONDS)
                .build();
    }

    public static OkHttpDataAgentImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accessToken, GetEnventFromNetworkDelegates delegates) {
        new GetEventsTask(mHttpClient,accessToken, delegates).execute();
    }


    private static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse> {

        OkHttpClient httpClient;
        String accessToken;
        GetEnventFromNetworkDelegates delegates;

        public GetEventsTask(OkHttpClient okHttpClient, String accessToken, GetEnventFromNetworkDelegates delegates) {
            this.httpClient = okHttpClient;
            this.accessToken = accessToken;
            this.delegates = delegates;

        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            RequestBody requestBody = new FormBody.Builder()
                    .add(ACCESS_TOKEN, accessToken)
                    .build();

            Request request = new Request.Builder()
                    .url(EventConstants.BASE_URL + EventConstants.GET_EVENTS)
                    .post(requestBody)
                    .build();

            try {

                Response response = httpClient.newCall(request).execute();
                if(response.isSuccessful()){
                    String responseString = response.body().string();
                    GetEventsResponse getEventsResponse = new Gson().fromJson(responseString, GetEventsResponse.class);
                    return getEventsResponse;
                }

            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(GetEventsResponse getEventsResponse) {
            super.onPostExecute(getEventsResponse);
            if (getEventsResponse != null) {
                if (getEventsResponse.isResponseOk()) {
                    delegates.onSuccess(getEventsResponse.getData());
                } else {
                    delegates.onFailure(getEventsResponse.getMessage());
                }

            } else {
                delegates.onFailure(EM_NULL_RESPONSE);
            }
        }
    }
}
