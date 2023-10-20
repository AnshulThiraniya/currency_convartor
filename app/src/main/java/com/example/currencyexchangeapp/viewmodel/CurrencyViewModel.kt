package com.example.currencyexchangeapp.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyexchangeapp.repository.CurrencyRepository

class CurrencyViewModel(context: Context) : ViewModel() {
    var myRepository = CurrencyRepository()
    var isLoading: MutableLiveData<Boolean> = myRepository.isLoading
    var isConverting: MutableLiveData<Boolean> = myRepository.isExchanging
    var list: MutableLiveData<List<String>> = MutableLiveData()
    var flag=false



   var preference = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    var editor = preference.edit()

    fun getCurrency(): MutableLiveData<List<String>> {
            list = myRepository.getCurrencyList()
            val nameList=ArrayList<String>()
            nameList.add("SGD")
            nameList.add("MYR")
            nameList.add("EUR")
            nameList.add("USD")
            nameList.add("AUD")
            nameList.add("JPY")
            nameList.add("CNH")
            nameList.add("HKD")
            nameList.add("CAD")
            nameList.add("INR")
            nameList.add("DKK")
            nameList.add("GBP")
            nameList.add("RUB")
            nameList.add("NZD")
            nameList.add("MXN")
            nameList.add("IDR")
            nameList.add("TWD")
            nameList.add("THB")
            nameList.add("VND")

            for (i in 0..18) {
                editor.putString("$i",nameList[i])
                editor.apply()
            }

           editor.putBoolean("flag",true)
            editor.apply()
            return list

    }

    fun second():ArrayList<String>{

            val Data = ArrayList<String>()
            for (i in 0 ..18) {
                val value = preference.getString("$i", "")
                Data.add(value!!)

            }
            return Data

    }



    fun getExchangeData(from: String, to: String, quantity: Double): MutableLiveData<Double> {
        return myRepository.exchangedCurrency(from, to, quantity)
    }
}
