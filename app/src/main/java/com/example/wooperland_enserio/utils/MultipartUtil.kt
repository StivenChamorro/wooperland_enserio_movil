package com.example.wooperland_enserio.utils


import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

fun preparePart(key: String, value: String): RequestBody {
    return RequestBody.create("text/plain".toMediaTypeOrNull(), value)
}

fun prepareFilePart(key: String, file: File): MultipartBody.Part {
    val requestFile = RequestBody.create("image/jpeg".toMediaTypeOrNull(), file)
    return MultipartBody.Part.createFormData(key, file.name, requestFile)
}