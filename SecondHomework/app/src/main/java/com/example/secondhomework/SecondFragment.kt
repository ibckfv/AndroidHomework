package com.example.secondhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.secondhomework.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            binding.titleText.text = it.getString("title")
            binding.descriptionText.text = it.getString("description")
            binding.largeImage.setImageResource(it.getInt("imageResId"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}