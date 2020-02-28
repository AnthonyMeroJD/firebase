package com.merodev.firebase

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Users(var cargo : String= "", var correo : String = "",var nombre : String  = "" ){


    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "cargo" to cargo,
            "correo" to correo,
            "nombre" to nombre
        )
    }
}