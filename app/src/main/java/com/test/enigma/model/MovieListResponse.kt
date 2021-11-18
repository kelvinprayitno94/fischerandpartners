package com.test.enigma.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("id") var id : Int,
    @SerializedName("page") var page : Int,
    @SerializedName("results") var results : List<MovieResults>,
    @SerializedName("total_pages") var totalPages : Int,
    @SerializedName("total_results") var totalResults : Int
)

data class MovieResults (
    @SerializedName("description") var description : String,
    @SerializedName("favorite_count") var favoriteCount : Int,
    @SerializedName("id") var id : Int,
    @SerializedName("item_count") var itemCount : Int,
    @SerializedName("iso_639_1") var iso6391 : String,
    @SerializedName("list_type") var listType : String,
    @SerializedName("name") var name : String,
    @SerializedName("poster_path") var posterPath : String
)
