package com.example.m8_animation_sharedelement_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.m8_animation_sharedelement_fragment.databinding.ActivityMainBinding
val carList = listOf(
    Car(R.drawable.corvette_c6, "Corvette C6"),
    Car(R.drawable.ford_focus_gt, "Ford Focus GT"),
    Car(R.drawable.gtr, "Nissan GTR"),
    Car(R.drawable.porsche_gt3, "Porsche GT3"),
    Car(R.drawable.silvia, "Toyota Silvia"),
    Car(R.drawable.subaru_wrx_sti, "Subaru WRX STI"),
    Car(R.drawable.supra, "Toyota Supra"),
    Car(R.drawable.z350, "Nissan Z250")
)
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace<RecyclerViewFragment>(R.id.fragment_container)
        }
    }
}
