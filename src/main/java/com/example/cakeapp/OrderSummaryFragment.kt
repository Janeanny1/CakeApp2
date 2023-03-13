package com.example.cakeapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cakeapp.databinding.FragmentOrderSummaryBinding
import com.example.cakeapp.model.OrderViewModel

class OrderSummaryFragment : Fragment() {

    private var binding: FragmentOrderSummaryBinding? = null

    private lateinit var orderSummaryFragment: OrderSummaryFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentOrderSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            orderSummaryFragment = this@OrderSummaryFragment
        }
    }

    private val sharedViewModel: OrderViewModel by activityViewModels()

       fun submit () {
            val numberOfCakes = sharedViewModel.quantity.value ?: 0
            val orderDetail = getString(
                R.string.order_details,
                resources.getQuantityString(R.plurals.cakes, numberOfCakes, numberOfCakes),
                sharedViewModel.flavor.value.toString(),
                sharedViewModel.date.value.toString(),
                sharedViewModel.price.value.toString()
            )

            val intent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_cake_order))
                .putExtra(Intent.EXTRA_TEXT, orderDetail)

            if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
                startActivity(intent)
            }
        }
        fun cancel (){
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_orderSummaryFragment_to_startFragment)
        }

      override fun onDestroyView() {
            super.onDestroyView()
            binding = null
        }
}