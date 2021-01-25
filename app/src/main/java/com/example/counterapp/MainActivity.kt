package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var Count: Count = Count();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.countTotal = Count

        binding.countUpBtn.setOnClickListener { countUp() }
        binding.countDownBtn.setOnClickListener { countDown() }
        binding.toastBtn.setOnClickListener { showToast(it) }
    }

    private fun countUp(){
        binding.apply {
            Count.total++
            invalidateAll()
        }
    }

    private fun countDown(){
        binding.apply {
            Count.total--
            invalidateAll()
        }
    }

    private fun showToast(view: View){
        val toast = Toast.makeText(applicationContext, "Hello " + Count.total, Toast.LENGTH_SHORT)
        toast.show()
    }
}