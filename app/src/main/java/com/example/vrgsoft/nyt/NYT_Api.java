package com.example.vrgsoft.nyt;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NYT_Api {

    @GET ("emailed/30.json?api-key=ZpYFS076OzE2JrLhKaVGCqwJMgiYn2qE")
    Call<NYT> getEmailed();
    @GET ("shared/30.json?api-key=ZpYFS076OzE2JrLhKaVGCqwJMgiYn2qE")
    Call<NYT> getShared();
    @GET ("viewed/30.json?api-key=ZpYFS076OzE2JrLhKaVGCqwJMgiYn2qE")
    Call<NYT> getViewed();
}
