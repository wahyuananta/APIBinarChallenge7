package com.coder.apibinarchallenge7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.coder.apibinarchallenge7.LoginActivity.Companion.TOKEN
import com.coder.apibinarchallenge7.databinding.ActivityAuthBinding
import com.coder.apibinarchallenge7.model.AuthResponse
import com.coder.apibinarchallenge7.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val token = intent.getStringExtra(TOKEN)
        if (token != null) {
            auth(token)
        }
    }

    private fun auth(token : String) {
        ApiClient.instance.auth(token)
            .enqueue(object : Callback<AuthResponse> {
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    val body = response.body()?.dataAuth
                    val code = response.code()
                    if (code == 200) {
                        Toast.makeText(this@AuthActivity, "Authorization Berhasil", Toast.LENGTH_SHORT).show()
                        binding.tvUsername.text = body?.username
                        binding.tvEmail.text = body?.email
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    Toast.makeText(this@AuthActivity, "Authorization Gagal", Toast.LENGTH_SHORT).show()
                }
            })
    }
}