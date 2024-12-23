package com.example.lab4

import androidx.room.*

@Entity(tableName = "participants")
data class Participant(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)
