
package com.example.vrgsoft.nyt;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({
        "views", "share_count"
})
@JsonPropertyOrder({
    "url",
    "adx_keywords",
    "subsection",
    "email_count",
    "count_type",
    "column",
    "eta_id",
    "section",
    "id",
    "asset_id",
    "nytdsection",
    "byline",
    "type",
    "title",
    "abstract",
    "published_date",
    "source",
    "updated",
    "des_facet",
    "org_facet",
    "per_facet",
    "geo_facet",
    "media",
    "uri"
})
public class Result implements Serializable, Parcelable
{

    @JsonProperty("url")
    private String url;
    @JsonProperty("adx_keywords")
    private String adxKeywords;
    @JsonProperty("subsection")
    private String subsection;
    @JsonProperty("email_count")
    private Long emailCount;
    @JsonProperty("count_type")
    private String countType;
    @JsonProperty("column")
    private String column;
    @JsonProperty("eta_id")
    private Long etaId;
    @JsonProperty("section")
    private String section;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("asset_id")
    private Long assetId;
    @JsonProperty("nytdsection")
    private String nytdsection;
    @JsonProperty("byline")
    private String byline;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("abstract")
    private String _abstract;
    @JsonProperty("published_date")
    private String publishedDate;
    @JsonProperty("source")
    private String source;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("des_facet")
    private List<String> desFacet = null;
    @JsonProperty("org_facet")
    private List<String> orgFacet = null;
    @JsonProperty("per_facet")
    private List<String> perFacet;
    @JsonProperty("geo_facet")
    private List<String> geoFacet = null;
    @JsonProperty("media")
    private List<Medium> media = null;
    @JsonProperty("uri")
    private String uri;
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2233117502485096481L;

    protected Result(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.adxKeywords = ((String) in.readValue((String.class.getClassLoader())));
        this.subsection = ((String) in.readValue((String.class.getClassLoader())));
        this.emailCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.countType = ((String) in.readValue((String.class.getClassLoader())));
        this.column = ((String) in.readValue((String.class.getClassLoader())));
        this.etaId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.section = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.assetId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.nytdsection = ((String) in.readValue((String.class.getClassLoader())));
        this.byline = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this._abstract = ((String) in.readValue((String.class.getClassLoader())));
        this.publishedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.updated = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.desFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.orgFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.perFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.geoFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.media, (com.example.vrgsoft.nyt.Medium.class.getClassLoader()));
        this.uri = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param adxKeywords
     * @param emailCount
     * @param nytdsection
     * @param perFacet
     * @param subsection
     * @param orgFacet
     * @param geoFacet
     * @param desFacet
     * @param type
     * @param uri
     * @param url
     * @param section
     * @param id
     * @param title
     * @param byline
     * @param source
     * @param assetId
     * @param updated
     * @param etaId
     * @param column
     * @param _abstract
     * @param publishedDate
     * @param media
     * @param countType
     */
    public Result(String url, String adxKeywords, String subsection, Long emailCount, String countType, String column, Long etaId, String section, Long id, Long assetId, String nytdsection, String byline, String type, String title, String _abstract, String publishedDate, String source, String updated, List<String> desFacet, List<String> orgFacet, List<String> perFacet, List<String> geoFacet, List<Medium> media, String uri) {
        super();
        this.url = url;
        this.adxKeywords = adxKeywords;
        this.subsection = subsection;
        this.emailCount = emailCount;
        this.countType = countType;
        this.column = column;
        this.etaId = etaId;
        this.section = section;
        this.id = id;
        this.assetId = assetId;
        this.nytdsection = nytdsection;
        this.byline = byline;
        this.type = type;
        this.title = title;
        this._abstract = _abstract;
        this.publishedDate = publishedDate;
        this.source = source;
        this.updated = updated;
        this.desFacet = desFacet;
        this.orgFacet = orgFacet;
        this.perFacet = perFacet;
        this.geoFacet = geoFacet;
        this.media = media;
        this.uri = uri;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("adx_keywords")
    public String getAdxKeywords() {
        return adxKeywords;
    }

    @JsonProperty("adx_keywords")
    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    @JsonProperty("subsection")
    public String getSubsection() {
        return subsection;
    }

    @JsonProperty("subsection")
    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    @JsonProperty("email_count")
    public Long getEmailCount() {
        return emailCount;
    }

    @JsonProperty("email_count")
    public void setEmailCount(Long emailCount) {
        this.emailCount = emailCount;
    }

    @JsonProperty("count_type")
    public String getCountType() {
        return countType;
    }

    @JsonProperty("count_type")
    public void setCountType(String countType) {
        this.countType = countType;
    }

    @JsonProperty("column")
    public String getColumn() {
        return column;
    }

    @JsonProperty("column")
    public void setColumn(String column) {
        this.column = column;
    }

    @JsonProperty("eta_id")
    public Long getEtaId() {
        return etaId;
    }

    @JsonProperty("eta_id")
    public void setEtaId(Long etaId) {
        this.etaId = etaId;
    }

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("asset_id")
    public Long getAssetId() {
        return assetId;
    }

    @JsonProperty("asset_id")
    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    @JsonProperty("nytdsection")
    public String getNytdsection() {
        return nytdsection;
    }

    @JsonProperty("nytdsection")
    public void setNytdsection(String nytdsection) {
        this.nytdsection = nytdsection;
    }

    @JsonProperty("byline")
    public String getByline() {
        return byline;
    }

    @JsonProperty("byline")
    public void setByline(String byline) {
        this.byline = byline;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("abstract")
    public String getAbstract() {
        return _abstract;
    }

    @JsonProperty("abstract")
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    @JsonProperty("published_date")
    public String getPublishedDate() {
        return publishedDate;
    }

    @JsonProperty("published_date")
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("des_facet")
    public List<String> getDesFacet() {
        return desFacet;
    }

    @JsonProperty("des_facet")
    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    @JsonProperty("org_facet")
    public List<String> getOrgFacet() {
        return orgFacet;
    }

    @JsonProperty("org_facet")
    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    @JsonProperty("per_facet")
    public List<String> getPerFacet() {
        return perFacet;
    }

    @JsonProperty("per_facet")
    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    @JsonProperty("geo_facet")
    public List<String> getGeoFacet() {
        return geoFacet;
    }

    @JsonProperty("geo_facet")
    public void setGeoFacet(List<String> geoFacet) {
        this.geoFacet = geoFacet;
    }

    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(adxKeywords);
        dest.writeValue(subsection);
        dest.writeValue(emailCount);
        dest.writeValue(countType);
        dest.writeValue(column);
        dest.writeValue(etaId);
        dest.writeValue(section);
        dest.writeValue(id);
        dest.writeValue(assetId);
        dest.writeValue(nytdsection);
        dest.writeValue(byline);
        dest.writeValue(type);
        dest.writeValue(title);
        dest.writeValue(_abstract);
        dest.writeValue(publishedDate);
        dest.writeValue(source);
        dest.writeValue(updated);
        dest.writeList(desFacet);
        dest.writeList(orgFacet);
        dest.writeList(perFacet);
        dest.writeList(geoFacet);
        dest.writeList(media);
        dest.writeValue(uri);
    }

    public int describeContents() {
        return  0;
    }

}
