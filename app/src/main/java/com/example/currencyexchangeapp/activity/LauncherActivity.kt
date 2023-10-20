package com.example.currencyexchangeapp.activity

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangeapp.R
import com.example.currencyexchangeapp.databinding.ActivityLauncherBinding
import com.example.currencyexchangeapp.factory.CurrencyFactory
import com.example.currencyexchangeapp.viewmodel.CurrencyViewModel

class LauncherActivity : AppCompatActivity() {
    lateinit var binding:ActivityLauncherBinding
    lateinit var myViewModel:CurrencyViewModel
   lateinit var factory:CurrencyFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_launcher)

        factory=CurrencyFactory(this)
        myViewModel = ViewModelProvider(this,factory)[CurrencyViewModel::class.java]

        val intent = Intent(this, MainActivity::class.java)
        myViewModel.getCurrency().observe(this, Observer {
            intent.putExtra("arrayList", it as ArrayList<String>)
        })

        var x=myViewModel.preference.getBoolean("flag",false)

        if(x==false){
            myViewModel.getCurrency().observe(this, Observer {
                intent.putExtra("arrayList", it as ArrayList<String>)
                startActivity(intent)
            })
        }
        else{

            var temp=myViewModel.second()
            intent.putExtra("arrayList", temp)
            startActivity(intent)
        }


    }


}

