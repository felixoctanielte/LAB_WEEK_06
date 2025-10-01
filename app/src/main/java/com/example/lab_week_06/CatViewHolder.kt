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
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener // gunakan dari CatAdapter
) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.cat_name)
    private val bioText: TextView = itemView.findViewById(R.id.cat_biography)
    private val breedText: TextView = itemView.findViewById(R.id.cat_breed)
    private val genderText: TextView = itemView.findViewById(R.id.cat_gender)
    private val catImage: ImageView = itemView.findViewById(R.id.cat_photo)

    fun bindData(cat: CatModel) {
        itemView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }

        nameText.text = cat.name
        bioText.text = cat.biography
        breedText.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }
        genderText.text = when (cat.gender) {
            Gender.Male -> "♂"
            Gender.Female -> "♀"
            else -> "?"
        }

        // Pastikan urutannya sesuai dengan definisi di ImageLoader
        imageLoader.loadImage(catImage, cat.imageUrl)
    }
}
