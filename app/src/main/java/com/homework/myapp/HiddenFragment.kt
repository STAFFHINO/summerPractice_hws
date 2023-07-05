package com.homework.myapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
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

        val className = arguments?.getString(ARG_NAME)
        if (className != null) {
            Snackbar.make(binding!!.root, className, Snackbar.LENGTH_LONG).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"
        fun createBundle(name: String): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            return bundle
        }
    }
}
