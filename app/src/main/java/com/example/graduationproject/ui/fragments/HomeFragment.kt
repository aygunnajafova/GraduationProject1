package com.example.graduationproject.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.databinding.FragmentHomeBinding
import com.example.graduationproject.ui.adapter.FoodAdapter
import com.example.graduationproject.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.homeFragment = this

        binding.toolbarHomeTitle = "Great Foods are waiting for you!"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)


        binding.foodAdapter = FoodAdapter(requireContext(), viewModel.foodsList, viewLifecycleOwner)

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.home_toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFoods()
        //Return to HomeFragment and reload persons
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }
}