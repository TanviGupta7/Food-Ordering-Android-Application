package com.angel6677.wavesoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.angel6677.wavesoffood.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.denzcoskun.imageslider.interfaces.ItemClickListener

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.post {
            val imageList = ArrayList<SlideModel>()
            imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
            imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
            imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

            val imageSlider = binding.imageSlider
            imageSlider.setImageList(imageList, ScaleTypes.FIT)

            // Implement both required methods of ItemClickListener
            imageSlider.setItemClickListener(object : ItemClickListener {
                override fun onItemSelected(position: Int) {
                    val message = "Selected image at position: $position"
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                }

                override fun doubleClick(position: Int) {
                    val message = "Double-clicked image at position: $position"
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
