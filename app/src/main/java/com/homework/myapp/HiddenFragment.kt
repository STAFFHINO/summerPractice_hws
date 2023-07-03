package com.homework.myapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.homework.myapp.databinding.FragmentHiddenBinding


class HiddenFragment : Fragment(R.layout.fragment_hidden) {
    private var binding: FragmentHiddenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHiddenBinding.bind(view)

        binding?.run {
            btnToHistory.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}