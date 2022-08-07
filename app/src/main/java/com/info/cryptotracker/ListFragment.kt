package com.info.cryptotracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.info.cryptotracker.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)

        binding.btnList.setOnClickListener {

            val kecis = ListFragmentDirections.actionListFragmentToDetailFragment(75)

            Navigation.findNavController(it).navigate(kecis)
        }
        // Inflate the layout for this fragment
        return binding.root

    }

}
