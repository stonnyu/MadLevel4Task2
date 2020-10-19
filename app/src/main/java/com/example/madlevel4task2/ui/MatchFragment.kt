package com.example.madlevel4task2.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.madlevel4task2.R
import com.example.madlevel4task2.databinding.FragmentMatchBinding
import com.example.madlevel4task2.model.Match
import com.example.madlevel4task2.repository.MatchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

private const val ROCK = 0
private const val PAPER = 1
private const val SCISSORS = 2

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MatchFragment : Fragment() {

    private lateinit var binding: FragmentMatchBinding
    private lateinit var matchRepository: MatchRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchRepository = MatchRepository(requireContext())
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
        var result = binding.tvResult.text

        when (hand) {
            ROCK -> when (pcHand) {
                ROCK -> {
                    result = getString(R.string.text_draw)
                }
                PAPER -> {
                    result = getString(R.string.text_lose)
                }
                SCISSORS -> {
                    result = getString(R.string.text_win)
                }
            }

            PAPER -> when (pcHand) {
                PAPER -> {
                    result = getString(R.string.text_draw)
                }
                SCISSORS -> {
                    result = getString(R.string.text_lose)
                }
                ROCK -> {
                    result = getString(R.string.text_win)
                }
            }

            SCISSORS -> when (pcHand) {
                SCISSORS -> {
                    result = getString(R.string.text_draw)
                }
                ROCK -> {
                    result = getString(R.string.text_lose)
                }
                PAPER -> {
                    result = getString(R.string.text_win)
                }
            }
        }


        mainScope.launch {
            val date = SimpleDateFormat("yyyy.MM.dd HH:mm:ss z")

            val match = Match(
                playerMove = hand,
                computerMove = pcHand,
                result = result.toString(),
                matchDate = date.format(Date())
            )

            withContext(Dispatchers.IO) {
                matchRepository.insertMatch(match)
            }

            getMatchHistoryFromDatabase()
        }
    }

    private fun getMatchHistoryFromDatabase() {
        mainScope.launch {
            val matchList = withContext(Dispatchers.IO) {
                matchRepository.getAllMatches()
            }
        }
    }

}