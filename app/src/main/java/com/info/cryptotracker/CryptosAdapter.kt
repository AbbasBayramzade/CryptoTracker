package com.info.cryptotracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.info.cryptotracker.databinding.CryptoItemBinding

class CryptosAdapter(private var itemClickListener: OnItemSelectedListener, private val context: Context,private var list: List<CryptosItem>):RecyclerView.Adapter<CryptosAdapter.MyViewHolder>() {

//    private lateinit var mListener: onItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

         var binding:CryptoItemBinding

        binding = CryptoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(binding.root) //mlistener

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var crpto = list[position]

        holder.name.text = "adi : ${crpto.name}"
        holder.symbol.text = "Simvol : ${crpto.symbol}"
        holder.itemView.setOnClickListener {
            itemClickListener.onSelect(crpto.id)
        }


    }

    override fun getItemCount(): Int {

        return list.size

    }

    interface OnItemSelectedListener{
        fun onSelect(id: String)
    }

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
          var name:TextView = view.findViewById(R.id.txt_name)
          var symbol:TextView = view.findViewById(R.id.txt_symbol)

    }

}

