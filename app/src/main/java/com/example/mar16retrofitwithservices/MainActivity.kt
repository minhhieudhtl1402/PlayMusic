package com.example.mar16retrofitwithservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mar16retrofitwithservices.adapter.MusicAdapter
import com.example.mar16retrofitwithservices.databinding.ActivityMainBinding
import com.example.mar16retrofitwithservices.model.MusicAlbum
import com.example.mar16retrofitwithservices.network.MusicClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var musicAlbum: MusicAlbum
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {
            val result = MusicClient.invoke().getMusicAlbum()
            if (result.isSuccessful) {
                musicAlbum = result.body()!!
                Log.i("vmhieu", musicAlbum.toString())
            }
            withContext(Dispatchers.Main)
            {
                val adapter=MusicAdapter(musicAlbum)
                binding.rcMain.adapter=adapter
                binding.rcMain.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            }
        }


    }

}