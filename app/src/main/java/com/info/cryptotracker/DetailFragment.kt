package com.info.cryptotracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.info.cryptotracker.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        val bundle:DetailFragmentArgs by navArgs()

        val gelenEded = bundle.eded
        val gelenString = bundle.test

        Log.e("Gelen reqem", gelenEded.toString())
        Log.e("Gelen string",gelenString)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

}