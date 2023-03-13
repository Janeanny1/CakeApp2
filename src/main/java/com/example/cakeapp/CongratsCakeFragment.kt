package com.example.cakeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cakeapp.databinding.FragmentCongratsCakeBinding
import com.example.cakeapp.model.OrderViewModel

class CongratsCakeFragment : Fragment() {

    private var binding: FragmentCongratsCakeBinding? = null

    private lateinit var congratsCakeFragment: CongratsCakeFragment

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCongratsCakeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            congratsCakeFragment  = this@CongratsCakeFragment

        }
    }

    fun clickNext() {
        findNavController().navigate(R.id.action_congratsCakeFragment_to_orderSummaryFragment)
    }
}