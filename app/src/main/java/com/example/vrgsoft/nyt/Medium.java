
package com.example.vrgsoft.nyt;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "subtype",
    "caption",
    "copyright",
    "approved_for_syndication",
    "media-metadata"
})
public class Medium implements Serializable, Parcelable
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("subtype")
    private String subtype;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("approved_for_syndication")
    private Long approvedForSyndication;
    @JsonProperty("media-metadata")
    private List<MediaMetadatum> mediaMetadata = null;
    public final static Parcelable.Creator<Medium> CREATOR = new Creator<Medium>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Medium createFromParcel(Parcel in) {
            return new Medium(in);
        }

        public Medium[] newArray(int size) {
            return (new Medium[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6227517648832362179L;

    protected Medium(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.subtype = ((String) in.readValue((String.class.getClassLoader())));
        this.caption = ((String) in.readValue((String.class.getClassLoader())));
        this.copyright = ((String) in.readValue((String.class.getClassLoader())));
        this.approvedForSyndication = ((Long) in.readValue((Long.class.getClassLoader())));
        in.readList(this.mediaMetadata, (com.example.vrgsoft.nyt.MediaMetadatum.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Medium() {
    }

    /**
     * 
     * @param subtype
     * @param mediaMetadata
     * @param caption
     * @param copyright
     * @param type
     * @param approvedForSyndication
     */
    public Medium(String type, String subtype, String caption, String copyright, Long approvedForSyndication, List<MediaMetadatum> mediaMetadata) {
        super();
        this.type = type;
        this.subtype = subtype;
        this.caption = caption;
        this.copyright = copyright;
        this.approvedForSyndication = approvedForSyndication;
        this.mediaMetadata = mediaMetadata;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("subtype")
    public String getSubtype() {
        return subtype;
    }

    @JsonProperty("subtype")
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @JsonProperty("approved_for_syndication")
    public Long getApprovedForSyndication() {
        return approvedForSyndication;
    }

    @JsonProperty("approved_for_syndication")
    public void setApprovedForSyndication(Long approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    @JsonProperty("media-metadata")
    public List<MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }

    @JsonProperty("media-metadata")
    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(subtype);
        dest.writeValue(caption);
        dest.writeValue(copyright);
        dest.writeValue(approvedForSyndication);
        dest.writeList(mediaMetadata);
    }

    public int describeContents() {
        return  0;
    }

}
