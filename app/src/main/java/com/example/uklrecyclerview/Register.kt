package com.example.uklrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

    class Register : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

            val view_pager = findViewById<ViewPager>(R.id.view_pager)
            view_pager.adapter = ViewPagerAdapter( this, supportFragmentManager)

            val tabs = findViewById<TabLayout>(R.id.tabs)
            tabs.setupWithViewPager(view_pager)
    }
}