package com.info.cryptotracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import com.info.cryptotracker.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)

        binding.btnList.setOnClickListener {

            val kecis = ListFragmentDirections.actionListFragmentToDetailFragment(5,"5in yaninda" )

            Navigation.findNavController(it).navigate(kecis)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)

    }

}