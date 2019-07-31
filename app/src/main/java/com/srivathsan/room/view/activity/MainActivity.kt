package com.srivathsan.room.view.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.srivathsan.room.R
import com.srivathsan.room.model.db.AppDatabase
import com.srivathsan.room.model.network.response.User
import com.srivathsan.room.model.network.service.ApiService
import com.srivathsan.room.model.network.service.RetrofitClientInstance
import com.srivathsan.room.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var context: Context
    private lateinit var service: ApiService
    private lateinit var adapter: UserAdapter
    val userList = ArrayList<User>()
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        service = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)
        db = AppDatabase.getDatabase(context)

        adapter = UserAdapter(userList)
        rvUsers.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        rvUsers.layoutManager = layoutManager

        getUsersFromDb()
        updateDbUsersFromApi()
    }

    private fun updateDbUsersFromApi() {
        val call = service.getUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
//                    userList.addAll(response.body()!!)
//                    adapter.notifyDataSetChanged()
                    saveUsers(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun getUsersFromDb() {
        val a = db.userDao().getAllUsers()
        userList.addAll(a)
        adapter.notifyDataSetChanged()
    }

    private fun saveUsers(list: List<User>) {
        db.userDao().deleteAll()
        for (i in 0 until list.size)
            db.userDao().insertUser(list[i])
    }
}
