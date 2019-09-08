package io.github.aungkothet.padc.padc_adapterbasedview.akt.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos.EventV0;

import static io.github.aungkothet.padc.padc_adapterbasedview.akt.utils.EventConstants.CODE_RESPONSE_OK;

public class GetEventsResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<EventV0> data;

    @SerializedName("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<EventV0> getData() {
        return data;
    }

    public void setData(List<EventV0> eventList) {
        this.data = eventList;
    }

    public boolean isResponseOk(){
        return code == CODE_RESPONSE_OK && data != null;
    }
}
