package com.danlibs.soccersimulator.data;

import com.danlibs.soccersimulator.domain.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesApi {

    @GET("matches.json")
    Call<List<Match>> getMatches();
}
