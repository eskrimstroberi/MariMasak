package com.example.uklrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

    class Home : AppCompatActivity() {
        private lateinit var rvResep: RecyclerView
        private var list:ArrayList<Resep> = arrayListOf()
        private var title: String = "Mari Masak"

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_home)
                setActionBarTitle(title)

                rvResep = findViewById(R.id.rv_resep)
                rvResep.setHasFixedSize(true)

                list.addAll(Resepdata.listResep)
                showRecyclerList()
            }
            private fun showRecyclerList() {
                rvResep.layoutManager = LinearLayoutManager(this)
                val GridResepAdapter = GridResepAdapter(list)
                rvResep.adapter = GridResepAdapter


                GridResepAdapter.setOnItemClickCallback(object : GridResepAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: Resep) {showSelectedResep(data)}
            })
        }
            override fun onCreateOptionsMenu(menu: Menu): Boolean {
                menuInflater.inflate(R.menu.menu_main, menu)
                return super.onCreateOptionsMenu(menu)
            }
            override fun onOptionsItemSelected(item: MenuItem): Boolean {
                setMode(item.itemId)
                return super.onOptionsItemSelected(item)
            }
            private fun setMode(selectedMode: Int) {
                when (selectedMode) {
                    R.id.action_grid -> {
                        title = "Mode Grid"
                        showRecyclerGrid()
                    }
                    R.id.action_cardview -> {
                        title = "Mode CardView"
                        showRecyclerCardView()
                    }
                }
            }
            private fun showRecyclerGrid() {
                rvResep.layoutManager = GridLayoutManager(this, 2)
                val gridResepAdapter = GridResepAdapter(list)
                rvResep.adapter = gridResepAdapter

                gridResepAdapter.setOnItemClickCallback(object : GridResepAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: Resep) {
                        showSelectedResep(data)
                    }
                })

            }

            private fun showRecyclerCardView() {
                rvResep.layoutManager = LinearLayoutManager(this)
                val cardViewResepAdapter = CardViewResepAdapter(list)
                rvResep.adapter = cardViewResepAdapter
            }
            private fun setActionBarTitle(title: String) {
                supportActionBar?.title = title
            }
            private fun showSelectedResep(resep: Resep){
                Toast.makeText(this, "Kamu memilih " + resep.name, Toast.LENGTH_SHORT).show()
            }
        }