package com.wipro.testapp.model
import com.google.gson.annotations.SerializedName

data class AllFactsResponse(
    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("rows")
    val results: List<ResultsItem>? = null
)

data class ResultsItem(

    @field:SerializedName("title")
    val factName: String? = null,

    @field:SerializedName("imageHref")
    val factImgUrl: String? = null,

    @field:SerializedName("description")
    val factDesc: String? = null
)
