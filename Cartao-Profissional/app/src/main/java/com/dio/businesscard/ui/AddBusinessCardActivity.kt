package com.dio.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.dio.businesscard.App
import com.dio.businesscard.R
import com.dio.businesscard.data.BusinessCard
import com.dio.businesscard.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBusinessCardBinding
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        addBusinessCard()
        closeActivity()
    }

    private fun addBusinessCard() {
        binding.confirmButton.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.nameInputText.editText?.text.toString(),
                company = binding.companyNameInputText.editText?.text.toString(),
                phone = binding.phoneInputText.editText?.text.toString(),
                email = binding.emailInputText.editText?.text.toString(),
                backgroundColor = binding.colorInputText.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun closeActivity() {
        binding.closeImageButton.setOnClickListener {
            finish()
        }
    }
}