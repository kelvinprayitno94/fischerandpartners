package com.test.enigma.model

import com.google.gson.annotations.SerializedName

data class MovieReviewResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("page") var page: Int,
    @SerializedName("results") var results: List<MovieReviewResults>,
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("total_results") var totalResults: Int

)

data class AuthorDetails(
    @SerializedName("name") var name: String,
    @SerializedName("username") var username: String,
    @SerializedName("avatar_path") var avatarPath: String,
    @SerializedName("rating") var rating: Int
)

data class MovieReviewResults(
    @SerializedName("author") var author: String,
    @SerializedName("author_details") var authorDetails: AuthorDetails,
    @SerializedName("content") var content: String,
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("id") var id: String,
    @SerializedName("updated_at") var updatedAt: String,
    @SerializedName("url") var url: String
)
