package com.example.cakeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cakeapp.databinding.FragmentCakesBinding
import com.example.cakeapp.model.OrderViewModel

class CakesFragment : Fragment() {

    private var binding: FragmentCakesBinding? = null

    private lateinit var cakesFragment: CakesFragment

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCakesBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            cakesFragment = this@CakesFragment
        }
    }

    fun clickNext(){
        findNavController().navigate(R.id.action_cakesFragment_to_orderSummaryFragment)
    }

}