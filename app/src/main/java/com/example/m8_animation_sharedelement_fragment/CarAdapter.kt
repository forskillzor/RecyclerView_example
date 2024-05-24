package com.example.m8_animation_sharedelement_fragment

import android.app.ActivityOptions
import androidx.fragment.app.FragmentManager
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.RecyclerView
import com.example.m8_animation_sharedelement_fragment.databinding.CarItemBinding

class CarAdapter(
    private val carList: List<Car>,
    private val fragment: RecyclerViewFragment
) : RecyclerView.Adapter<CarAdapter.CarHolder>() {

    inner class CarHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val binding = CarItemBinding.bind(item)
        fun bind(car: Car) = with(binding) {
            carImage.setImageResource(car.imageId)
            carName.text = car.carName
            item.setOnClickListener {
                fragment.commit(sharedImage = carImage, sharedText = carName, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return CarHolder(view)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int {
        return carList.size
    }

}
