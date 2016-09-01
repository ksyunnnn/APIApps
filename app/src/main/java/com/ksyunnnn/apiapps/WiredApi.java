package com.ksyunnnn.apiapps;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WiredApi {
    @GET("/rssfeeder/")
    public Call<Rss> wiredGet();
}

