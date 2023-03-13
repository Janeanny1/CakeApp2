package com.example.cakeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cakeapp.databinding.FragmentWeddingBinding
import com.example.cakeapp.model.OrderViewModel

class WeddingFragment : Fragment() {

    private var binding: FragmentWeddingBinding? = null
    private lateinit var weddingFragment: WeddingFragment

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentWeddingBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            weddingFragment = this@WeddingFragment
        }
    }

    fun clickNext (){
        findNavController().navigate(R.id.action_weddingFragment_to_orderSummaryFragment)

    }

}