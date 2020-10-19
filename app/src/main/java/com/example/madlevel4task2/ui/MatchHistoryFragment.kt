package com.example.madlevel4task2.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.model.Match
import com.example.madlevel4task2.repository.MatchRepository
import com.example.madlevel4task2.R
import kotlinx.android.synthetic.main.fragment_match_history.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MatchHistoryFragment : Fragment() {

    private lateinit var matchRepository: MatchRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val matches = arrayListOf<Match>()
    private val matchAdapter = MatchAdapter(matches)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchRepository = MatchRepository(requireContext())
        initRv()
        getMatchHistoryFromDatabase()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_match_history, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_delete_all -> {
                removeAllProducts()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initRv() {
        rvMatches.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvMatches.adapter = matchAdapter
        rvMatches.addItemDecoration(
            DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL)
        )
    }

    private fun removeAllProducts() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                matchRepository.deleteAllMatches()
            }
            getMatchHistoryFromDatabase()
        }
    }

    private fun getMatchHistoryFromDatabase() {
        mainScope.launch {
                val productList = withContext(Dispatchers.IO) {
                    matchRepository.getAllMatches()
                }
                this@MatchHistoryFragment.matches.clear()
                this@MatchHistoryFragment.matches.addAll(productList)
                this@MatchHistoryFragment.matchAdapter.notifyDataSetChanged()
        }
    }

}