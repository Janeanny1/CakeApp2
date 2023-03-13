package com.example.cakeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cakeapp.databinding.FragmentCupCakesBinding
import com.example.cakeapp.model.OrderViewModel

class CupCakesFragment : Fragment() {

    private var binding: FragmentCupCakesBinding? = null

    private lateinit var cupCakesFragment: CupCakesFragment

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCupCakesBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
          cupCakesFragment = this@CupCakesFragment
        }
    }

    fun clickNext () {
        findNavController().navigate(R.id.action_cupCakesFragment_to_orderSummaryFragment)
    }
}