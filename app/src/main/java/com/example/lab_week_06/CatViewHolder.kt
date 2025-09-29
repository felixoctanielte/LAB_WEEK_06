package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender
class CatViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.cat_name)
    private val bioText: TextView = itemView.findViewById(R.id.cat_biography)
    private val breedText: TextView = itemView.findViewById(R.id.cat_breed)
    private val genderText: TextView = itemView.findViewById(R.id.cat_gender)
    private val catImage: ImageView = itemView.findViewById(R.id.cat_photo)

    fun bindData(cat: CatModel) {
        nameText.text = cat.name
        bioText.text = cat.biography
        breedText.text = cat.breed.name
        genderText.text = when (cat.gender) {
            Gender.Male -> "♂"
            Gender.Female -> "♀"
            Gender.Unknown -> "?"
        }
        imageLoader.loadImage(catImage, cat.imageUrl)
    }
}
