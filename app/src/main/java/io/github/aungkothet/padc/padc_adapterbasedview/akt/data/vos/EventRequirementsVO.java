package io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventRequirementsVO {

    
    @SerializedName("gender")
    @Expose
    private int gender;
    
    @SerializedName("age_range")
    @Expose
    private String ageRange;
    
    @SerializedName("privacy")
    @Expose
    private String privacy;
    
    @SerializedName("max_people_available")
    @Expose
    private int maxPeopleAvailable;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public int getMaxPeopleAvailable() {
        return maxPeopleAvailable;
    }

    public void setMaxPeopleAvailable(int maxPeopleAvailable) {
        this.maxPeopleAvailable = maxPeopleAvailable;
    }
}
