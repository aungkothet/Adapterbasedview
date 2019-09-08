package io.github.aungkothet.padc.padc_adapterbasedview.akt.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserVO {

    @SerializedName("user_name")
    @Expose
    private String userName;
    
    @SerializedName("email")
    @Expose
    private String email;
    
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    
    @SerializedName("photo_url")
    @Expose
    private String photoUrl;
    
    @SerializedName("cover_photo_url")
    @Expose
    private String coverPhotoUrl;
    
    @SerializedName("address")
    @Expose
    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
