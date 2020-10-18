package com.example.madlevel4task2.repository

import android.content.Context
import com.example.madlevel4task2.dao.MatchDao
import com.example.madlevel4task2.database.MatchHistoryRoomDatabase
import com.example.madlevel4task2.model.Match

class MatchRepository(context: Context) {

    private val matchDao: MatchDao

    init {
        val database = MatchHistoryRoomDatabase.getDatabase(context)
        matchDao = database!!.matchDao()
    }

    suspend fun getAllMatches(): List<Match> {
        return matchDao.getAllMatches()
    }

    suspend fun insertMatch(match: Match) {
        matchDao.insertMatch(match)
    }

    suspend fun deleteMatch(match: Match) {
        matchDao.deleteMatch(match)
    }

    suspend fun deleteAllMatches() {
        matchDao.deleteAllMatches()
    }

}
