package com.example.madlevel4task2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.model.Match
import com.example.madlevel4task2.R
import kotlinx.android.synthetic.main.item_match.view.*

class MatchAdapter(private val matches: List<Match>) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(match: Match) {
            itemView.tvHistoryDate.text = match.matchDate
            itemView.tvMatchHistoryResult.text = match.result

            when (match.playerMove){
                ROCK -> itemView.ivMatchHistoryYou.setImageResource(R.drawable.rock)
                PAPER -> itemView.ivMatchHistoryYou.setImageResource(R.drawable.paper)
                SCISSORS -> itemView.ivMatchHistoryYou.setImageResource(R.drawable.scissors)
            }

            when (match.computerMove){
                ROCK -> itemView.ivMatchHistoryComputer.setImageResource(R.drawable.rock)
                PAPER -> itemView.ivMatchHistoryComputer.setImageResource(R.drawable.paper)
                SCISSORS -> itemView.ivMatchHistoryComputer.setImageResource(R.drawable.scissors)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(matches[position])
    }

}