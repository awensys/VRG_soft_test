
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
    "status",
    "copyright",
    "num_results",
    "results"
})
public class NYT implements Serializable, Parcelable
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("num_results")
    private Long numResults;
    @JsonProperty("results")
    private List<Result> results = null;
    public final static Parcelable.Creator<NYT> CREATOR = new Creator<NYT>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NYT createFromParcel(Parcel in) {
            return new NYT(in);
        }

        public NYT[] newArray(int size) {
            return (new NYT[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3386752204661852617L;

    protected NYT(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.copyright = ((String) in.readValue((String.class.getClassLoader())));
        this.numResults = ((Long) in.readValue((Long.class.getClassLoader())));
        in.readList(this.results, (com.example.vrgsoft.nyt.Result.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public NYT() {
    }

    /**
     * 
     * @param results
     * @param status
     * @param numResults
     * @param copyright
     */
    public NYT(String status, String copyright, Long numResults, List<Result> results) {
        super();
        this.status = status;
        this.copyright = copyright;
        this.numResults = numResults;
        this.results = results;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @JsonProperty("num_results")
    public Long getNumResults() {
        return numResults;
    }

    @JsonProperty("num_results")
    public void setNumResults(Long numResults) {
        this.numResults = numResults;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(copyright);
        dest.writeValue(numResults);
        dest.writeList(results);
    }

    public int describeContents() {
        return  0;
    }

}
