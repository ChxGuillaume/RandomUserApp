package com.example.ynovapp.model

import com.google.gson.annotations.SerializedName

data class Street (

	@SerializedName("number") val street : String,
	@SerializedName("name") val city : String

)