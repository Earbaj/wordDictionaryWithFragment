package com.example.worddictionarywithfragment.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ListAdapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.worddictionarywithfragment.R
import com.example.worddictionarywithfragment.adapter.LetterListAdapter
import com.example.worddictionarywithfragment.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayout: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val views = inflater.inflate(R.layout.fragment_list, container, false)
        _binding = FragmentListBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerView
        recyclerView.adapter = LetterListAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    private fun choseLayout(){
        if (isLinearLayout){
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }else {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        }
        recyclerView.adapter = LetterListAdapter()
    }

    private fun menuIcon(menuItem: MenuItem?){
        if(menuItem == null){
            return
        }

        menuItem.icon = if (isLinearLayout){
            ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
        }else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_item, menu)
        val actionButton = menu.findItem(R.id.menu_button)
        return menuIcon(actionButton)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_button -> {
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
                isLinearLayout = !isLinearLayout
                // Sets layout and icon
                choseLayout()
                menuIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}