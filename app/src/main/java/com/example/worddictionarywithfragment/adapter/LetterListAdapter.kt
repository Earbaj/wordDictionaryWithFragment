package com.example.worddictionarywithfragment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.worddictionarywithfragment.R
import com.example.worddictionarywithfragment.ui.ListFragmentDirections
import com.example.worddictionarywithfragment.ui.WordFragment

class LetterListAdapter: RecyclerView.Adapter<LetterListAdapter.LetterViewHolder>(){

    private val letters = ('A').rangeTo('Z').toList()

    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.btn_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        var res = letters[position]
        holder.button.text = res.toString()
        holder.button.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToWordFragment(letter = holder.button.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return letters.size
    }
}