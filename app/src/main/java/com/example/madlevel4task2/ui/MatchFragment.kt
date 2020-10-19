package com.example.madlevel4task2.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.madlevel4task2.R
import com.example.madlevel4task2.databinding.FragmentMatchBinding

private const val ROCK = 0
private const val PAPER = 1
private const val SCISSORS = 2

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MatchFragment : Fragment() {

    private lateinit var binding: FragmentMatchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun randomize() : Int{
        val randomNumber = (0..2).random()
        when(randomNumber) {
            0 -> binding.ivComputer.setImageResource(R.drawable.rock)
            1 -> binding.ivComputer.setImageResource(R.drawable.paper)
            2 -> binding.ivComputer.setImageResource(R.drawable.scissors)
        }
        return randomNumber
    }

    private fun initViews() {
        binding.ivRock.setOnClickListener {
            binding.ivYou.setImageResource(R.drawable.rock)
            playMatch(ROCK)
        }
        binding.ivPaper.setOnClickListener {
            binding.ivYou.setImageResource(R.drawable.paper)
            playMatch(PAPER)
        }
        binding.ivScissors.setOnClickListener {
            binding.ivYou.setImageResource(R.drawable.scissors)
            playMatch(SCISSORS)
        }
    }

    private fun playMatch(hand: Int) {
        val pcHand = randomize()

        when (hand) {
            ROCK -> when (pcHand) {
                ROCK -> {
                    binding.tvResult.text = getString(R.string.text_draw)
                }
                PAPER -> {
                    binding.tvResult.text = getString(R.string.text_lose)
                }
                SCISSORS -> {
                    binding.tvResult.text = getString(R.string.text_win)
                }
            }

            PAPER -> when (pcHand) {
                PAPER -> {
                    binding.tvResult.text = getString(R.string.text_draw)
                }
                SCISSORS -> {
                    binding.tvResult.text = getString(R.string.text_lose)
                }
                ROCK -> {
                    binding.tvResult.text = getString(R.string.text_win)
                }
            }

            SCISSORS -> when (pcHand) {
                SCISSORS -> {
                    binding.tvResult.text = getString(R.string.text_draw)
                }
                ROCK -> {
                    binding.tvResult.text = getString(R.string.text_lose)
                }
                PAPER -> {
                    binding.tvResult.text = getString(R.string.text_win)
                }
            }
        }
    }

}