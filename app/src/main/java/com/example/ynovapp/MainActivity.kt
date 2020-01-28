package com.example.ynovapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ynovapp.model.ApiResponse
import com.example.ynovapp.model.RandomPerson
import com.example.ynovapp.network.ApiHelpers
import com.example.ynovapp.network.ApiRequestCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter: RandomPersonAdapter = RandomPersonAdapter()
    var randomPersonList : List<RandomPerson> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiHelper = ApiHelpers(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        apiHelper.getRandomPersons(
            object : ApiRequestCallback<ApiResponse>() {
                override fun onSuccess(result: ApiResponse?) {
                    super.onSuccess(result)

                    runOnUiThread(
                        object : Runnable {
                            override fun run() {
                                randomPersonList = result!!.results
                                adapter.updateList(randomPersonList)
                                val number = adapter.itemCount
                                number.toString()
                            }
                        }
                    )
                }
            }
        )
    }

}
