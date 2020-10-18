package com.example.madlevel4task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "match_table")
data class Match(
    @ColumnInfo(name = "player_move")
    var playerMove: String,

    @ColumnInfo(name = "computer_move")
    var computerMove: String,

    @ColumnInfo(name = "result")
    var result: String,

    @ColumnInfo(name = "date")
    var matchDate: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)