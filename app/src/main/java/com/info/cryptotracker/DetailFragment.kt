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

        Toast.makeText(context, "data sending : $gelenEded", Toast.LENGTH_LONG).show()

        binding.etTitle.text = gelenEded.toString()

        // Inflate the layout for this fragment
        return binding.root
    }

}