package com.example.graduationproject.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.databinding.FragmentDetailBinding
import com.example.graduationproject.ui.viewmodel.DetailViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.detailFragment = this

        binding.toolbarDetailTitle = "You will like this!"

        val bundle:DetailFragmentArgs by navArgs()
        binding.food = bundle.food

        binding.btnAddToCart.setOnClickListener {
            viewModel.add(bundle.food)

            Navigation.findNavController(it).popBackStack()
            Snackbar.make(it, "Added to Cart", Snackbar.LENGTH_SHORT).show()
        }

        binding.textViewAmount.text = "0"
        viewModel.amount.observe(viewLifecycleOwner) {
            binding.textViewAmount.text = it.toString()
        }

        binding.btnIncrement.setOnClickListener {
            viewModel.increment()
        }
        binding.btnDecrement.setOnClickListener {
            viewModel.decrement()
        }

        binding.toolbarDetail.setNavigationIcon(R.drawable.back_arrow_icon)
        binding.toolbarDetail.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

}