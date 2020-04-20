package com.example.headspaceapplication.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PicsumResponse(

	@Json(name="author")
	val author: String,

	@Json(name="width")
	val width: Int,

	@Json(name="download_url")
	val downloadUrl: String,

	@Json(name="id")
	val id: String,

	@Json(name="url")
	val url: String,

	@Json(name="height")
	val height: Int
): Parcelable
{
	companion object {

		@JvmStatic
		@BindingAdapter("profileImage")
		fun loadImage(view: ImageView, profileImage: String?) {
			Glide.with(view.context)
				.load(profileImage)
				.into(view)
		}
	}
}

