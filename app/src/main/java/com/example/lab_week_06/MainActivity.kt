package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Attach swipe-to-delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Tambahkan data dummy
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg" // ganti biar pasti ada
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Tommy",
                    "Always chasing Jerry",
                    "https://cdn2.thecatapi.com/images/2oo.gif"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Luna",
                    "Loves to sleep on laptops",
                    "https://cdn2.thecatapi.com/images/9oo.jpg"
                ),

                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Nala",
                    "Queen of the jungle",
                    "https://cdn2.thecatapi.com/images/1rq.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Charlie",
                    "Curious and playful",
                    "https://cdn2.thecatapi.com/images/9oo.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.ExoticShorthair,
                    "Shadow",
                    "Hides in the dark corners",
                    "https://cdn2.thecatapi.com/images/b5c.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Leo",
                    "Friendly and brave",
                    "https://cdn2.thecatapi.com/images/c8o.jpg"
                ),

                // Tambahan valid URL
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Misty",
                    "Gentle and shy",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),

                CatModel(
                    Gender.Unknown,
                    CatBreed.BalineseJavanese,
                    "Cleo",
                    "Mysterious and elegant",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Sasha",
                    "Loves climbing furniture",
                    "https://cdn2.thecatapi.com/images/9oo.jpg"
                ),

                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Daisy",
                    "Sweet and gentle",
                    "https://cdn2.thecatapi.com/images/1rq.jpg"
                ),

                // tambahan baru 2
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Smokey",
                    "Loves hiding in boxes",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                )
            )
        )


    }

    // Fungsi dialog pop up
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
