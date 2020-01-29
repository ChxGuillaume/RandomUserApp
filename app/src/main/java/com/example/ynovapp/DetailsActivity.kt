package com.example.ynovapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.item_note.view.*


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val bundleExtras = intent.extras

        lastName.text = bundleExtras?.getString("lastName")
        firstName.text = bundleExtras?.getString("firstName")
        email.text = bundleExtras?.getString("email")
        address.text = bundleExtras?.getString("address")


        Glide.with(this)
            .load(bundleExtras?.getString("avatar"))
            .into(avatar)
    }
}
