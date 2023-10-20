package com.example.currencyexchangeapp.repository


import androidx.lifecycle.MutableLiveData
import com.example.currencyexchangeapp.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyRepository {
    var currencyDataList = MutableLiveData<List<String>>()
    var exchangeData = MutableLiveData<Double>()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = true
    }
    var isExchanging: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun getCurrencyList(): MutableLiveData<List<String>> {
        var call = Retrofit.apiCall.getCurrencyList()

        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {
                if (response.isSuccessful) {
                    currencyDataList.value = response.body()
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                isLoading.value=false
            }
        })
        return currencyDataList
    }

    fun exchangedCurrency(from: String, to: String, quantity: Double): MutableLiveData<Double> {
        var call = Retrofit.apiCall.getConvertResult(from, to, quantity)

        call.enqueue(object : Callback<Double> {
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    exchangeData.value = response.body()
                    isExchanging.value = false
                }
            }

            override fun onFailure(call: Call<Double>, t: Throwable) {
                isExchanging.value = false
            }

        })
        return exchangeData
    }



}