package com.example.secondhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.secondhomework.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val itemList = ModelFactory.generateModels((3..10).random())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ItemAdapter(itemList,
            onItemClick = { item ->
                val bundle = Bundle().apply {
                    putString("title", item.title)
                    putString("description", item.description)
                    putInt("imageResId", item.imageResId)
                }
                findNavController().navigate(R.id.action_first_to_second, bundle)
            },
            onImageClick = { }
        )
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}