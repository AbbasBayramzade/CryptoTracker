package com.info.cryptotracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.cryptotracker.databinding.FragmentListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    private var listCryptos:MutableList<CryptosItem> = mutableListOf<CryptosItem>()
    private val adapter:CryptosAdapter by lazy{CryptosAdapter(requireContext(),listCryptos)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)

        listCryptos = mutableListOf()
        binding.rvMain.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMain.adapter = adapter



        getCryptosData()

        // Inflate the layout for this fragment
        return binding.root

    }

    private fun getCryptosData(){

        ApiClient.apiService.getCryptos().enqueue(object : Callback<List<CryptosItem>> {

            override fun onFailure(call: Call<List<CryptosItem>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("error", it) }
            }

            override fun onResponse(
                call: Call<List<CryptosItem>>,
                response: Response<List<CryptosItem>>
            ) {
                val CryptosResponse = response.body()
                listCryptos.clear()
                CryptosResponse?.let {
                    listCryptos.addAll(it)
                    adapter.notifyDataSetChanged()
                }
            }

        })

    }

}
