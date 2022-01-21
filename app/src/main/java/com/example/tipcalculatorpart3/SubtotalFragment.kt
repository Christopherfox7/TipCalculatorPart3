package com.example.tipcalculatorpart3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tipcalculatorpart3.databinding.FragmentSubtotalBinding
import com.example.tipcalculatorpart3.databinding.FragmentTipFragmentBinding

class SubtotalFragment : Fragment() {
    private var _binding: FragmentSubtotalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubtotalBinding.inflate(inflater, container,false)
        val rootView = binding.root

        // Inflate the layout for this fragment
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}