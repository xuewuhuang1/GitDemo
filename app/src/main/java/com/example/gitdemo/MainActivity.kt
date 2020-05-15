package com.example.gitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.number.observe(this, Observer {
            textView.text="${viewModel.number.value}"
        })
        button.setOnClickListener {
           viewModel.add(1)
        }
        button2.setOnClickListener {
            viewModel.add(-1)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.reset) {
            viewModel.resetData()
        }
        return super.onOptionsItemSelected(item)
    }
}
