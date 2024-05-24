package com.example.m8_animation_sharedelement_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater
import com.example.m8_animation_sharedelement_fragment.databinding.FragmentCarDetailsBinding

class CarDetailsFragment : Fragment() {
    companion object {
        const val POSITION = "position"
    }
    private var _binding: FragmentCarDetailsBinding? = null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var _adapterPosition: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _adapterPosition = it.getInt(CarDetailsFragment.POSITION)
        }
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.grid_transition)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val id = _adapterPosition!!
            val car = carList[id]
            carImage.setImageResource(car.imageId)
            carName.text = car.carName
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}