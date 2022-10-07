package com.info.cryptotracker

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.info.cryptotracker.databinding.FragmentListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment(), CryptosAdapter.OnItemSelectedListener {
    private lateinit var binding: FragmentListBinding

    private var listCryptos:MutableList<CryptosItem> = mutableListOf<CryptosItem>()
    private val adapter:CryptosAdapter by lazy{CryptosAdapter(this, requireContext(),listCryptos)}


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)

        listCryptos = mutableListOf()
        binding.rvMain.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMain.adapter = adapter

        getCryptosData()

        showData(listCryptos)

        // Inflate the layout for this fragment
        return binding.root

    }

    fun showData(list: List<CryptosItem>){

       /* adapter.onItemClick = { contact ->

            // do something with your item
            d("TAG", contact.name)

//            val kecis = ListFragmentDirections.actionListFragmentToDetailFragment()
//            view?.let { Navigation.findNavController(it).navigate(kecis) }

        }*/
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

    override fun onSelect(id: String) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(id))
//        Toast.makeText(requireContext(), id, LENGTH_SHORT).show()
    }

}
