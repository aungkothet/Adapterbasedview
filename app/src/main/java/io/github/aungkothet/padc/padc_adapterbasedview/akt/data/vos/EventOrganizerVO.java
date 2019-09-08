package io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventOrganizerVO {

    
    @SerializedName("organizer_name")
    @Expose
    private String organizerName;
    
    @SerializedName("organizer_photo_url")
    @Expose
    private String organizerPhotoUrl;
    
    @SerializedName("organizer_role")
    @Expose
    private String organizerRole;

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerPhotoUrl() {
        return organizerPhotoUrl;
    }

    public void setOrganizerPhotoUrl(String organizerPhotoUrl) {
        this.organizerPhotoUrl = organizerPhotoUrl;
    }

    public String getOrganizerRole() {
        return organizerRole;
    }

    public void setOrganizerRole(String organizerRole) {
        this.organizerRole = organizerRole;
    }
}
