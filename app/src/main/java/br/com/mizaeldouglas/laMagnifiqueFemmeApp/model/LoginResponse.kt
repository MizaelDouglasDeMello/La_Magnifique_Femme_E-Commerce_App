package br.com.mizaeldouglas.laMagnifiqueFemmeApp.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("token")
    val token: String = ""

)