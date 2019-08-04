
package com.example.vrgsoft.nyt;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "format",
    "height",
    "width"
})
public class MediaMetadatum implements Serializable, Parcelable
{

    @JsonProperty("url")
    private String url;
    @JsonProperty("format")
    private String format;
    @JsonProperty("height")
    private Long height;
    @JsonProperty("width")
    private Long width;
    public final static Parcelable.Creator<MediaMetadatum> CREATOR = new Creator<MediaMetadatum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MediaMetadatum createFromParcel(Parcel in) {
            return new MediaMetadatum(in);
        }

        public MediaMetadatum[] newArray(int size) {
            return (new MediaMetadatum[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4899491201850667411L;

    protected MediaMetadatum(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.format = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((Long) in.readValue((Long.class.getClassLoader())));
        this.width = ((Long) in.readValue((Long.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public MediaMetadatum() {
    }

    /**
     * 
     * @param height
     * @param width
     * @param format
     * @param url
     */
    public MediaMetadatum(String url, String format, Long height, Long width) {
        super();
        this.url = url;
        this.format = format;
        this.height = height;
        this.width = width;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("height")
    public Long getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Long height) {
        this.height = height;
    }

    @JsonProperty("width")
    public Long getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Long width) {
        this.width = width;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(format);
        dest.writeValue(height);
        dest.writeValue(width);
    }

    public int describeContents() {
        return  0;
    }

}
