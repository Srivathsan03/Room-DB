package com.srivathsan.room.view.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.srivathsan.room.R
import com.srivathsan.room.model.network.response.User
import com.srivathsan.room.model.network.service.ApiService
import com.srivathsan.room.model.network.service.RetrofitClientInstance
import com.srivathsan.room.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val databaseName = "Room"
    private lateinit var context: Context
    private lateinit var service: ApiService
    private lateinit var adapter: UserAdapter
    val userList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        service = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)

        adapter = UserAdapter(userList)
        rvUsers.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvUsers.layoutManager = layoutManager

        getUsers()
        saveUsers()
    }

    private fun getUsers() {
        val call = service.getUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    userList.addAll(response.body()!!)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun saveUsers() {
//        val db = Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            databaseName
//        ).build()
    }
}
