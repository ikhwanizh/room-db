package com.ikhwanizh.localdatabase.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.ikhwanizh.localdatabase.MainActivity
import com.ikhwanizh.localdatabase.data.local.UserEntity
import com.ikhwanizh.localdatabase.databinding.ActivityRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = RegisterViewModel(application)
        binding.btnLogin.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            var user = UserEntity(0,name, email, password)
            CoroutineScope(viewModel.viewModelScope.coroutineContext).launch {
                viewModel.insertUser(user)
                startActivity(Intent(this@RegisterActivity,MainActivity::class.java))
            }
            Toast.makeText(this, "Sucses", Toast.LENGTH_SHORT).show()
        }
    }
}