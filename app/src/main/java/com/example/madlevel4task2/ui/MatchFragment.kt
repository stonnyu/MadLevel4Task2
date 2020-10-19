package com.example.madlevel4task2.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.madlevel4task2.R
import com.example.madlevel4task2.databinding.FragmentMatchBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MatchFragment : Fragment() {

    private lateinit var binding: FragmentMatchBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun updateUI() {
//        binding.setImageResource(R.drawable.dice1)
//        binding.imgDice.setImageResource(R.drawable.dice2)
    }

    private fun initViews() {
        updateUI()
//        binding.btnHigher.setOnClickListener {
//            onHigherClick()
//        }
//        binding.btnLower.setOnClickListener {
//            onLowerClick()
//        }
//        binding.btnEquals.setOnClickListener {
//            onEqualClick()
//        }
    }

}