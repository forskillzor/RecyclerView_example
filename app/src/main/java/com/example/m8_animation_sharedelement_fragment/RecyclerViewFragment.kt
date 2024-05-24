package com.example.m8_animation_sharedelement_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m8_animation_sharedelement_fragment.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {
    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!
    private var _adapter: CarAdapter? = null
    private val adapter get() = _adapter!!

    fun commit(sharedImage: View, sharedText: View, position: Int) {
        val bundle = Bundle().apply {
            putInt(CarDetailsFragment.POSITION, position)
        }
        ViewCompat.setTransitionName(sharedImage, "image_transition_item")
        ViewCompat.setTransitionName(sharedText, "text_transition_item")
        parentFragmentManager.commit {
            addSharedElement(sharedImage, "image_transition_item")
            addSharedElement(sharedText, "text_transition_item")
            replace<CarDetailsFragment>(R.id.fragment_container, args = bundle)
            addToBackStack(null)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        _adapter = CarAdapter(carList, parentFragmentManager, this)
        _adapter = CarAdapter(carList, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerViewBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        binding.apply {
            rcv.layoutManager = LinearLayoutManager(context)
            rcv.adapter = adapter
        }
    }
}