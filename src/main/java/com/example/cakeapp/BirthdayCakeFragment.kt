package com.example.cakeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cakeapp.databinding.FragmentBirthdayCakeBinding
import com.example.cakeapp.model.OrderViewModel

class BirthdayCakeFragment : Fragment() {

    private var binding: FragmentBirthdayCakeBinding? = null

    private lateinit var birthdayCakeFragment: BirthdayCakeFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentBirthdayCakeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
           birthdayCakeFragment = this@BirthdayCakeFragment

        }

    }
    private val sharedViewModel: OrderViewModel by activityViewModels()

   fun clickNext(){
       findNavController().navigate(R.id.action_birthdayCakeFragment_to_orderSummaryFragment)
   }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}