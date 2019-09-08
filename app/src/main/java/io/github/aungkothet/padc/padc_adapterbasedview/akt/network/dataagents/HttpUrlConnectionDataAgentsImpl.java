package io.github.aungkothet.padc.padc_adapterbasedview.akt.network.dataagents;

import android.os.AsyncTask;
import android.util.Log;

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

import static io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants.EM_NULL_RESPONSE;


public class HttpUrlConnectionDataAgentsImpl implements EventDataAgent {

    private static HttpUrlConnectionDataAgentsImpl objInstance;

    private HttpUrlConnectionDataAgentsImpl() {

    }

    public static HttpUrlConnectionDataAgentsImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new HttpUrlConnectionDataAgentsImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accessToken, GetEnventFromNetworkDelegates delegates) {
        Log.d("DATAAGENT", accessToken);
        new GetEventsTask(accessToken, delegates).execute();
    }

    private static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse> {
        String accessToken;
        GetEnventFromNetworkDelegates delegates;

        public GetEventsTask(String accessToken, GetEnventFromNetworkDelegates delegates) {
            this.accessToken = accessToken;
            this.delegates = delegates;

        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {
            URL url;
            StringBuilder stringBuilder;
            BufferedReader reader = null;

            try {

                url = new URL(EventConstants.BASE_URL + EventConstants.GET_EVENTS);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");
                connection.setConnectTimeout(15 * 1000);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                List<NameValuePair> param = new ArrayList<>();
                param.add(new BasicNameValuePair(EventConstants.ACCESS_TOKEN, accessToken));

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(param));
                writer.flush();
                writer.close();
                outputStream.close();
                connection.connect();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                String responseString = stringBuilder.toString();

                GetEventsResponse response = new Gson().fromJson(responseString, GetEventsResponse.class);
                return response;

            } catch (Exception e) {

            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        private String getQuery(List<NameValuePair> param) throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            boolean first = true;
            for (NameValuePair pairs : param) {
                if (first)
                    first = false;
                else
                    result.append("&");
                result.append(URLEncoder.encode(pairs.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pairs.getValue(), "UTF-8"));
            }
            return result.toString();
        }

        @Override
        protected void onPostExecute(GetEventsResponse getEventsResponse) {
            super.onPostExecute(getEventsResponse);
            if (getEventsResponse != null) {
                if(getEventsResponse.isResponseOk()){
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
