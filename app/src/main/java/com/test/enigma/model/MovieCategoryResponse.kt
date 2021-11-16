package com.test.enigma.model

import com.google.gson.annotations.SerializedName

data class MovieCategoryResponse(
    @SerializedName("genres") var genres : List<Genres>
)

data class Genres (

    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String

)
