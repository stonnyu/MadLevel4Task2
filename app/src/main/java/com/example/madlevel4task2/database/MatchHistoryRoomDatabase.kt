package com.example.madlevel4task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.madlevel4task2.dao.MatchDao
import com.example.madlevel4task2.model.Match

@Database(entities = [Match::class], version = 1, exportSchema = false)
abstract class MatchHistoryRoomDatabase : RoomDatabase() {

    abstract fun matchDao(): MatchDao

    companion object {
        private const val DATABASE_NAME = "MATCH_HISTORY_DATABASE"

        @Volatile
        private var matchHistoryRoomDatabaseInstance: MatchHistoryRoomDatabase? = null

        fun getDatabase(context: Context): MatchHistoryRoomDatabase? {
            if (matchHistoryRoomDatabaseInstance == null) {
                synchronized(MatchHistoryRoomDatabase::class.java) {
                    if (matchHistoryRoomDatabaseInstance == null) {
                        matchHistoryRoomDatabaseInstance =
                            Room.databaseBuilder(context.applicationContext,
                                MatchHistoryRoomDatabase::class.java, DATABASE_NAME
                            ).build()
                    }
                }
            }
            return matchHistoryRoomDatabaseInstance
        }
    }

}
