package com.info.cryptotracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.cryptotracker.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment(), CryptosAdapter.OnItemSelectedListener {
    private lateinit var binding: FragmentDetailBinding

    private var listCryptos:MutableList<CryptosItem> = mutableListOf<CryptosItem>()
    private val adapter:CryptosAdapter by lazy{CryptosAdapter(this, requireContext(),listCryptos)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        listCryptos = mutableListOf()
        binding.rvDetail.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDetail.adapter = adapter


        val bundle:DetailFragmentArgs by navArgs()

        getCryptosData(bundle.clickedItemID)

//        val bundle:DetailFragmentArgs by navArgs()
//
//        val gelenId = bundle.clickedItemID

        

        // Inflate the layout for this fragment
        return binding.root

    }

    private fun getCryptosData(id: String){

        ApiClient.apiService.getCryptoDetails(id).enqueue(object : Callback<CryptosItemDetail> {

            override fun onFailure(call: Call<CryptosItemDetail>, t: Throwable) {
                t.localizedMessage?.let { Log.e("error", it) }
            }

            override fun onResponse(
                call: Call<CryptosItemDetail>,
                response: Response<CryptosItemDetail>
            ) {
                val cryptosResponse = response.body()
                cryptosResponse?.let {
                    binding.id.text = it.id
                }
            }

        })

    }

    override fun onSelect(id: String) {
        //Bu id ile yeni fragment achmali ve ona uyghun data getirmeli
    }

}