package com.example.firsthomework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.firsthomework.R

class MainActivity : AppCompatActivity() {

    private val picturesList = listOf(
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13",
        "https://avatars.mds.yandex.net/i?id=8178acc00163b6f8f5ea60cb907a3d2d-5220043-images-thumbs&n=13"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val btnLoad = findViewById<Button>(R.id.buttonLoadImage)
        val btnNext = findViewById<Button>(R.id.buttonGoToSecond)

        btnLoad.setOnClickListener {
            val randomIndex = (0..9).random()
            val url = picturesList[randomIndex]
            imageView.load(url)
        }

        btnNext.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}